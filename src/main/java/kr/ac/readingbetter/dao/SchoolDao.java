package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.SchoolVo;

@Repository
public class SchoolDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<SchoolVo> getList(String kwd){
		List<SchoolVo> list = sqlSession.selectList("school.list", kwd);
		
		return list;
	}
	
	public void insertSchool(String title){
		sqlSession.insert("school.insert", title);
	}
	
	public List<SchoolVo> selectSchoolTitle() {
		List<SchoolVo> list = sqlSession.selectList("school.selectSchoolTitle");
		return list;
	}
}