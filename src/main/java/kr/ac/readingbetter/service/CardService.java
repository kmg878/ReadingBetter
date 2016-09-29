package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.CardDao;
import kr.ac.readingbetter.vo.CardVo;

@Service
public class CardService {

	@Autowired
	private CardDao cardDao;

	// 상품 리스트 출력
	public List<CardVo> getList(CardVo vo) {
		return cardDao.getList(vo);
	}

	public void deleteCard(Long no) {
		cardDao.deleteCard(no);
	}

	public void insertCard(CardVo vo) {
		cardDao.insertCard(vo);
	}

	public CardVo getCardByNo(Long no) {
		return cardDao.getCardByNo(no);
	}

	public void updateCard(CardVo vo) {
		cardDao.updateCard(vo);
	}

	// 카드 랜덤으로 가져오기
	public CardVo selectCardByRandom() {
		CardVo vo = cardDao.selectCardByRandom();
		return vo;
	}
}