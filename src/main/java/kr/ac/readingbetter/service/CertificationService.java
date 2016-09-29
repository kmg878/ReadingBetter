package kr.ac.readingbetter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.readingbetter.dao.CertificationDao;
import kr.ac.readingbetter.vo.CertificationVo;

@Service
public class CertificationService {

	@Autowired
	private CertificationDao certificationDao;

	public CertificationVo selectCertification(CertificationVo vo) {
		vo = certificationDao.selectCertification(vo);
		return vo;
	}

	public void insertCertification(CertificationVo vo) {
		certificationDao.insertCertification(vo);
	}
}