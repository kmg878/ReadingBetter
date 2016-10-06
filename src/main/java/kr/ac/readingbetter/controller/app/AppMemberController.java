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

}
