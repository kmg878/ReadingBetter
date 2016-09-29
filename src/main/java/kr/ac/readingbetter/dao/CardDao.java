package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.CardVo;

@Repository
public class CardDao {

	@Autowired
	private SqlSession sqlSession;

	public List<CardVo> getList(CardVo vo) {
		return sqlSession.selectList("card.getList", vo);
	}

	public void deleteCard(Long no) {
		sqlSession.delete("card.delete", no);
	}

	public void insertCard(CardVo vo) {
		sqlSession.insert("card.insert", vo);
	}

	public CardVo getCardByNo(Long no) {
		return sqlSession.selectOne("card.getByNo", no);
	}

	public void updateCard(CardVo vo) {
		sqlSession.update("card.update", vo);
	}

	public CardVo selectCardByRandom() {
		CardVo vo = sqlSession.selectOne("card.selectCardByRandom");
		return vo;
	}
}