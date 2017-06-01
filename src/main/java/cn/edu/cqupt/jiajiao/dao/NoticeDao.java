package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.Notice;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class NoticeDao {

	public int save(Notice notice) throws SQLException {
		String sql = "INSERT INTO t_notice(title,content,publishtime) values(?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, notice.getTitle());
		prestmt.setString(2, notice.getContent());	
		prestmt.setString(3, notice.getPublishtime());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<Notice> findAll() throws SQLException {
		String sql = "SELECT * FROM t_notice";
		List<Notice> noticeList = new ArrayList<Notice>();

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
			// 将一项纪录封装成一个Notice对象
			Notice n = new Notice();

			n.setContent(rs.getString("content"));
			n.setId(rs.getLong("id"));
			n.setPublishtime(rs.getString("publishtime"));
			n.setTitle(rs.getString("title"));
		
			// 将Notice对象加入到list中
			noticeList.add(index++, n);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return noticeList;
	}

	public int delete(Long id) throws SQLException {
		String sql = "DELETE FROM t_notice WHERE id=?";
		
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

	public Notice findNotice(Long noticeid) throws SQLException {
		String sql = "SELECT * FROM t_notice WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, noticeid);

		ResultSet rs = prestmt.executeQuery();

		if(rs.next())
		{
			// 将一项纪录封装成一个Notice对象
			Notice n = new Notice();
			
			
			n.setContent(rs.getString("content"));
			n.setId(rs.getLong("id"));
			n.setPublishtime(rs.getString("publishtime"));
			n.setTitle(rs.getString("title"));
			
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
