package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.HistoryDao;
import kr.ac.readingbetter.vo.HistoryVo;

@Service
public class HistoryService {
	@Autowired
	private HistoryDao historyDao;

	public void insertHistory(HistoryVo vo) {
		historyDao.insertHistory(vo);
	}

	public List<HistoryVo> getList(HistoryVo vo) {
		List<HistoryVo> list = historyDao.getList(vo);
		return list;
	}
}