package kr.ac.readingbetter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.readingbetter.service.CardService;
import kr.ac.readingbetter.vo.CardVo;

@Controller
@RequestMapping("/admin")
public class AdminCardController {
	
	@Autowired
	private CardService cardService;

	// 카드 리스트 및 폼 출력
	@RequestMapping("/cardlist")
	public String cardList(Model model, CardVo vo) {
		if (vo.getTitle() == null) {
			vo.setTitle("");
		}
		List<CardVo> getCardList = cardService.getList(vo);
		model.addAttribute("getCardList", getCardList);
		return "admin/cardlist";
	}

	// 카드 등록 폼
	@RequestMapping("/cardaddform")
	public String cardAddForm() {
		return "admin/cardaddform";
	}

	// 카드 등록
	@RequestMapping("/cardaddform/cardadd")
	public String insertCard(CardVo vo) {
		cardService.insertCard(vo);
		return "redirect:/admin/cardlist";
	}

	// 카드 수정 폼
	@RequestMapping(value = "/cardmodifyform")
	public String cardModifyForm(Long no, Model model) {
		CardVo vo = cardService.getCardByNo(no);
		model.addAttribute("cardVo", vo);
		return "admin/cardmodifyform";
	}

	// 카드 수정
	@RequestMapping("/cardmodifyform/modify")
	public String updateCard(CardVo vo){
		cardService.updateCard(vo);
		return "redirect:/admin/cardlist";
	}
	
	// 카드 삭제
	@RequestMapping("/cardlist/delete")
	public String deleteCard(Long no) {
		cardService.deleteCard(no);
		return "redirect:/admin/cardlist";
	}
}