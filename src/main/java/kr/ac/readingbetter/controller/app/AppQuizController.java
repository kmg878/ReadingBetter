package kr.ac.readingbetter.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.BookService;
import kr.ac.readingbetter.service.CardService;
import kr.ac.readingbetter.service.CertificationService;
import kr.ac.readingbetter.service.HistoryService;
import kr.ac.readingbetter.service.QuizService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.CardVo;
import kr.ac.readingbetter.vo.CertificationVo;
import kr.ac.readingbetter.vo.HistoryVo;
import kr.ac.readingbetter.vo.QuizVo;


@Controller
@RequestMapping("/quizapp")
public class AppQuizController {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ScoresService scoresService;
	
	@Autowired
	private CertificationService certificationService;
	
	@Autowired
	private CardService cardService;
	
	@ResponseBody
	@RequestMapping(value = "insertquiz", method = RequestMethod.GET)
	public String InsertQuiz(@ModelAttribute QuizVo vo,
			Long bookNo,String quiz,String ex1,String ex2,String ex3,String ex4,String answer ) {
		
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
	@ResponseBody
	@RequestMapping(value = "solvequiz", method = RequestMethod.GET)
	public List<QuizVo> solveQuizForm(Long no) {
		List<QuizVo> list = quizService.selectQuiz(no);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "historyScores", method = RequestMethod.GET)
	public String InsertHistory(HistoryVo historyVo,Long memberNo,Long bookNo,
			Integer score,Integer point) {
	System.out.println(memberNo+","+bookNo+","+score+","+point);
		// history insert
		historyVo.setScore(score);
		historyVo.setPoint(point);
		historyVo.setMemberNo(memberNo);
		historyVo.setIdentity(0);
		historyVo.setKeyNo(bookNo);
		BookVo vo = bookService.getByNo(bookNo);
		historyVo.setTitle(vo.getTitle());
		historyService.insertHistory(historyVo);
		// scores update
		scoresService.updateScores(historyVo);
		
				
		return "";
	}
	@ResponseBody
	@RequestMapping(value = "cert", method = RequestMethod.GET)
	public String InsertCert(CertificationVo certVo,Long memberNo,Long bookNo) {
		System.out.println(memberNo+","+bookNo);
		//certification insert
		certVo.setBookNo(bookNo);
		certVo.setMemberNo(memberNo);
		certificationService.insertCertification(certVo);
				
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value = "certification", method = RequestMethod.GET)
	public CertificationVo certification(CertificationVo certVo,Long memberNo,Long bookNo) {
		System.out.println("1");
		certVo.setMemberNo(memberNo);
		certVo.setBookNo(bookNo);

		CertificationVo certVo2 = certificationService.selectCertification(certVo);
		
		return certVo2;
	}
	
	@ResponseBody
	@RequestMapping(value = "card", method = RequestMethod.GET)
	public CardVo Card() {
		System.out.println("1");
		// select card by random
		CardVo cardVo = cardService.selectCardByRandom();
		
		return cardVo;
	}
	
	
	
	
	
	
	
	
	
	
	

}
