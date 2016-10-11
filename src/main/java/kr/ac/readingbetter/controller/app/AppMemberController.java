package kr.ac.readingbetter.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.MemberService;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.ScoresVo;

@Controller
@RequestMapping("/memberapp")
public class AppMemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public MemberVo historyapp(String id,String pw,MemberVo vo) {
		System.out.println("연결"+id+pw);
		vo.setId(id);
		vo.setPw(pw);
		MemberVo authUser = memberService.selectAuthUser(vo);
		
		return authUser;
	}
	
	@ResponseBody
	   @RequestMapping(value = "login", method = RequestMethod.GET)
	   public void joinApp(MemberVo memberVo, String name, String id, String pw, String email, String tel) {
	      memberVo.setGrade(0);
	      memberVo.setClassNo(0);
	      memberVo.setSchoolName("기타");

	      memberVo.setName(name);
	      memberVo.setId(id);
	      memberVo.setPw(pw);
	      memberVo.setEmail(email);
	      memberVo.setTel(tel);
	      System.out.println(memberVo);
	      memberService.insertMember(memberVo);
	   }

	   // 회원가입시 아이디 체크
	   @RequestMapping(value = "/checkid", method = RequestMethod.GET)
	   @ResponseBody
	   public MemberVo checkId(String id) {
	      MemberVo vo = memberService.checkId(id);
	      return vo;
	   }

	   // 회원가입시 이메일 체크
	   @RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	   @ResponseBody
	   public MemberVo checkEmail(String email) {
	      MemberVo vo = memberService.checkEmail(email);
	      return vo;
	   }

}
