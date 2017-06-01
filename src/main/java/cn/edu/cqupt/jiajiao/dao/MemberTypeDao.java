package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.MemberType;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class MemberTypeDao {

	public int save(MemberType membertype) throws SQLException {
		String sql = "INSERT INTO t_membertype(typename,sort,moneypt,discount,expense,validperiod) values(?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, membertype.getTypename());
		prestmt.setInt(2, membertype.getSort());
		prestmt.setInt(3, membertype.getMoneypt());
		prestmt.setFloat(4, membertype.getDiscount());
		prestmt.setInt(5, membertype.getExpense());
		prestmt.setInt(6, membertype.getValidperiod());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<MemberType> findAll() throws SQLException {
		String sql = "SELECT * FROM t_membertype";
		List<MemberType> membertypeList = new ArrayList<MemberType>();

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
			// 将一项纪录封装成一个MemberType对象
			MemberType n = new MemberType();
	
			n.setDiscount(rs.getFloat("discount"));
			n.setExpense(rs.getInt("expense"));
			n.setId(rs.getLong("id"));
			n.setMoneypt(rs.getInt("moneypt"));
			n.setSort(rs.getInt("sort"));
			n.setTypename(rs.getString("typename"));
			n.setValidperiod(rs.getInt("validperiod"));
			// 将MemberType对象加入到list中
			membertypeList.add(index++, n);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return membertypeList;
		
	}

	public MemberType findMemberType(Long membertypeid) throws SQLException {
		String sql = "SELECT * FROM t_membertype WHERE id=?";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setLong(1, membertypeid);
		
		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		if (rs.next()) {
			// 将一项纪录封装成一个MemberType对象
			MemberType n = new MemberType();
			
			n.setDiscount(rs.getFloat("discount"));
			n.setExpense(rs.getInt("expense"));
			n.setId(rs.getLong("id"));
			n.setMoneypt(rs.getInt("moneypt"));
			n.setSort(rs.getInt("sort"));
			n.setTypename(rs.getString("typename"));
			n.setValidperiod(rs.getInt("validperiod"));
			
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

	public int update(MemberType membertype) throws SQLException {
		String sql = "UPDATE t_membertype SET typename=?,sort=?,moneypt=?,discount=?,expense=?,validperiod=? WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, membertype.getTypename());
		prestmt.setInt(2, membertype.getSort());
		prestmt.setInt(3, membertype.getMoneypt());
		prestmt.setFloat(4, membertype.getDiscount());
		prestmt.setInt(5, membertype.getExpense());
		prestmt.setInt(6, membertype.getValidperiod());
		prestmt.setLong(7, membertype.getId());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public int delete(Long memertypeid) throws SQLException {
		String sql = "DELETE FROM t_membertype WHERE id=?";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		prestmt.setLong(1, memertypeid);
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public MemberType findMemberType(String typename) throws SQLException {
String sql = "SELECT * FROM t_membertype WHERE typename=?";
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, typename);
		
		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		if (rs.next()) {
			// 将一项纪录封装成一个MemberType对象
			MemberType n = new MemberType();
			
			n.setDiscount(rs.getFloat("discount"));
			n.setExpense(rs.getInt("expense"));
			n.setId(rs.getLong("id"));
			n.setMoneypt(rs.getInt("moneypt"));
			n.setSort(rs.getInt("sort"));
			n.setTypename(rs.getString("typename"));
			n.setValidperiod(rs.getInt("validperiod"));
			
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
