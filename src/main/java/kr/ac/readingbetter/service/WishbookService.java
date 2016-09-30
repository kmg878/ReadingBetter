package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.WishbookDao;
import kr.ac.readingbetter.vo.WishbookVo;

@Service
public class WishbookService {

	@Autowired
	private WishbookDao wishbookDao;

	public List<WishbookVo> getList() {
		List<WishbookVo> list = wishbookDao.getList();
		return list;
	}

	public WishbookVo getView(WishbookVo vo) {
		vo = wishbookDao.getView(vo);
		return vo;
	}

	public void insertPublisher(WishbookVo vo) {
		wishbookDao.insertPublisher(vo);
	}

	public void insertBook(WishbookVo vo) {
		wishbookDao.insertBook(vo);
	}

	public void updateAcceptToOne(WishbookVo vo) {
		wishbookDao.updateAcceptToOne(vo);
	}

	public void updateAcceptToTwo(WishbookVo vo) {
		wishbookDao.updateAcceptToTwo(vo);
	}

	public void insertWishbook(WishbookVo vo) {
		wishbookDao.insertWishbook(vo);
	}

	public void updateRecommend(Long no) {
		wishbookDao.updateRecommend(no);
	}
	
	public List<WishbookVo> listkwd(WishbookVo vo){
		 List<WishbookVo> list= wishbookDao.getListKwd(vo);
		 return list;
	}
	public List<WishbookVo> listPage(WishbookVo vo){
		 List<WishbookVo> list= wishbookDao.getListPage(vo);
		 return list;
	}
	public List<WishbookVo> listKwdPage(WishbookVo vo){
		 List<WishbookVo> list= wishbookDao.getListKwdPage(vo);
		 return list;
	}
}