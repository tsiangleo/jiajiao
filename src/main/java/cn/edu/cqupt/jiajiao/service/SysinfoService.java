package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;

import cn.edu.cqupt.jiajiao.dao.SysinfoDao;
import cn.edu.cqupt.jiajiao.domain.Sysinfo;

public class SysinfoService {

	private SysinfoDao sysinfodao = new SysinfoDao();
	public int update(Sysinfo sysinfo) throws SQLException {
		return sysinfodao.update(sysinfo);
	}
	public Sysinfo findAll() throws SQLException {
		return sysinfodao.findAll();
	}
	public int updateContactus(String contactus) throws SQLException {
		String sql = "UPDATE t_sysinfo SET contactus='"+contactus+"'";
		return sysinfodao.updateBySQL(sql);
	}
	
	public int updateAboutus(String aboutus) throws SQLException {
		String sql = "UPDATE t_sysinfo SET aboutus='"+aboutus+"'";
		return sysinfodao.updateBySQL(sql);
	}
	

}
