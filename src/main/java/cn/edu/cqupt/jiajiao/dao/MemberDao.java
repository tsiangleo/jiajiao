package cn.edu.cqupt.jiajiao.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.MemberType;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class MemberDao {

	/**
	 * 保存用户
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public int save(Member member) throws SQLException {
		String sql = "INSERT INTO t_member(username,password,email,phone,role,registdate,registip) values(?,?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setString(1,member.getUsername());
		prestmt.setString(2,member.getPassword());
		prestmt.setString(3,member.getEmail());
		prestmt.setString(4,member.getPhone());
		prestmt.setString(5,member.getRole());
		prestmt.setString(7,member.getRegistip());
		
		// 将Date转换成指定形式的时间字符串  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String currtime = sdf.format(new java.util.Date());
        
		prestmt.setString(6,currtime);
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}
	
	/**
	 * 根据id查询用户
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Member finMemberById(Long id) throws SQLException {
		String sql = "SELECT * FROM t_member WHERE id=?";

		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		prestmt = connection.prepareStatement(sql);
		prestmt.setLong(1,id);
		ResultSet rs =  prestmt.executeQuery();
		
		if(rs.next())
		{
			Member m = new Member();
			m.setId(rs.getLong("id"));
			m.setEmail(rs.getString("email"));
			m.setBalance(rs.getInt("balance"));
			m.setLastip(rs.getString("lastip"));
			m.setLasttime(rs.getString("lasttime"));
			m.setLoginip(rs.getString("loginip"));
			m.setLogintime(rs.getString("logintime"));
			m.setPassword(rs.getString("password"));
			m.setPhone(rs.getString("phone"));
			m.setRegistdate(rs.getString("registdate"));
			m.setRole(rs.getString("role"));
			m.setUsername(rs.getString("username"));
			m.setBlacklist(rs.getString("blacklist"));
			m.setLogintimes(rs.getInt("logintimes"));
			m.setRegistip(rs.getString("registip"));
			m.setSearchrank(rs.getInt("searchrank"));
			m.setType(rs.getString("type"));
			m.setVIPdeadline(rs.getString("vIPdeadline"));
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
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Member finMemberByName(String username) throws SQLException {
		String sql = "SELECT * FROM t_member WHERE username=?";

		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		prestmt = connection.prepareStatement(sql);
		prestmt.setString(1,username);
		ResultSet rs =  prestmt.executeQuery();
		
		if(rs.next())
		{
			Member m = new Member();
			m.setId(rs.getLong("id"));
			m.setEmail(rs.getString("email"));
			m.setBalance(rs.getInt("balance"));
			m.setLastip(rs.getString("lastip"));
			m.setLasttime(rs.getString("lasttime"));
			m.setLoginip(rs.getString("loginip"));
			m.setLogintime(rs.getString("logintime"));
			m.setPassword(rs.getString("password"));
			m.setPhone(rs.getString("phone"));
			m.setRegistdate(rs.getString("registdate"));
			m.setRole(rs.getString("role"));
			m.setUsername(rs.getString("username"));
			m.setBlacklist(rs.getString("blacklist"));
			m.setLogintimes(rs.getInt("logintimes"));
			m.setRegistip(rs.getString("registip"));
			m.setSearchrank(rs.getInt("searchrank"));
			m.setType(rs.getString("type"));
			m.setVIPdeadline(rs.getString("vIPdeadline"));
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
	 * 更新会员的登录信息
	 * @param member
	 * @return 
	 * @throws SQLException 
	 */
	public int updateLogin(Member member) throws SQLException {
		String sql = "UPDATE t_member SET logintimes=logintimes+1,lasttime=logintime,lastip=loginip,logintime=?,loginip=? WHERE username=?";

		Connection connection =  ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		prestmt = connection.prepareStatement(sql);
	
		// 将Date转换成指定形式的时间字符串  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String currtime = sdf.format(new java.util.Date());
        
        prestmt.setString(1,currtime);
		prestmt.setString(2,member.getLoginip());
		prestmt.setString(3,member.getUsername());
		
	    int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
		
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
	 * 查询所有会员
	 * @return
	 * @throws SQLException
	 */
	public List<Member> findAll() throws SQLException {
		String sql = "SELECT * FROM t_member";
		return this.findMemberBySQL(sql);
		
	}

	public List<Member> findMemberBySQL(String sql) throws SQLException {

		List<Member> memberList = new ArrayList<Member>();

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
			// 将一项纪录封装成一个Member对象
			Member m = new Member();
	
			m.setId(rs.getLong("id"));
			m.setEmail(rs.getString("email"));
			m.setBalance(rs.getInt("balance"));
			m.setLastip(rs.getString("lastip"));
			m.setLasttime(rs.getString("lasttime"));
			m.setLoginip(rs.getString("loginip"));
			m.setLogintime(rs.getString("logintime"));
			m.setPassword(rs.getString("password"));
			m.setPhone(rs.getString("phone"));
			m.setRegistdate(rs.getString("registdate"));
			m.setRole(rs.getString("role"));
			m.setUsername(rs.getString("username"));
			m.setBlacklist(rs.getString("blacklist"));
			m.setLogintimes(rs.getInt("logintimes"));
			m.setRegistip(rs.getString("registip"));
			m.setSearchrank(rs.getInt("searchrank"));
			m.setType(rs.getString("type"));
			m.setVIPdeadline(rs.getString("vIPdeadline"));
			
			// 将Member对象加入到list中
			memberList.add(index++, m);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return memberList;
		
	}

}
