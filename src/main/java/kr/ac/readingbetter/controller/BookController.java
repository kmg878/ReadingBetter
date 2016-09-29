package kr.ac.readingbetter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.AccusationService;
import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.CardService;
import kr.ac.readingbetter.service.CertificationService;
import kr.ac.readingbetter.service.HistoryService;
import kr.ac.readingbetter.service.QuizService;
import kr.ac.readingbetter.service.ReviewService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.vo.AccusationVo;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.CardVo;
import kr.ac.readingbetter.vo.CertificationVo;
import kr.ac.readingbetter.vo.HistoryVo;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.QuizVo;
import kr.ac.readingbetter.vo.ReviewVo;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private AccusationService accusationService;

	@Autowired
	private CardService cardService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ScoresService scoresService;

	@Autowired
	private CertificationService certificationService;

	// 책 리스트
	// 책 리스트 검색, 페이징
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookListPage(BookVo bookvo, Model model) {
		int pageLength = 3;
		int beginPage;

		if (bookvo.getPageNo() == null) {
			bookvo.setPageNo(1);
		}

		if (bookvo.getBkwd() == null) {
			bookvo.setBkwd("");
			List<BookVo> listpage = bookService.getListPage(bookvo);
			model.addAttribute("listpage", listpage);

		}
		String bkwd = bookvo.getBkwd();
		bookvo.setBkwd(bkwd);
		List<BookVo> list = bookService.getListService(bookvo);
		List<BookVo> listkwd = bookService.getListKwd(bookvo);

		model.addAttribute("listpage", listkwd);

		int currentBlock = (int) Math.ceil((double) bookvo.getPageNo() / pageLength);

		int currentPage = bookvo.getPageNo();
		beginPage = (currentBlock - 1) * 3 + 1;

		int total = (int) Math.ceil((double) list.size() / pageLength);
		int endPage = currentBlock * 3;
		if (endPage > total) {
			endPage = total;
		}

		model.addAttribute("bkwd", bkwd);
		model.addAttribute("beginPage", beginPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("total", total);
		return "book/booklist";
	}
	///////////////////////////////////////////////////////////////////////////

	// 퀴즈 내기
	// 퀴즈 내기 화면 열기
	@RequestMapping(value = "/makequizform/{no}", method = RequestMethod.GET)
	public String makeQuizForm(@PathVariable("no") Long no, Model model) {
		BookVo vo = bookService.getByNo(no);
		model.addAttribute("vo", vo);
		return "book/makequizform";
	}

	// 퀴즈 내기
	@RequestMapping(value = "/makequizinsert", method = RequestMethod.POST)
	public String makequizInsert(@ModelAttribute QuizVo vo) {
		quizService.quizAddUser(vo);
		return "redirect:/book/booklist";
	}
	///////////////////////////////////////////////////////////////////////////

	// 퀴즈 풀기
	// 퀴즈 풀기 화면 열기
	@RequestMapping("/solvequizform")
	public String solveQuizForm(Model model, @RequestParam(value = "no", required = false, defaultValue = "") Long no,
			HttpSession session) {
		if (session.getAttribute("complete") != null) {
			session.removeAttribute("complete");
		}

		final Integer COUNT = 0;
		final Integer MAXCOUNT = 4;

		List<QuizVo> list = quizService.selectQuiz(no);
		BookVo vo = bookService.getByNo(no);

		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("count", COUNT);
		model.addAttribute("maxcount", MAXCOUNT);

		return "book/solvequizform";
	}

	// 퀴즈 풀기 결과 보기
	@RequestMapping("/resultquiz")
	public String resultQuiz(QuizVo vo, @RequestParam(value = "no0", required = false, defaultValue = "") Long no1,
			@RequestParam(value = "no1", required = false, defaultValue = "") Long no2,
			@RequestParam(value = "no2", required = false, defaultValue = "") Long no3,
			@RequestParam(value = "no3", required = false, defaultValue = "") Long no4,
			@RequestParam(value = "no4", required = false, defaultValue = "") Long no5,
			@RequestParam(value = "selectedRadio0", required = false, defaultValue = "") String answer1,
			@RequestParam(value = "selectedRadio1", required = false, defaultValue = "") String answer2,
			@RequestParam(value = "selectedRadio2", required = false, defaultValue = "") String answer3,
			@RequestParam(value = "selectedRadio3", required = false, defaultValue = "") String answer4,
			@RequestParam(value = "selectedRadio4", required = false, defaultValue = "") String answer5,
			@RequestParam(value = "no", required = false, defaultValue = "") Long bookNo, Model model,
			HttpSession session) {
		Long no[] = { no1, no2, no3, no4, no5 };
		String answer[] = { answer1, answer2, answer3, answer4, answer5 };
		Integer count = 0;
		Integer len = no.length;

		for (int i = 0; i < len; i++) {
			vo.setNo(no[i]);
			vo.setSelected(answer[i]);

			QuizVo vo2 = quizService.selectResult(vo);
			if (vo2 != null) {
				count++;
			}
		}

		// select card by random
		CardVo cardVo = cardService.selectCardByRandom();

		BookVo bookVo = bookService.getByNo(bookNo);

		// 중복 확인 세션 가져오기
		String completeSession = (String) session.getAttribute("complete");

		model.addAttribute("bookVo", bookVo);
		model.addAttribute("cardVo", cardVo);
		model.addAttribute("count", count);
		model.addAttribute("complete", completeSession);

		return "book/resultquiz";
	}

	// 퀴즈 결과 ajax 동작
	@RequestMapping(value = "/quizResultAction", method = RequestMethod.POST)
	@ResponseBody
	public String[] quizResultAction(HttpSession session, @RequestParam(value = "bookNo") Long bookNo,
			CertificationVo certVo, @RequestParam(value = "count") Integer count,
			@RequestParam(value = "skill") String skill, @RequestParam(value = "bonus") Integer bonus,
			HistoryVo historyVo) {

		MemberVo authUser = (MemberVo) session.getAttribute("authUser");

		String complete = "complete";
		session.setAttribute("complete", complete);

		String completeSession = (String) session.getAttribute("complete");

		String certResult = "인증 실패";
		Integer point = 0;
		Integer score = 0;

		score = count * 20;

		// 인증 성공
		if (count > 3) {
			// 인증 기록 확인
			certVo.setMemberNo(authUser.getNo());
			certVo.setBookNo(bookNo);

			CertificationVo certVo2 = certificationService.selectCertification(certVo);

			if (certVo2 != null) {
				certResult = "이미 인증된 책입니다.";
			} else {
				certificationService.insertCertification(certVo);

				point = 3;
				certResult = "인증 성공";
			}
		}

		// bonus 계산
		if (skill.equals("+")) {
			score = score + bonus;
		} else if (skill.equals("*")) {
			score = score * bonus;
		}

		// history insert
		historyVo.setScore(score);
		historyVo.setPoint(point);
		historyVo.setMemberNo(authUser.getNo());
		historyVo.setIdentity(0);
		historyVo.setKeyNo(bookNo);
		BookVo vo = bookService.getByNo(bookNo);
		historyVo.setTitle(vo.getTitle());

		historyService.insertHistory(historyVo);

		// scores update
		scoresService.updateScores(historyVo);

		completeSession = "true";

		String returnValue[] = { certResult, Integer.toString(point), Integer.toString(score), completeSession };

		return returnValue;
	}
	///////////////////////////////////////////////////////////////////////////

	// 리뷰
	// 리뷰 화면 열기
	@RequestMapping(value = "/review/{no}", method = RequestMethod.GET)
	public String review(@PathVariable("no") Long no, Model model, ReviewVo reviewVo,
			@RequestParam(value = "reviewPage", required = false, defaultValue = "") String reviewPage) {
		// 책 정보 불러오기
		BookVo vo = bookService.getByNo(no);
		model.addAttribute("vo", vo);

		// 책에 따른 리뷰 불러오기, 페이징
		// reviewPage가 null값일때 1로 고정
		if (reviewPage == null || "".equals(reviewPage)) {
			reviewPage = "1";
		}

		// 댓글 전체 갯수
		int count = reviewService.listCount(no);

		// 신고받지 않은 리뷰만 불러옴
		reviewVo.setBookNo(no);
		reviewVo.setReviewPage(reviewPage);
		List<ReviewVo> list = reviewService.getList(reviewVo);

		// 페이징
		int totalPage = 1;
		int currentPage = Integer.parseInt(reviewPage);

		if (count % 5 != 0) {
			totalPage = count / 5 + 1;
		} else {
			totalPage = count / 5;
		}

		int pageGroupNum = 1;
		int pageGroup = 5;
		int beginPage = 1;
		int endPage = 1;

		pageGroupNum = (int) Math.ceil((double) currentPage / pageGroup);

		if (pageGroupNum < 1) {
			pageGroupNum = pageGroupNum + 1;
		}

		beginPage = (pageGroupNum - 1) * pageGroup + 1;
		endPage = pageGroupNum * pageGroup;

		if (totalPage < endPage) {
			endPage = totalPage;
		}

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("beginPage", beginPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "book/review";
	}

	// 리뷰 신고 화면 열기
	@RequestMapping(value = "/accusation/{no}", method = RequestMethod.GET)
	public String accusationform(@PathVariable("no") Long no, Model model) {
		ReviewVo vo = reviewService.getByNo(no);
		model.addAttribute("vo", vo);
		return "book/accusation";
	}

	// 신고 하기
	@RequestMapping(value = "/insertReview", method = RequestMethod.POST)
	public String insertReviewAccusation(@ModelAttribute AccusationVo vo) {
		accusationService.insertReviewAccusation(vo);
		// 신고한 리뷰가 있는 화면으로 간다
		ReviewVo reviewVo = reviewService.getByNo(vo.getKeyNo());
		reviewService.updateState(reviewVo.getNo());
		return "redirect:/book/review/" + reviewVo.getBookNo();
	}

	// 리뷰 삭제
	@RequestMapping(value = "/delete/{no}")
	public String reviewDelete(@PathVariable("no") Long no) {
		// 삭제한 리뷰가 있는 화면으로 간다
		ReviewVo reviewVo = reviewService.getByNo(no);
		Long bookNo = reviewVo.getBookNo();
		reviewService.reviewDelete(no);
		return "redirect:/book/review/" + bookNo;
	}

	// 리뷰 쓰기
	@RequestMapping(value = "/insert/{no}", method = RequestMethod.POST)
	public String insert(@ModelAttribute ReviewVo vo, @PathVariable("no") Long no, HttpSession session) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		Long memberNo = authUser.getNo();
		vo.setMemberNo(memberNo);
		reviewService.insert(vo);
		return "redirect:/book/review/" + no;
	}
}