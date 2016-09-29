package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.ShopDao;
import kr.ac.readingbetter.vo.ShopVo;

@Service
public class ShopService {

	@Autowired
	private ShopDao shopDao;

	// 상품 리스트 출력
	public List<ShopVo> getList(ShopVo vo) {
		return shopDao.getList(vo);
	}

	// 상품 추가
	public void goodsInsert(ShopVo vo) {
		shopDao.goodsInsert(vo);
	}

	// 상품 삭제
	public void goodsDelete(Long no) {
		shopDao.goodsDelete(no);
	}

	public ShopVo getByNo(Long no) {
		ShopVo shop = shopDao.getByNo(no);
		return shop;
	}
}