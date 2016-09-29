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
import kr.ac.readingbetter.service.CommentsService;
import kr.ac.readingbetter.service.NoticeService;
import kr.ac.readingbetter.service.WishbookService;
import kr.ac.readingbetter.vo.AccusationVo;
import kr.ac.readingbetter.vo.CommentsVo;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.NoticeVo;
import kr.ac.readingbetter.vo.WishbookVo;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private CommentsService commentsService;

	@Autowired
	private AccusationService accusationService;
	
	@Autowired
	private WishbookService wishbookService;

	// 공지
	// 공지 리스트 띄우기
	@RequestMapping(value = "/noticelist", method = RequestMethod.GET)
	public String noticeList(Model model, NoticeVo vo,
			@RequestParam(value = "noticePage", required = false, defaultValue = "") String noticePage) {
		// noticePage가 null값일때 1로 고정
		if (noticePage == null || "".equals(noticePage)) {
			noticePage = "1";
		}

		// 공지 전체 개수
		int count = noticeService.listCount();

		// 공지 추가하기
		vo.setNoticePage(noticePage);
		List<NoticeVo> list = noticeService.listPage(vo);

		// 페이징
		int totalPage = 1;
		int currentPage = Integer.parseInt(noticePage);

		if (count % 5 != 0) {
			totalPage = count / 10 + 1;
		} else {
			totalPage = count / 10;
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
		return "service/noticelist";
	}

	// 공지 상세 보기
	@RequestMapping(value = "/noticeview/{no}", method = RequestMethod.GET)
	public String noticeView(@PathVariable("no") Long no, Model model, CommentsVo commentsVo,
			@RequestParam(value = "commentsPage", required = false, defaultValue = "") String commentsPage) {
		// 공지 상세 불러오기
		noticeService.viewCount(no);
		NoticeVo vo = noticeService.noticeView(no);
		model.addAttribute("vo", vo);

		// 공지에 따른 댓글 불러오기, 페이징
		// commentsPage가 null값일때 1로 고정
		if (commentsPage == null || "".equals(commentsPage)) {
			commentsPage = "1";
		}

		// 댓글 전체 갯수
		int count = commentsService.listCount(no);

		// 신고받지 않은 리스트만 불러옴
		commentsVo.setNoticeNo(no);
		commentsVo.setCommentsPage(commentsPage);
		List<CommentsVo> list = commentsService.getList(commentsVo);

		// 페이징
		int totalPage = 1;
		int currentPage = Integer.parseInt(commentsPage);

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
		return "service/noticeview";
	}

	// 댓글 쓰기
	@RequestMapping(value = "/commentswrite", method = RequestMethod.POST)
	public String commentsWrite(@ModelAttribute CommentsVo vo) {
		commentsService.commentsWrite(vo);
		return "redirect:/service/noticeview/" + vo.getNoticeNo();
	}

	// 댓글 신고 화면 열기
	@RequestMapping(value = "/commentsAccusation/{no}", method = RequestMethod.GET)
	public String commentsAccusation(@PathVariable("no") Long no, Model model) {
		CommentsVo vo = commentsService.commentsAccusation(no);
		model.addAttribute("vo", vo);
		return "service/accusation";
	}

	// 댓글 신고
	@RequestMapping(value = "/insertComments", method = RequestMethod.POST)
	public String insertComments(@ModelAttribute AccusationVo vo) {
		accusationService.insertComments(vo);
		// 신고한 댓글이 있는 공지 상세 화면으로 간다
		CommentsVo commentsVo = commentsService.commentsAccusation(vo.getKeyNo());
		commentsService.updateState(commentsVo.getNo());
		return "redirect:/service/noticeview/" + commentsVo.getNoticeNo();
	}

	// 댓글 삭제
	@RequestMapping(value = "/deleteComments/{no}", method = RequestMethod.GET)
	public String deleteComments(@PathVariable("no") Long no) {
		// 삭제한 댓글이 있는 공지 상세 화면으로 간다
		CommentsVo commentsVo = commentsService.commentsAccusation(no);
		Long noticeNo = commentsVo.getNoticeNo();
		// 공지 번호를 저장후 해당 정보를 삭제한다
		commentsService.deleteComments(no);
		return "redirect:/service/noticeview/" + noticeNo;
	}
	///////////////////////////////////////////////////////////////////////////
	
	// 문의
	// 문의 리스트
	@RequestMapping("/questionlist")
	public String questionList() {
		return "service/questionlist";
	}

	// 문의 상세 보기
	@RequestMapping("/questionview")
	public String questionView() {
		return "service/questionview";
	}
	
	// 문의 쓰기
	@RequestMapping("/questionwrite")
	public String questionWrite() {
		return "service/questionwrite";
	}
	///////////////////////////////////////////////////////////////////////////

	// 희망도서
	// 희망도서 리스트
	@RequestMapping("/wishbooklist")
	public String wishBookList(Model model) {
		List<WishbookVo> list = wishbookService.getList();
		model.addAttribute("list", list);
		return "service/wishbooklist";
	}
	
	// 희망도서 쓰기 화면 열기
	@RequestMapping("/wishbookwriteform")
	public String wishBookWriteForm() {
		return "service/wishbookwrite";
	}

	// 희망도서 상세 보기
	@RequestMapping("/wishbookview")
	public String wishBookView(@RequestParam(value = "no") Long no, WishbookVo vo, Model model) {
		vo = wishbookService.getView(vo);
		model.addAttribute("vo", vo);
		return "service/wishbookview";
	}

	// 희망도서 쓰기
	@RequestMapping(value = "/wishbookwrite", method = RequestMethod.POST)
	public String wishBookWrite(WishbookVo vo, HttpSession session) {
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		vo.setMemberNo(authUser.getNo());
		wishbookService.insertWishbook(vo);
		return "redirect:/service/wishbooklist";
	}

	// 희망도서 추천수
	@RequestMapping(value = "/wishbookrecommend")
	@ResponseBody
	public void wishBookRecommend(@RequestParam(value = "no") Long no) {
		wishbookService.updateRecommend(no);
	}
}