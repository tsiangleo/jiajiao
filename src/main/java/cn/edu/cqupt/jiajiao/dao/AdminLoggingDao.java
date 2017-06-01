package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.AdminLogging;
import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class AdminLoggingDao {

	public int save(AdminLogging adminLogging) throws SQLException {
		String sql = "INSERT INTO t_adminlogging(username,logintime,loginip,result) values(?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setString(1,adminLogging.getUsername());
		prestmt.setString(2,adminLogging.getLogintime());
		prestmt.setString(3,adminLogging.getLoginip());
		prestmt.setString(4,adminLogging.getResult());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}
	
	public List<AdminLogging>  findAdminLoggingBySQL(String sql) throws SQLException
	{
		List<AdminLogging> adminLoggingList = new ArrayList<AdminLogging>();

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		while (rs.next()) {
			// 将一项纪录封装成一个AdminLogging对象
			AdminLogging m = new AdminLogging();
	
			m.setId(rs.getLong("id"));
			m.setUsername(rs.getString("username"));
			m.setLoginip(rs.getString("loginip"));
			m.setLogintime(rs.getString("logintime"));
			m.setResult(rs.getString("result"));
			
			// 将Administrator对象加入到list中
			adminLoggingList.add(index++, m);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return adminLoggingList;
	}
	
	/**
	 * 查询所有日志
	 * @return
	 * @throws SQLException 
	 */
	public List<AdminLogging> findAll() throws SQLException {
		String sql = "SELECT * FROM t_adminlogging ORDER BY id DESC";
		return this.findAdminLoggingBySQL(sql);
	}

	/**
	 * 删除指定id的日志
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int delete(Long id) throws SQLException {
		String sql = "DELETE FROM t_adminlogging WHERE id=?";	
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		prestmt.setLong(1, id);
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}
		

}
