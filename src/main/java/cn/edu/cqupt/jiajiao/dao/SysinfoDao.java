package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Sysinfo;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class SysinfoDao {

	public int update(Sysinfo sysinfo) throws SQLException {
		String sql = "UPDATE t_sysinfo SET sitename=?,sitelogo=?,siteurl=?,keywords=?,description=?," +
				"serviceqq=?,adminemail=?,ICP=?,copyright=?";

	Connection connection = ConnectionManager.getConnection();
	PreparedStatement prestmt = null;

	try {
		prestmt = connection.prepareStatement(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}

	prestmt.setString(1, sysinfo.getSitename());
	prestmt.setString(2, sysinfo.getSitelogo());
	prestmt.setString(3, sysinfo.getSiteurl());
	prestmt.setString(4, sysinfo.getKeywords());
	prestmt.setString(5, sysinfo.getDescription());
	prestmt.setString(6, sysinfo.getServiceqq());
	prestmt.setString(7, sysinfo.getAdminemail());
	prestmt.setString(8, sysinfo.getICP());
	prestmt.setString(9, sysinfo.getCopyright());
	
	int result = prestmt.executeUpdate();
	prestmt.close();
	ConnectionManager.freeConnection(connection);
	return result;
	}

	public Sysinfo findAll() throws SQLException {
		String sql = "SELECT * FROM t_sysinfo";
		

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		if (rs.next()) 
		{
			// 将一项纪录封装成一个Sysinfo对象
			Sysinfo sysinfo = new Sysinfo();
			
			sysinfo.setAboutus(rs.getString("aboutus"));
			sysinfo.setAdminemail(rs.getString("adminemail"));
			sysinfo.setContactus(rs.getString("contactus"));
			sysinfo.setCopyright(rs.getString("copyright"));
			sysinfo.setDescription(rs.getString("description"));
			sysinfo.setICP(rs.getString("iCP"));
			sysinfo.setId(rs.getLong("id"));
			sysinfo.setKeywords(rs.getString("keywords"));
			sysinfo.setServiceqq(rs.getString("serviceqq"));
			sysinfo.setSitelogo(rs.getString("sitelogo"));
			sysinfo.setSitename(rs.getString("sitename"));
			sysinfo.setSiteurl(rs.getString("siteurl"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return sysinfo;
		}
		else
		{
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);	
			return null;
		}
	}

	public int updateBySQL(String sql) throws SQLException {
		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;	
		prestmt = connection.prepareStatement(sql);	
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

}
