package kr.ac.readingbetter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.MemberService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.ScoresVo;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ScoresService scoresService;

	// 메인
	// 메인 화면 열기
	@RequestMapping("")
	public String Main(ScoresVo vo, Model model) {
		// 메인에 한 달 랭킹 상위 5명 출력
		List<ScoresVo> monthlyMainRank = scoresService.monthlyMainRank(vo);
		model.addAttribute("monthlyMainRank", monthlyMainRank);

		// 메인에 명예의 전당 랭킹 상위 5명 출력
		List<ScoresVo> mainHonor = scoresService.mainHonor(vo);
		model.addAttribute("mainHonor", mainHonor);
		return "main/main";
	}
	////////////////////////////////////////////////////////////////////////////
	
	// 네비
	// 네비의 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session) {

		// login
		MemberVo authUser = memberService.selectAuthUser(vo);

		if (authUser == null) {
			return "redirect:/member/loginform?error=true";
		}

		// 인증 성공
		session.setAttribute("authUser", authUser);

		// scores insert
		ScoresVo scoresVo = scoresService.selectScores(authUser.getNo());

		if (scoresVo == null) {
			scoresService.insertScores(authUser.getNo());
		}

		return "redirect:/main";
	}
	////////////////////////////////////////////////////////////////////////////
	
	// 헤더
	// 헤더에 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();

		return "redirect:/main";
	}
	////////////////////////////////////////////////////////////////////////////
	
	// 푸터
	// 푸터의 이용법
	@RequestMapping("/manual")
	public String Manual() {
		return "main/manual";
	}

	// 푸터의 소개
	@RequestMapping("/siteinfo")
	public String SiteInfo() {
		return "main/siteinfo";
	}

	// 푸터의 사이트맵
	@RequestMapping("/sitemap")
	public String SiteMap() {
		return "main/sitemap";
	}
}