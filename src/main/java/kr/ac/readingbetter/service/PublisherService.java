package kr.ac.readingbetter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.PublisherDao;
import kr.ac.readingbetter.vo.PublisherVo;
import kr.ac.readingbetter.vo.WishbookVo;

@Service
public class PublisherService {

	@Autowired
	private PublisherDao publisherDao;

	public List<PublisherVo> getList(PublisherVo vo) {
		List<PublisherVo> list = publisherDao.getList(vo);
		return list;
	}

	public void insert(PublisherVo vo) {
		publisherDao.insert(vo);
	}
	
	public List<PublisherVo> selectPublisher(WishbookVo vo){
		List<PublisherVo> list = publisherDao.selectPublisher(vo);
		return list;
	}
}