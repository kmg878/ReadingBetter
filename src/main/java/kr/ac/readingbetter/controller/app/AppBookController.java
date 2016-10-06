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
import kr.ac.readingbetter.service.ReviewService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.QuizVo;
import kr.ac.readingbetter.vo.ReviewVo;


@Controller
@RequestMapping("/bookapp")
public class AppBookController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@Autowired
	private ReviewService reviewService;
	
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<BookVo> List(BookVo bookvo) {
		List<BookVo> list = bookService.getList();
		
		return list;
	}

	
	@ResponseBody
	@RequestMapping(value = "review", method = RequestMethod.GET)
	public List<ReviewVo> Review(Long bookNo,ReviewVo reviewVo) {
		reviewVo.setBookNo(bookNo);
		List<ReviewVo> list = reviewService.getListApp(reviewVo);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "insertreview", method = RequestMethod.GET)
	public String InsertReview(Long bookNo,String review,Long memberNo,@ModelAttribute ReviewVo vo) {
		System.out.println(bookNo+","+review+","+memberNo);
		vo.setBookNo(bookNo);
		vo.setReview(review);
		vo.setMemberNo(memberNo);
		reviewService.insert(vo);
		
		return "";
	}
	
	
	

}
