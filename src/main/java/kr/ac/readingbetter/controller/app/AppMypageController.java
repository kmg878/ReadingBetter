package kr.ac.readingbetter.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.HistoryService;
import kr.ac.readingbetter.vo.HistoryVo;

@Controller
@RequestMapping("/mypageapp")
public class AppMypageController {
	
	@Autowired
	private HistoryService historyService;
	
	@ResponseBody
	@RequestMapping(value = "history", method = RequestMethod.GET)
	public List<HistoryVo> List(HistoryVo historyvo,Long no) {
		historyvo.setMemberNo(no);
		List<HistoryVo> list = historyService.getList(historyvo);
		
		return list;
	}

}
