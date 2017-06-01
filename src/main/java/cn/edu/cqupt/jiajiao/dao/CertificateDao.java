package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import cn.edu.cqupt.jiajiao.domain.Certificate;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class CertificateDao {

	public int save(Certificate certificate) throws SQLException {
		String sql = "INSERT INTO t_certificate(teacherid,idcard,stucard,undergraduate," +
				"graduate,cet4,cet6,tem8,cct,toefl,ielts) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		prestmt.setLong(1,certificate.getTeacherid());
		prestmt.setString(2,certificate.getIdcard());
		prestmt.setString(3,certificate.getStucard());
		prestmt.setString(4,certificate.getUndergraduate());
		prestmt.setString(5,certificate.getGraduate());
		prestmt.setString(6,certificate.getCet4());
		prestmt.setString(7,certificate.getCet6());
		prestmt.setString(8,certificate.getTem8());
		prestmt.setString(9,certificate.getCct());
		prestmt.setString(10,certificate.getToefl());
		prestmt.setString(11,certificate.getIelts());
			
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public Certificate findCertificateByTeacherId(Long memeberid) throws SQLException {
		String sql = "SELECT * FROM t_certificate WHERE teacherid=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, memeberid);

		ResultSet rs = prestmt.executeQuery();

		if (rs.next()) {
			// 将一项纪录封装成一个Certificate对象
			Certificate t = new Certificate();
			
			t.setCct(rs.getString("cct"));
			t.setCet4(rs.getString("cet4"));
			t.setCet6(rs.getString("cet6"));
			t.setGraduate(rs.getString("graduate"));
			t.setId(rs.getLong("id"));
			t.setIdcard(rs.getString("idcard"));
			t.setIelts(rs.getString("ielts"));
			t.setStucard(rs.getString("stucard"));
			t.setTeacherid(rs.getLong("teacherid"));
			t.setTem8(rs.getString("tem8"));
			t.setToefl(rs.getString("toefl"));
			t.setUndergraduate(rs.getString("undergraduate"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return t;
		} else
		{
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return null;
		}
	}

	public int deleteCertificate(Long id) throws SQLException {
		String sql = "DELETE FROM t_certificate WHERE teacherid=?";
		
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
