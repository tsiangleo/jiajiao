package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class NewsDao {

	public int save(News news) throws SQLException {
		String sql = "INSERT INTO t_news(title,content,source,publishtime,type) values(?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, news.getTitle());
		prestmt.setString(2, news.getContent());
		prestmt.setString(3, news.getSource());
		prestmt.setString(4, news.getPublishtime());
		prestmt.setString(5, news.getType());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<News> findAll() throws SQLException {
		String sql = "SELECT * FROM t_news ORDER BY id DESC";
		return this.findBySQL(sql);
	}

	public News findNews(Long newsid) throws SQLException {
		String sql = "SELECT * FROM t_news WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, newsid);

		ResultSet rs = prestmt.executeQuery();

		if(rs.next())
		{
			// 将一项纪录封装成一个news对象
			News n = new News();
			
			n.setClick(rs.getShort("click"));
			n.setContent(rs.getString("content"));
			n.setId(rs.getLong("id"));
			n.setPublishtime(rs.getString("publishtime"));
			n.setSource(rs.getString("source"));
			n.setTitle(rs.getString("title"));
			n.setType(rs.getString("type"));
			
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

	public void updateClick(Long newsid) throws SQLException {
		String sql = "UPDATE t_news SET click=click+1 WHERE id=?";
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		prestmt.setLong(1, newsid);
		prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);

	}

	public int delete(Long newsid) throws SQLException {
		String sql = "DELETE FROM t_news WHERE id=?";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		prestmt.setLong(1, newsid);
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<News> findBySQL(String sql) {
		List<News> newsList = new ArrayList<News>();

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		try 
		{
		prestmt = connection.prepareStatement(sql);
		rs = prestmt.executeQuery();
		int index = 0;
		while (rs.next()) {
			// 将一项纪录封装成一个News对象
			News n = new News();
	
			n.setClick(rs.getShort("click"));
			n.setContent(rs.getString("content"));
			n.setId(rs.getLong("id"));
			n.setPublishtime(rs.getString("publishtime"));
			n.setSource(rs.getString("source"));
			n.setTitle(rs.getString("title"));
			n.setType(rs.getString("type"));
			// 将News对象加入到list中
			newsList.add(index++, n);

		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
        if(rs!=null){
            try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(prestmt!=null){
        	try {
				prestmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        ConnectionManager.freeConnection(connection);
		}
		
		return newsList;
		
	}
	
	/**
	 * 返回新闻类别
	 * @return
	 */
	public List<String> queryNewsType()
	{
		List<String> newstype = new ArrayList<String>();
		String sql = "SELECT * FROM t_newstype ";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = prestmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(rs.next())
			{
				newstype.add(rs.getString("newsType"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
        if(rs!=null){
            try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(prestmt!=null){
        	try {
				prestmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        ConnectionManager.freeConnection(connection);
		}
		
		return newstype;
	}

	/**
	 * 返回新闻总条数
	 * @return
	 */
	public int getNewsNum() {
		try {
			return this.findAll() == Collections.EMPTY_LIST ? 0 : this.findAll().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
