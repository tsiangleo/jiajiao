package cn.edu.cqupt.jiajiao.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class AdministratorDao {

	/**
	 * 保存管理员
	 * @param Administrator
	 * @return
	 * @throws SQLException
	 */
	public int save(Administrator Administrator) throws SQLException {
		String sql = "INSERT INTO t_administrator(username,password,realname,phone,role,gender) values(?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setString(1,Administrator.getUsername());
		prestmt.setString(2,Administrator.getPassword());
		prestmt.setString(3,Administrator.getRealname());
		prestmt.setString(4,Administrator.getPhone());
		prestmt.setString(5,Administrator.getRole());
		prestmt.setString(6,Administrator.getGender());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 根据管理员名查询管理员
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Administrator finAdministratorByName(String username) throws SQLException {
		String sql = "SELECT * FROM t_administrator WHERE username=?";

		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		prestmt = connection.prepareStatement(sql);
		prestmt.setString(1,username);
		ResultSet rs =  prestmt.executeQuery();
		
		if(rs.next())
		{
			Administrator m = new Administrator();
			m.setId(rs.getLong("id"));
			m.setPassword(rs.getString("password"));
			m.setPhone(rs.getString("phone"));
			m.setRole(rs.getString("role"));
			m.setUsername(rs.getString("username"));
			m.setBlacklist(rs.getString("blacklist"));
			m.setLogintimes(rs.getInt("logintimes"));
			m.setGender(rs.getString("gender"));
			m.setRealname(rs.getString("realname"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return m;
		}
		else
		{
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return null;
		}
	}


	/**
	 * 根据给定的sql语句更新账户信息
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public int updateBySQL(String sql) throws SQLException {
		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;	
		prestmt = connection.prepareStatement(sql);	
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}
	
	/**
	 * 查询所有管理员
	 * @return
	 * @throws SQLException
	 */
	public List<Administrator> findAll() throws SQLException {
		String sql = "SELECT * FROM t_administrator";
		return this.findAdministratorBySQL(sql);
		
	}

	public List<Administrator> findAdministratorBySQL(String sql) throws SQLException {

		List<Administrator> AdministratorList = new ArrayList<Administrator>();

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
			// 将一项纪录封装成一个Administrator对象
			Administrator m = new Administrator();
	
			m.setId(rs.getLong("id"));
			m.setPassword(rs.getString("password"));
			m.setPhone(rs.getString("phone"));
			m.setRole(rs.getString("role"));
			m.setUsername(rs.getString("username"));
			m.setBlacklist(rs.getString("blacklist"));
			m.setLogintimes(rs.getInt("logintimes"));
			m.setGender(rs.getString("gender"));
			m.setRealname(rs.getString("realname"));
			
			// 将Administrator对象加入到list中
			AdministratorList.add(index++, m);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return AdministratorList;
		
	}

	/**
	 * 删除指定id的管理员
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int delete(Long id) throws SQLException {
		String sql = "DELETE FROM t_administrator WHERE id=?";	
		
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
