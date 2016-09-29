package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.HistoryVo;

@Repository
public class HistoryDao {
	@Autowired
	private SqlSession sqlSession;

	public void insertHistory(HistoryVo vo) {
		sqlSession.insert("history.insertHistory", vo);
	}

	public List<HistoryVo> getList(HistoryVo vo) {
		List<HistoryVo> list = sqlSession.selectList("history.list", vo);
		return list;
	}
}