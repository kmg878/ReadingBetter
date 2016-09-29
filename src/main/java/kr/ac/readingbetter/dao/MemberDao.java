package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;

	public List<MemberVo> getList(MemberVo vo) {
		List<MemberVo> list = sqlSession.selectList("member.list", vo);
		return list;
	}

	public void delete(MemberVo vo) {
		sqlSession.delete("member.delete", vo);
	}

	public MemberVo selectAuthUser(MemberVo vo) {
		vo = sqlSession.selectOne("member.selectAuthUser", vo);
		return vo;
	}

	public MemberVo checkId(String id) {
		MemberVo vo = sqlSession.selectOne("member.checkId", id);
		return vo;
	}

	public MemberVo checkEmail(String email) {
		MemberVo vo = sqlSession.selectOne("member.checkEmail", email);
		return vo;
	}

	public void insertMember(MemberVo vo) {
		sqlSession.insert("member.insertMember", vo);
	}

	public MemberVo selectMyinfo(Long no) {
		MemberVo vo = sqlSession.selectOne("member.selectMyinfo", no);
		return vo;
	}

	public void updateMember(MemberVo vo) {
		sqlSession.update("member.updateMember", vo);
	}

	public void updateMemberWithPw(MemberVo vo) {
		sqlSession.update("member.updateMemberWithPw", vo);
	}
	
	public MemberVo findId(MemberVo vo) {
		vo = sqlSession.selectOne("member.findId", vo);
		return vo;
	}
}