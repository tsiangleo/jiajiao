package cn.edu.cqupt.jiajiao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class TeacherDao {

	/**
	 * 保存教员详细信息
	 * 
	 * @param teacher
	 * @return
	 * @throws SQLException
	 */
	public int save(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO t_teacher(memberid,teachername,mobilephone,birthday,"
				+ "gender,school,degree,specialty,address,subject,grade,"
				+ "servicearea,servicetype,certificate,salary,description,notes,photo)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		prestmt.setLong(1, teacher.getMemberid());
		prestmt.setString(2, teacher.getTeachername());
		prestmt.setString(3, teacher.getMobilephone());
		prestmt.setString(4, teacher.getBirthday());
		prestmt.setString(5, teacher.getGender());
		prestmt.setString(6, teacher.getSchool());
		prestmt.setString(7, teacher.getDegree());
		prestmt.setString(8, teacher.getSpecialty());
		prestmt.setString(9, teacher.getAddress());
		prestmt.setString(10, teacher.getSubject());
		prestmt.setString(11, teacher.getGrade());
		prestmt.setString(12, teacher.getServicearea());
		prestmt.setString(13, teacher.getServicetype());
		prestmt.setString(14, teacher.getCertificate());
		prestmt.setInt(15, teacher.getSalary());
		prestmt.setString(16, teacher.getDescription());
		prestmt.setString(17, teacher.getNotes());
		prestmt.setString(
				18,
				teacher.getPhoto() == null ? "upLoadFile/default.jpg" : teacher
						.getPhoto());

		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 查询所有教师
	 * 排序规则：会员类型（升序）、搜索结果排序（升序）、登录次数（降序）
	 * @return
	 * @throws SQLException
	 */
	public List<Teacher> findAll() throws SQLException {
		//String sql = "SELECT * FROM t_teacher ";
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_teacher AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' ORDER BY t3.`sort` ASC,t2.`evaluation` DESC,t1.`searchrank` ASC,t1.`logintimes` DESC";
		return this.findAll(sql);
	}

	/**
	 * 根据id查询
	 * @param teacherid
	 * @return
	 * @throws SQLException
	 */
	public Teacher findTeacher(Long teacherid) throws SQLException {
		String sql = "SELECT * FROM t_teacher WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, teacherid);

		ResultSet rs = prestmt.executeQuery();

		if(rs.next())
		{
			// 将一项纪录封装成一个Teacher对象
			Teacher t = new Teacher();
			t.setAddress(rs.getString("address"));
			t.setAuthentication(rs.getString("authentication"));
			t.setBirthday(rs.getString("birthday"));
			t.setCertificate(rs.getString("certificate"));
			t.setDegree(rs.getString("degree"));
			t.setDescription(rs.getString("description"));
			t.setGender(rs.getString("gender"));
			t.setGrade(rs.getString("grade"));
			t.setId(rs.getLong("id"));
			t.setMobilephone(rs.getString("mobilephone"));
			t.setNotes(rs.getString("notes"));
			t.setSalary(rs.getInt("salary"));
			t.setSchool(rs.getString("school"));
			t.setServicearea(rs.getString("servicearea"));
			t.setServicetype(rs.getString("servicetype"));
			t.setSpecialty(rs.getString("specialty"));
			t.setSubject(rs.getString("subject"));
			t.setTeachername(rs.getString("teachername"));
			t.setPhoto(rs.getString("photo"));
			t.setEvaluation(rs.getInt("evaluation"));
			
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return t;
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
	 * 根据SQL条件返回所有的teacher对象
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public List<Teacher> findAll(String sql) throws SQLException {
		List<Teacher> teachers = new ArrayList<Teacher>();

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
			// 将一项纪录封装成一个Teacher对象
			Teacher t = new Teacher();
			t.setAddress(rs.getString("address"));
			t.setAuthentication(rs.getString("authentication"));
			t.setBirthday(rs.getString("birthday"));
			t.setCertificate(rs.getString("certificate"));
			t.setDegree(rs.getString("degree"));
			t.setDescription(rs.getString("description"));
			t.setGender(rs.getString("gender"));
			t.setGrade(rs.getString("grade"));
			t.setId(rs.getLong("id"));
			t.setMemberid(rs.getLong("memberid"));
			t.setMobilephone(rs.getString("mobilephone"));
			t.setNotes(rs.getString("notes"));
			t.setSalary(rs.getInt("salary"));
			t.setSchool(rs.getString("school"));
			t.setServicearea(rs.getString("servicearea"));
			t.setServicetype(rs.getString("servicetype"));
			t.setSpecialty(rs.getString("specialty"));
			t.setSubject(rs.getString("subject"));
			t.setTeachername(rs.getString("teachername"));
			t.setPhoto(rs.getString("photo"));
			t.setEvaluation(rs.getInt("evaluation"));
			// 将teacher对象加入到list中
			teachers.add(index++, t);

		}
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return teachers;
	}

	/**
	 * 更具教员名字查询教员信息
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public Teacher findTeacher(String username) throws SQLException {
		String sql = "SELECT * FROM t_teacher WHERE teachername=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setString(1, username);

		ResultSet rs = prestmt.executeQuery();

		if (rs.next()) {
			// 将一项纪录封装成一个Teacher对象
			Teacher t = new Teacher();
			t.setAddress(rs.getString("address"));
			t.setAuthentication(rs.getString("authentication"));
			t.setBirthday(rs.getString("birthday"));
			t.setCertificate(rs.getString("certificate"));
			t.setDegree(rs.getString("degree"));
			t.setDescription(rs.getString("description"));
			t.setGender(rs.getString("gender"));
			t.setGrade(rs.getString("grade"));
			t.setId(rs.getLong("id"));
			t.setMobilephone(rs.getString("mobilephone"));
			t.setNotes(rs.getString("notes"));
			t.setSalary(rs.getInt("salary"));
			t.setSchool(rs.getString("school"));
			t.setServicearea(rs.getString("servicearea"));
			t.setServicetype(rs.getString("servicetype"));
			t.setSpecialty(rs.getString("specialty"));
			t.setSubject(rs.getString("subject"));
			t.setTeachername(rs.getString("teachername"));
			t.setPhoto(rs.getString("photo"));
			t.setEvaluation(rs.getInt("evaluation"));

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

	/**
	 * 更新教师信息
	 * 
	 * @param teacher
	 * @return
	 * @throws SQLException 
	 */
	public int upadte(Teacher teacher) throws SQLException {
		if(teacher.getPhoto() == null)
		{
			String sql = "UPDATE  t_teacher SET teachername=?,mobilephone=?,birthday=?,"
				+ "gender=?,school=?,degree=?,specialty=?,address=?,subject=?,grade=?,"
				+ "servicearea=?,servicetype=?,certificate=?,salary=?,description=?,notes=? WHERE memberid=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		prestmt.setString(1, teacher.getTeachername());
		prestmt.setString(2, teacher.getMobilephone());
		prestmt.setString(3, teacher.getBirthday());
		prestmt.setString(4, teacher.getGender());
		prestmt.setString(5, teacher.getSchool());
		prestmt.setString(6, teacher.getDegree());
		prestmt.setString(7, teacher.getSpecialty());
		prestmt.setString(8, teacher.getAddress());
		prestmt.setString(9, teacher.getSubject());
		prestmt.setString(10, teacher.getGrade());
		prestmt.setString(11, teacher.getServicearea());
		prestmt.setString(12, teacher.getServicetype());
		prestmt.setString(13, teacher.getCertificate());
		prestmt.setInt(14, teacher.getSalary());
		prestmt.setString(15, teacher.getDescription());
		prestmt.setString(16, teacher.getNotes());
		prestmt.setLong(17, teacher.getMemberid());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
			
		}
		else
		{
			String sql = "UPDATE  t_teacher SET teachername=?,mobilephone=?,birthday=?,"
					+ "gender=?,school=?,degree=?,specialty=?,address=?,subject=?,grade=?,"
					+ "servicearea=?,servicetype=?,certificate=?,salary=?,description=?,notes=?,photo=? WHERE memberid=?";
	
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement prestmt = null;
	
			try {
				prestmt = connection.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			prestmt.setString(1, teacher.getTeachername());
			prestmt.setString(2, teacher.getMobilephone());
			prestmt.setString(3, teacher.getBirthday());
			prestmt.setString(4, teacher.getGender());
			prestmt.setString(5, teacher.getSchool());
			prestmt.setString(6, teacher.getDegree());
			prestmt.setString(7, teacher.getSpecialty());
			prestmt.setString(8, teacher.getAddress());
			prestmt.setString(9, teacher.getSubject());
			prestmt.setString(10, teacher.getGrade());
			prestmt.setString(11, teacher.getServicearea());
			prestmt.setString(12, teacher.getServicetype());
			prestmt.setString(13, teacher.getCertificate());
			prestmt.setInt(14, teacher.getSalary());
			prestmt.setString(15, teacher.getDescription());
			prestmt.setString(16, teacher.getNotes());
			prestmt.setString(17,teacher.getPhoto());
			prestmt.setLong(18, teacher.getMemberid());
				
			int result = prestmt.executeUpdate();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return result;
		}
	}

	public int upadteBySQL(String sql) throws SQLException {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 获得教师数量
	 * @return
	 */
	public int getTeacherNum() {
		try {
			return this.findAll() == Collections.EMPTY_LIST ? 0 : this.findAll().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据给定 的SQL查询返回教师数量
	 * @param sql
	 * @return
	 */
	public int getTeacherNum(String sql) {
		// TODO Auto-generated method stub
		try {
			return this.findAll(sql) == Collections.EMPTY_LIST ? 0: this.findAll(sql).size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
