package kr.ac.readingbetter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.HistoryService;
import kr.ac.readingbetter.service.MemberService;
import kr.ac.readingbetter.service.MypageService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.vo.CertificationVo;
import kr.ac.readingbetter.vo.HistoryVo;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.ScoresVo;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private ScoresService scoresService;

	@Autowired
	private MypageService mypageService;

	@Autowired
	private HistoryService historyService;

	// 내 정보
	// 회원 정보 화면 열기
	@RequestMapping("/info")
	public String Info(HttpSession session, Model model) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		MemberVo memberVo = mypageService.selectMyinfo(authUser.getNo());
		ScoresVo scoresVo = scoresService.selectScores(authUser.getNo());
		model.addAttribute("memberVo", memberVo);
		model.addAttribute("scoresVo", scoresVo);
		return "mypage/info";
	}

	// 회원 정보 수정 화면 열기
	@RequestMapping("/modifyform")
	public String ModifyForm(HttpSession session, Model model) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		MemberVo vo = mypageService.selectMyinfo(authUser.getNo());
		model.addAttribute("vo", vo);
		return "mypage/modifyform";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(MemberVo vo, HttpSession session) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		vo.setMemberNo(authUser.getNo());
		mypageService.updateMember(vo);
		return "redirect:/mypage/info";
	}

	@RequestMapping("/findform")
	public String FindForm() {
		return "mypage/findform";
	}

	////////////////////////////////////////////////////////////////////////////

	// 내 활동
	// 히스토리 화면 열기
	@RequestMapping("/history")
	public String History(HttpSession session, Model model, HistoryVo historyvo, CertificationVo certificationvo) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");

		MemberVo memberVo = memberService.selectMyinfo(authUser.getNo());
		ScoresVo scoresVo = scoresService.selectScores(authUser.getNo());

		model.addAttribute("memberVo", memberVo);
		model.addAttribute("scoresVo", scoresVo);

		historyvo.setMemberNo(authUser.getNo());
		List<HistoryVo> list = historyService.getList(historyvo);
		model.addAttribute("historylist", list);

		return "mypage/history";
	}
}