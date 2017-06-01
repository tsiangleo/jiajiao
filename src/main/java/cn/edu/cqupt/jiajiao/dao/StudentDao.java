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
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class StudentDao {

	/**
	 * 保存学员信息
	 * @param requirement
	 * @return
	 * @throws SQLException
	 */
	public int save(Student student) throws SQLException {
		String sql = "INSERT INTO t_student(memberid,studentname,birthday,stugender," +
				"grade,subject,description) values(?,?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prestmt.setLong(1,student.getMemberid());
		prestmt.setString(2,student.getStudentname());
	    prestmt.setString(3,student.getBirthday());
		prestmt.setString(4,student.getStugender());
		prestmt.setString(5,student.getGrade());
		prestmt.setString(6,student.getSubject());
		prestmt.setString(7,student.getDescription());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	public List<Student> findStudentByMemid(Long memberid) throws SQLException {
		
		String sql = "SELECT * FROM t_student WHERE memberid="+ memberid +"";
		List<Student> students = new ArrayList<Student>();
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet  rs = prestmt.executeQuery();
		int index = 0;
		while(rs.next())
		{
			//将一项纪录封装成一个Student对象
			Student r = new Student();
	
			r.setBirthday(rs.getString("birthday"));
			r.setDescription(rs.getString("description"));
			r.setGrade(rs.getString("grade"));
			r.setId(rs.getLong("id"));
			r.setMemberid(rs.getLong("memberid"));
			r.setStudentname(rs.getString("studentname"));
			r.setStugender(rs.getString("stugender"));
			r.setSubject(rs.getString("subject"));
	
			//将student对象加入到list中
			students.add(index++, r);
			
		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return students;

	}

	/**
	 * 根据学员id查询学员信息
	 * @param stuid
	 * @return
	 * @throws SQLException 
	 */
	public Student findStudent(Integer stuid) throws SQLException {
		String sql = "SELECT * FROM t_student WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, stuid);
		
		ResultSet  rs = prestmt.executeQuery();
		
		if(rs.next())
		{
			//将一项纪录封装成一个Student对象
			Student r = new Student();
			
			
			r.setBirthday(rs.getString("birthday"));
			r.setDescription(rs.getString("description"));
			r.setGrade(rs.getString("grade"));
			r.setId(rs.getLong("id"));
			r.setMemberid(rs.getLong("memberid"));
			r.setStudentname(rs.getString("studentname"));
			r.setStugender(rs.getString("stugender"));
			r.setSubject(rs.getString("subject"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return r;
		}
		else
		{
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return null;
		}
	}

	public int update(Student student) throws SQLException {
		String sql = "UPDATE t_student SET studentname=?,birthday=?,stugender=?,"
				+ "grade=?,subject=?,description=? WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setString(1, student.getStudentname());
		prestmt.setString(2, student.getBirthday());
		prestmt.setString(3, student.getStugender());
		prestmt.setString(4, student.getGrade());
		prestmt.setString(5, student.getSubject());
		prestmt.setString(6, student.getDescription());
		prestmt.setLong(7, student.getId());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 删除指定id的学员信息
	 * @param stuid
	 * @return
	 * @throws SQLException
	 */
	public int delete(Long stuid) throws SQLException {
		String sql = "DELETE FROM t_student WHERE id=?";
	
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		prestmt.setLong(1, stuid);
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

}
