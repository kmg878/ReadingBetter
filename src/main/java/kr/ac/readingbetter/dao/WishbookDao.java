package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.WishbookVo;

@Repository
public class WishbookDao {

	@Autowired
	private SqlSession sqlSession;

	public List<WishbookVo> getList() {
		List<WishbookVo> list = sqlSession.selectList("wishbook.list");
		return list;
	}

	public WishbookVo getView(WishbookVo vo) {
		vo = sqlSession.selectOne("wishbook.getByNo", vo);
		return vo;
	}

	public void insertPublisher(WishbookVo vo) {
		sqlSession.insert("wishbook.insertPublisher", vo);
	}

	public void insertBook(WishbookVo vo) {
		sqlSession.insert("wishbook.insertBook", vo);
	}

	public void updateAcceptToOne(WishbookVo vo) {
		sqlSession.update("wishbook.updateAcceptToOne", vo);
	}

	public void updateAcceptToTwo(WishbookVo vo) {
		sqlSession.update("wishbook.updateAcceptToTwo", vo);
	}

	public void insertWishbook(WishbookVo vo) {
		sqlSession.insert("wishbook.insertWishbook", vo);
	}

	public void updateRecommend(Long no) {
		sqlSession.update("wishbook.updateRecommend", no);
	}
}
