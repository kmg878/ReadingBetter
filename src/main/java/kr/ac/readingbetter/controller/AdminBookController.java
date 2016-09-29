package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.AdminBookService;
import kr.ac.readingbetter.service.AuthorService;
import kr.ac.readingbetter.service.PublisherService;
import kr.ac.readingbetter.vo.AuthorVo;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.PublisherVo;


@Controller
@RequestMapping("/admin")
public class AdminBookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private AdminBookService adminBookService;

	// 도서 관리
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		List<BookVo> list = bookService.getList();
		model.addAttribute("list", list);
		return "admin/booklist";
	}

	// 책 저장
	@RequestMapping("/bookaddform")
	public String bookaddList(Model model) {

		return "admin/bookaddform";
	}
	
	@RequestMapping("/insertbook")
	public String Insert(@ModelAttribute BookVo vo) {
		bookService.insert(vo);
		return "redirect:/admin/booklist";
	}
	
	@RequestMapping(value = "/checkbook", method = RequestMethod.POST)
	@ResponseBody
	public List<BookVo> checkBook(@RequestParam(value = "title") String title) {
		List<BookVo> bookList = adminBookService.checkBook(title);	
		return bookList;
	}
	
	@RequestMapping(value = "/writercheck", method = RequestMethod.POST)
	@ResponseBody
	public List<AuthorVo> checkwriter(@RequestParam(value = "kwd2") String kwd2,AuthorVo authorvo) {
		
		if (authorvo.getKwd2() == null) {
			authorvo.setKwd2("");
		}

		List<AuthorVo> authorlist = authorService.getList(authorvo);
		return authorlist;
	}
	
	@RequestMapping(value = "/publishercheck", method = RequestMethod.POST)
	@ResponseBody
	public List<PublisherVo> checkpublisher(@RequestParam(value = "kwd1") String kwd1,PublisherVo publishervo) {
		
		if (publishervo.getKwd1() == null) {
			publishervo.setKwd1("");
		}

		List<PublisherVo> publisherlist = publisherService.getList(publishervo);
		
		return publisherlist;
	}
}