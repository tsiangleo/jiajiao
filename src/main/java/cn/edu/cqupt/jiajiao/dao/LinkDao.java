package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class LinkDao {

	public int save(Link link) throws SQLException {
		String sql = "INSERT INTO t_link(name,url,info) values(?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, link.getName());
		prestmt.setString(2, link.getUrl());
		prestmt.setString(3, link.getInfo());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<Link> findAll() throws SQLException {
		String sql = "SELECT * FROM t_link";
		List<Link> linkList = new ArrayList<Link>();

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
			// 将一项纪录封装成一个Link对象
			Link n = new Link();
	
			n.setInfo(rs.getString("info"));
			n.setName(rs.getString("name"));
			n.setId(rs.getLong("id"));
			n.setUrl(rs.getString("url"));
			
			// 将Link对象加入到list中
			linkList.add(index++, n);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return linkList;
		
	}

	public int delete(Long linkid) throws SQLException {

		String sql = "DELETE FROM t_link WHERE id=?";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		prestmt.setLong(1, linkid);
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public int update(Link link) throws SQLException {
		String sql = "UPDATE t_link SET name=?,url=?,info=? WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, link.getName());
		prestmt.setString(2, link.getUrl());
		prestmt.setString(3, link.getInfo());
		prestmt.setLong(4, link.getId());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public Link findLink(Long linkid) throws SQLException {
		String sql = "SELECT * FROM t_link WHERE id=?";
		List<Link> linkList = new ArrayList<Link>();

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setLong(1, linkid);
		
		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		if (rs.next()) {
			// 将一项纪录封装成一个Link对象
			Link n = new Link();
	
			n.setInfo(rs.getString("info"));
			n.setName(rs.getString("name"));
			n.setId(rs.getLong("id"));
			n.setUrl(rs.getString("url"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return n;

		}
		else
		{
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return null;
		}
	}

}
