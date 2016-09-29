package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.NoticeDao;
import kr.ac.readingbetter.vo.NoticeVo;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	public List<NoticeVo> getList(NoticeVo vo) {
		List<NoticeVo> list = noticeDao.getList(vo);
		return list;
	}
	
	public List<NoticeVo> listPage(NoticeVo vo) {
		List<NoticeVo> list = noticeDao.listPage(vo);
		return list;
	}
	
	public void noticeWrite(NoticeVo vo){
		noticeDao.noticeWrite(vo);
	}
	
	public NoticeVo noticeView(Long no) {
		NoticeVo vo = noticeDao.noticeView(no);
		return vo;
	}
	
	public void noticeModify(NoticeVo vo){
		noticeDao.noticeModify(vo);
	}
	
	public void viewCount(Long no){
		noticeDao.viewCount(no);
	}
	
	public Integer listCount() {
		int count = noticeDao.listCount();
		return count;
	}
}