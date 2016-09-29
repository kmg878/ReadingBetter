package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.PublisherService;
import kr.ac.readingbetter.service.WishbookService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.PublisherVo;
import kr.ac.readingbetter.vo.WishbookVo;

@Controller
@RequestMapping("/admin/wishbooklist")
public class AdminWishbookController {

	@Autowired
	private WishbookService wishBookService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private BookService bookService;

	// 희망도서 관리
	@RequestMapping("")
	public String wishBookList(Model model) {
		List<WishbookVo> list = wishBookService.getList();
		model.addAttribute("list", list);

		return "admin/wishbooklist";
	}

	@RequestMapping("/wishbookview")
	public String wishBookView(Model model, WishbookVo vo, PublisherVo pVo, BookVo bVo) {
		vo = wishBookService.getView(vo);

		if (pVo.getKwd1() == null || pVo.getKwd1().equals("")) {
			pVo.setKwd1("@@@@@@@@@@@@@@@@");
		}

		if (bVo.getBkwd() == null || bVo.getBkwd().equals("")) {
			bVo.setBkwd("@@@@@@@@@@@@@@@@@@@@");
		}

		List<PublisherVo> pList = publisherService.getList(pVo);
		List<BookVo> bList = bookService.findBook(bVo);

		model.addAttribute("vo", vo);
		model.addAttribute("plist", pList);
		model.addAttribute("blist", bList);

		return "admin/wishbookview";
	}

	@RequestMapping(value = "/wishbookview/accept", method = RequestMethod.POST)
	public String wishBookAccept(@ModelAttribute WishbookVo vo) {
		List<PublisherVo> pList = publisherService.selectPublisher(vo);
		Integer pListLength = pList.size();

		if (pListLength == 0) {
			wishBookService.insertPublisher(vo);
		}

		wishBookService.insertBook(vo);
		wishBookService.updateAcceptToOne(vo);

		return "redirect:/admin/wishbooklist";
	}

	@RequestMapping("/wishbookview/refuse")
	public String wishBookRefuse(WishbookVo vo) {
		wishBookService.updateAcceptToTwo(vo);

		return "redirect:/admin/wishbooklist";
	}
}
