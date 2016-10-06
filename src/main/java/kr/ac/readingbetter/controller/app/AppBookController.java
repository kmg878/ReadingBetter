package kr.ac.readingbetter.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.QuizService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.QuizVo;


@Controller
@RequestMapping("/bookapp")
public class AppBookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private QuizService quizService;
	
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<BookVo> List(BookVo bookvo) {
		List<BookVo> list = bookService.getList();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "insertquiz", method = RequestMethod.GET)
	public String InsertQuiz(@ModelAttribute QuizVo vo,
			Long bookNo,String quiz,String ex1,String ex2,String ex3,String ex4,String answer ) {
		System.out.println(bookNo+","+quiz+","+ex1+","+ex2+","+ex3+","+ex4+","+answer);
		vo.setBookNo(bookNo);
		vo.setQuiz(quiz);
		vo.setEx1(ex1);
		vo.setEx2(ex2);
		vo.setEx3(ex3);
		vo.setEx4(ex4);
		vo.setAnswer(answer);
		quizService.quizAddUser(vo);
		
		return "";
	}
	
	

}
