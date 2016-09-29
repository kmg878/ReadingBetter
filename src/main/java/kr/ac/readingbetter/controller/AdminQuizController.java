package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.QuizService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.QuizVo;

@Controller
@RequestMapping("/admin")
public class AdminQuizController {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private BookService BookService;
	

	// 퀴즈 관리
	@RequestMapping(value = "/quizlist", method = RequestMethod.GET)
	public String quizList(Model model) {
		List<QuizVo> list = quizService.getList();
		model.addAttribute("list", list);
		return "admin/quizlist";
	}
	
	@RequestMapping(value = "/quizview/{no}", method = RequestMethod.GET)
	public String quizView(@PathVariable("no") Long no, Model model) {
		QuizVo vo = quizService.quizView(no);
		model.addAttribute("vo", vo);
		return "admin/quizview";
	}
	
	@RequestMapping(value = "/quizUpdate", method = RequestMethod.POST)
	public String quizUpdate(@ModelAttribute QuizVo vo) {
		quizService.quizUpdate(vo);
		return "redirect:/admin/quizlist";
	}
	
	@RequestMapping(value = "/quizaddbook", method = RequestMethod.GET)
	public String quizAddBook(Model model) {
		List<BookVo> bookList = BookService.getList();
		model.addAttribute("bookList", bookList);
		return "admin/quizaddbook";
	}

	@RequestMapping(value = "/quizaddform/{no}", method = RequestMethod.GET)
	public String quizAddForm(@PathVariable("no") Long no, Model model) {
		BookVo bookVo = BookService.getByNo(no);
		model.addAttribute("bookVo", bookVo);
		return "admin/quizaddform";
	}
	
	@RequestMapping(value = "/quizadd", method = RequestMethod.POST)
	public String quizAddAdmin(@ModelAttribute QuizVo vo) {
		quizService.quizAddAdmin(vo);
		return "redirect:/admin/quizlist";
	}
}