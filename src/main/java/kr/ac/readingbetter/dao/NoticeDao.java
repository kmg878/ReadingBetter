package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.NoticeVo;

@Repository
public class NoticeDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeVo> getList(NoticeVo vo) {
		List<NoticeVo> list = sqlSession.selectList("notice.list", vo);
		return list;
	}
	
	public List<NoticeVo> listPage(NoticeVo vo) {
		List<NoticeVo> list = sqlSession.selectList("notice.listPage", vo);
		return list;
	}
	
	public void noticeWrite(NoticeVo vo){
		sqlSession.insert("notice.insert", vo);
	}
	
	public NoticeVo noticeView(Long no) {
		NoticeVo vo = sqlSession.selectOne("notice.getByNo", no);
		return vo;
	}
	
	public void noticeModify(NoticeVo vo){
		sqlSession.update("notice.update", vo);
	}
	
	public void viewCount(Long no){
		sqlSession.update("notice.viewCount", no);
	}
	
	public Integer listCount() {
		int count = sqlSession.selectOne("notice.listCount");
		return count;
	}
}
