package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;

import cn.edu.cqupt.jiajiao.dao.CertificateDao;
import cn.edu.cqupt.jiajiao.domain.Certificate;

public class CertificateService {

	private CertificateDao certificatedao = new CertificateDao();

	public int sava(Certificate certificate) throws SQLException {
		return certificatedao.save(certificate);
	}

	public Certificate findCertificateByTeacherId(Long memeberid) throws SQLException {
		return certificatedao.findCertificateByTeacherId(memeberid);
	}

	public int deleteCertificate(Long id) throws SQLException {
		return certificatedao.deleteCertificate(id);
		
	}

}
