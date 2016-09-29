package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.CommentsVo;

@Repository
public class CommentsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommentsVo> getList(CommentsVo vo) {
		List<CommentsVo> list = sqlSession.selectList("comments.getByNoticeNo", vo);
		return list;
	}
	
	public void commentsWrite(CommentsVo vo) {
		sqlSession.insert("comments.insert", vo);
	}
	
	public CommentsVo commentsAccusation(Long no) {
		CommentsVo vo = sqlSession.selectOne("comments.getByNo", no);
		return vo;
	}
	
	public void deleteComments(Long no) {
		sqlSession.delete("comments.delete", no);
	}
	
	public CommentsVo getCommentsList(Long no) {
		CommentsVo vo = sqlSession.selectOne("comments.getByNo", no);
		return vo;
	}
	
	public Integer listCount(Long no) {
		int count = sqlSession.selectOne("comments.listCount", no);
		return count;
	}
	
	public void updateState(Long no) {
		sqlSession.update("comments.updateState", no);
	}
}