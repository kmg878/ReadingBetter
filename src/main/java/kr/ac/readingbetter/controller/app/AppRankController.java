package kr.ac.readingbetter.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.ReviewService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.ScoresVo;

@Controller
@RequestMapping("/rankapp")
public class AppRankController {
	
	@Autowired
	private ScoresService scoresService;

	
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<ScoresVo> List(ScoresVo vo) {
		List<ScoresVo> monthlyRank = scoresService.monthlyRank(vo);
		
		return monthlyRank;
	}
	
	@ResponseBody
	@RequestMapping(value = "myrank", method = RequestMethod.GET)
	public ScoresVo historyapp(Long memberNo,ScoresVo vo) {

		vo = scoresService.mymonthlyRank(memberNo);
		
		return vo;
	}

}
