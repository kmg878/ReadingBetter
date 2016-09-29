package kr.ac.readingbetter.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.CertificationVo;

@Repository
public class CertificationDao {

	@Autowired
	private SqlSession sqlSession;

	public CertificationVo selectCertification(CertificationVo vo) {
		vo = sqlSession.selectOne("certification.selectCertification", vo);
		return vo;
	}

	public void insertCertification(CertificationVo vo) {
		sqlSession.insert("certification.insertCertification", vo);
	}
}