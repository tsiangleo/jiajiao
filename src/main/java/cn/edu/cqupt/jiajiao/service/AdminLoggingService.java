package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;

import cn.edu.cqupt.jiajiao.dao.AdminLoggingDao;
import cn.edu.cqupt.jiajiao.domain.AdminLogging;
import cn.edu.cqupt.jiajiao.domain.Administrator;

public class AdminLoggingService {
	private AdminLoggingDao adminLoggingDao = new AdminLoggingDao();

	/**
	 * 保存日志
	 * @param adminLogging
	 * @return
	 * @throws SQLException
	 */
	public int save(AdminLogging adminLogging) throws SQLException
	{
		return adminLoggingDao.save(adminLogging);
	}
	
	/**
	 * 查询所有日志
	 * @return
	 */
	public List<AdminLogging> findAll()
	{
		try {
			return adminLoggingDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 查询用户名为username的所有日志
	 * @return
	 */
	public List<AdminLogging> findAll(String username)
	{
		String sql = "SELECT * FROM t_adminlogging WHERE username='"+username+"'ORDER BY id DESC";
		try {
			return adminLoggingDao.findAdminLoggingBySQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	/**
	     删除制定Id的日志
	 * @param id
	 * @return
	 */
	public int delete(Long id) {
		try {
			return adminLoggingDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
