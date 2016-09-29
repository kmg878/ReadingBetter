package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.CommentsDao;
import kr.ac.readingbetter.vo.CommentsVo;

@Service
public class CommentsService {
	
	@Autowired
	private CommentsDao commentsDao;
	
	public List<CommentsVo> getList(CommentsVo vo) {
		List<CommentsVo> list = commentsDao.getList(vo);
		return list;
	}
	
	public void commentsWrite(CommentsVo vo) {
		commentsDao.commentsWrite(vo);
	}
	
	public CommentsVo commentsAccusation(Long no) {
		CommentsVo vo = commentsDao.commentsAccusation(no);
		return vo;
	}
	
	public void deleteComments(Long no) {
		commentsDao.deleteComments(no);
	}
	
	public CommentsVo getCommentsList(Long no) {
		CommentsVo adminComments = commentsDao.getCommentsList(no);
		return adminComments;
	}
	
	public Integer listCount(Long no) {
		int count = commentsDao.listCount(no);
		return count;
	}
	
	public void updateState(Long no) {
		commentsDao.updateState(no);
	}
}