package kr.ac.readingbetter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.readingbetter.service.HistoryService;
import kr.ac.readingbetter.service.ScoresService;
import kr.ac.readingbetter.service.ShopService;
import kr.ac.readingbetter.vo.HistoryVo;
import kr.ac.readingbetter.vo.MemberVo;
import kr.ac.readingbetter.vo.ScoresVo;
import kr.ac.readingbetter.vo.ShopVo;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private ScoresService scoresService;

	@Autowired
	private HistoryService historyService;

	// 상점 화면 열기
	@RequestMapping("/shop")
	public String goodsList(HttpSession session,Model model, ShopVo vo) {
		if (vo.getTitle() == null) { // 검색할 상품명이 없으면 빈 문자열로 교체
			vo.setTitle("");
		}
		List<ShopVo> getGoodsList = shopService.getList(vo);
		
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		ScoresVo scoresVo = scoresService.selectScores(authUser.getNo());
		
		model.addAttribute("scoresVo",scoresVo);
		model.addAttribute("getGoodsList", getGoodsList);
		return "shop/shop";
	}

	// 구입 확인 모달
	@ResponseBody
	@RequestMapping(value = "readAjax", method = RequestMethod.POST)
	public ShopVo readBoardAjax(Long no) {
		ShopVo shopvo = shopService.getByNo(no);
		return shopvo;
	}

	// 구입 차감 모달
	@ResponseBody
	@RequestMapping(value = "/shop/buy", method = RequestMethod.POST)
	public ScoresVo shopbuy(HttpSession session, HistoryVo historyVo, 
			@RequestParam(value = "price") int price, 
			@RequestParam(value = "no") Long no,
			@RequestParam(value = "title") String title) {

		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		ScoresVo scoresVo = scoresService.selectScores(authUser.getNo());
		int point = scoresVo.getPoint();
		point = point - price;
		scoresVo.setPoint(point);
		scoresVo.setMemberNo(authUser.getNo());
		scoresService.scoreUpdate(scoresVo);

		// history insert
		historyVo.setTitle(title);
		historyVo.setScore(0);
		historyVo.setPoint(price);
		historyVo.setMemberNo(authUser.getNo());
		historyVo.setIdentity(1);
		historyVo.setKeyNo(no);

		historyService.insertHistory(historyVo);
		return scoresVo;
	}
}