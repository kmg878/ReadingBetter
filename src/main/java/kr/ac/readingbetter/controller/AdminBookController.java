package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String bookList(BookVo bookvo,Model model) {
		int pageLength = 5;
		int beginPage;
		if (bookvo.getPageNo() == null) {
			bookvo.setPageNo(1);
		}
		List<BookVo> list = bookService.getList();
		List<BookVo> listpage=bookService.getAdminListPage(bookvo);
		model.addAttribute("list", listpage);
		
		int currentBlock = (int) Math.ceil((double) bookvo.getPageNo() / pageLength);

		int currentPage = bookvo.getPageNo();
		beginPage = (currentBlock - 1) * 5 + 1;

		int total = (int) Math.ceil((double) list.size() / pageLength);
		int endPage = currentBlock * 5;
		if (endPage > total) {
			endPage = total;
		}

		model.addAttribute("beginPage", beginPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("total", total);
		
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
	
	// 책 수정
		@RequestMapping(value = "/bookmodifyform/{no}", method = RequestMethod.GET)
		public String bookmodifyform(@PathVariable("no") Long no,Model model) {
			BookVo vo = bookService.getByNo(no);
			model.addAttribute("vo", vo);
			return "admin/bookmodifyform";
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