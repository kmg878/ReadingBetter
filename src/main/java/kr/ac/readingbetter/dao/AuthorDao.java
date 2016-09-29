package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.AuthorVo;

@Repository
public class AuthorDao {

	@Autowired
	private SqlSession sqlSession;

	public List<AuthorVo> getList(AuthorVo vo) {
		List<AuthorVo> list = sqlSession.selectList("author.list", vo);
		return list;
	}

	public void insert(AuthorVo vo) {
		sqlSession.insert("author.insert", vo);
	}
}