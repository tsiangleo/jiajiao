package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.NoticeDao;
import cn.edu.cqupt.jiajiao.domain.Notice;

public class NoticeService {
	private NoticeDao noticedao = new NoticeDao();
	
	public int save(Notice notice) throws SQLException {
		return noticedao.save(notice);
	}

	public List<Notice> findAll() throws SQLException {
		return noticedao.findAll();
	}

	public int delete(Long newsid) throws SQLException {
		return noticedao.delete(newsid);
	}

	public Notice findNotice(Long noticeid) throws SQLException {
		return noticedao.findNotice(noticeid);
	}

	

}
