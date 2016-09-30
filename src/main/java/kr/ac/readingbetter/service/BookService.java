package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.BookDao;
import kr.ac.readingbetter.vo.BookVo;
import kr.ac.readingbetter.vo.PublisherVo;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public List<BookVo> getList() {
		List<BookVo> list = bookDao.getList();
		return list;
	}
	// 사용자 페이징 리스트
		public List<BookVo> getAdminListPage(BookVo vo) {
			List<BookVo> list = bookDao.getAdminListPage(vo);
			return list;
		}


	// 페이징 리스트
	public List<BookVo> getListPage(BookVo vo) {
		List<BookVo> list = bookDao.getListPage(vo);
		return list;
	}

	public List<BookVo> getListKwd(BookVo vo) {
		List<BookVo> list = bookDao.getListKwd(vo);
		return list;
	}

	public BookVo getByNo(Long no) {
		BookVo vo = bookDao.getByNo(no);
		return vo;
	}

	public List<BookVo> findBook(BookVo vo) {
		List<BookVo> list = bookDao.findBook(vo);
		return list;
	}

	public List<BookVo> getListService(BookVo vo) {
		List<BookVo> list = bookDao.getListService(vo);
		return list;
	}
	
	public void insert(BookVo vo) {
		bookDao.insert(vo);
	}
}