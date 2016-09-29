package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.QuizDao;
import kr.ac.readingbetter.vo.QuizVo;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizDao;

	public List<QuizVo> getList() {
		List<QuizVo> list = quizDao.getList();
		return list;
	}

	public QuizVo quizView(Long no) {
		QuizVo vo = quizDao.quizView(no);
		return vo;
	}

	public void quizUpdate(QuizVo vo) {
		quizDao.quizUpdate(vo);
	}

	public void quizAddAdmin(QuizVo vo) {
		quizDao.quizAddAdmin(vo);
	}

	public void quizAddUser(QuizVo vo) {
		quizDao.quizAddUser(vo);
	}

	public List<QuizVo> selectQuiz(Long no) {
		List<QuizVo> list = quizDao.selectQuiz(no);
		return list;
	}

	public QuizVo selectResult(QuizVo vo) {
		vo = quizDao.selectResult(vo);
		return vo;
	}
}