package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.BookDao;
import kr.ac.readingbetter.vo.BookVo;

@Service
public class AdminBookService {

	@Autowired
	private BookDao bookDao;

	public List<BookVo> checkBook(String title) {
		List<BookVo> bookList = bookDao.findBookReplace(title);
		return bookList;
	}
}