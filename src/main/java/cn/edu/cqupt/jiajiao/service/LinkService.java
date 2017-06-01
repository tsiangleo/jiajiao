package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.LinkDao;
import cn.edu.cqupt.jiajiao.domain.Link;

public class LinkService {

	private LinkDao linkdao = new LinkDao();
	
	public int save(Link link) throws SQLException {
		return linkdao.save(link);
	}

	public List<Link> findAll() throws SQLException {
		return linkdao.findAll();
	}

	public int delete(Long linkid) throws SQLException {
		return linkdao.delete(linkid);
	}

	public int update(Link link) throws SQLException {
		return linkdao.update(link);
	}

	public Link findLink(Long linkid) throws SQLException {
		return linkdao.findLink(linkid);
	}

}
