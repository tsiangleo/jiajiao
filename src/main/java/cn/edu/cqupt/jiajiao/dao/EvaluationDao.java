package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Evaluation;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class EvaluationDao {

	public int save(Evaluation evaluation) throws SQLException {
		String sql = "INSERT INTO t_evaluation(teacherid,totalevaluation,content,author,time) values(?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setLong(1,evaluation.getTeacherid());
		prestmt.setString(2,evaluation.getTotalevaluation());
		prestmt.setString(3,evaluation.getContent());
		prestmt.setString(4,evaluation.getAuthor());
		prestmt.setString(5,evaluation.getTime());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}
	
	public List<Evaluation>  findAll(Long teacherid) throws SQLException
	{
		List<Evaluation> evaluationList = new ArrayList<Evaluation>();

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		String sql = "SELECT * FROM t_evaluation WHERE teacherid=?";		
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setLong(1,teacherid);
		
		ResultSet rs = prestmt.executeQuery();
		int index = 0;
		while (rs.next()) {
			// 将一项纪录封装成一个Evaluation对象
			Evaluation m = new Evaluation();
	
			m.setId(rs.getLong("id"));
			m.setAuthor(rs.getString("author"));
			m.setContent(rs.getString("content"));
			m.setReply(rs.getString("reply"));
			m.setTeacherid(rs.getLong("teacherid"));
			m.setTime(rs.getString("time"));
			m.setTotalevaluation(rs.getString("totalevaluation"));
			
			// 将Evaluation对象加入到list中
			evaluationList.add(index++, m);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return evaluationList;
	}

}
