package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.NoticeService;
import kr.ac.readingbetter.vo.NoticeVo;

@Controller
@RequestMapping("/admin")
public class AdminNoticeController {
	
	@Autowired
	private NoticeService noticeService;

	// 공지 관리
	@RequestMapping(value = "/noticelist", method = RequestMethod.GET)
	public String noticeList(Model model, NoticeVo vo) {
		List<NoticeVo> list = noticeService.getList(vo);
		model.addAttribute("list", list);
		return "admin/noticelist";
	}
	
	@RequestMapping(value = "/noticewriteform", method = RequestMethod.GET)
	public String noticeWriteForm() {
		return "admin/noticewriteform";
	}
	
	@RequestMapping(value = "/noticewrite", method = RequestMethod.POST)
	public String noticeWrite(@ModelAttribute NoticeVo vo) {
		noticeService.noticeWrite(vo);
		return "redirect:/admin/noticelist";
	}

	@RequestMapping(value = "/noticeview/{no}", method = RequestMethod.GET)
	public String noticeView(@PathVariable("no") Long no, Model model) {
		NoticeVo vo = noticeService.noticeView(no);
		model.addAttribute("vo", vo);
		return "admin/noticeview";
	}

	@RequestMapping(value = "/noticemodifyform/{no}", method = RequestMethod.GET)
	public String noticeModifyForm(@PathVariable("no") Long no, Model model) {
		NoticeVo vo = noticeService.noticeView(no);
		model.addAttribute("vo", vo);
		return "admin/noticemodifyform";
	}
	
	@RequestMapping(value = "/noticemodify", method = RequestMethod.POST)
	public String noticeModify(@ModelAttribute NoticeVo vo) {
		noticeService.noticeModify(vo);
		return "redirect:/admin/noticelist";
	}
}