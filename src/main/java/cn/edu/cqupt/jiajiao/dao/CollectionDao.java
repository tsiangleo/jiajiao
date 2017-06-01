package cn.edu.cqupt.jiajiao.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Collection;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class CollectionDao {

	/**
	 * 保存收藏夹
	 * @param collection
	 * @return
	 * @throws SQLException
	 */
	public int save(Collection collection) throws SQLException {
		String sql = "INSERT INTO t_collection(memberid,teacherid,time) values(?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setLong(1,collection.getMemberid());
		prestmt.setLong(2,collection.getTeacherid());
		prestmt.setString(3,collection.getTime());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	
	/**
	 * 查找指定memberid的所有收藏夹
	 * @param studentid
	 * @return
	 * @throws SQLException
	 */
	public List<Collection> findAll(Long studentid) throws SQLException {
		
		String sql = "SELECT * FROM t_collection WHERE memberid=?";
		List<Collection> collections = new ArrayList<Collection>();
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		prestmt.setLong(1,studentid);
		ResultSet  rs = prestmt.executeQuery();
		int index = 0;
		while(rs.next())
		{
			//将一项纪录封装成一个Collection对象
			Collection c = new Collection();
			c.setId(rs.getLong("id"));
			c.setMemberid(rs.getLong("memberid"));
			c.setTeacherid(rs.getLong("teacherid"));
			c.setTime(rs.getString("time"));
	
			//将c对象加入到list中
			collections.add(index++, c);
			
		}
		
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return collections;

	}

	public int delete(Long id) throws SQLException {
		String sql = "DELETE FROM t_collection WHERE id=?";
		
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

