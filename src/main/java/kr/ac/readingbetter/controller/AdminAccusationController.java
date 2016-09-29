package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.AccusationService;
import kr.ac.readingbetter.service.CommentsService;
import kr.ac.readingbetter.service.ReviewService;
import kr.ac.readingbetter.vo.AccusationVo;
import kr.ac.readingbetter.vo.CommentsVo;
import kr.ac.readingbetter.vo.ReviewVo;

@Controller
@RequestMapping("/admin")
public class AdminAccusationController {

	@Autowired
	private AccusationService accusationService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CommentsService commentsService;

	// 신고 관리
	@RequestMapping("/accusationlist")
	public String accusationList(Model model) {
		List<AccusationVo> list = accusationService.getList();
		model.addAttribute("accusationlist", list);
		return "admin/accusationlist";
	}

	@RequestMapping(value = "/accusationview/{no}", method = RequestMethod.GET)
	public String accusationView(@PathVariable("no") Long no, Model model) {
		AccusationVo vo = accusationService.getByNo(no);
		CommentsVo commentsvo;
		ReviewVo reviewvo;
		Long identity = vo.getIdentity();
		Long keyNo = vo.getKeyNo();

		if (identity == 1) {
			reviewvo = reviewService.getByNo(keyNo);
			model.addAttribute("reviewvo", reviewvo);
		} else {
			commentsvo = commentsService.getCommentsList(keyNo);
			model.addAttribute("commentsvo", commentsvo);
		}

		model.addAttribute("vo", vo);
		return "admin/accusationview";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String modify(@ModelAttribute AccusationVo vo) {
		accusationService.update(vo);
		return "redirect:/admin/accusationlist";
	}
}