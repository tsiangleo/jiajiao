package cn.edu.cqupt.jiajiao.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class RequirementDao {



	/**
	 * 保存学员需求信息
	 * @param requirement
	 * @return
	 * @throws SQLException
	 */
	public int save(Requirement requirement) throws SQLException {
		String sql = "INSERT INTO t_requirement(memberid,studentname,birthday,stugender," +
				"grade,subject,description,contacts,phone,area,salary,degree," +
				"gender,school,classtime,issuetime,state)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		prestmt.setLong(1,requirement.getMemberid());
		prestmt.setString(2,requirement.getStudentname());
	    prestmt.setString(3,requirement.getBirthday());
		prestmt.setString(4,requirement.getStugender());
		prestmt.setString(5,requirement.getGrade());
		prestmt.setString(6,requirement.getSubject());
		prestmt.setString(7,requirement.getDescription());
		prestmt.setString(8,requirement.getContacts());
		prestmt.setString(9,requirement.getPhone());
		prestmt.setString(10,requirement.getArea());
		prestmt.setLong(11,requirement.getSalary());
		prestmt.setString(12,requirement.getDegree());
		prestmt.setString(13,requirement.getGender());
		prestmt.setString(14,requirement.getSchool());
		prestmt.setString(15,requirement.getClasstime());
		
		// 将Date转换成指定形式的时间字符串  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String currtime = sdf.format(new java.util.Date());
        
        prestmt.setString(16,currtime);
		prestmt.setString(17,"可预约");
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 查询所有需求信息(可预约的)
	 * 排序规则：会员类型（升序）、搜索结果排序（升序）、登录次数（降序）
	 * @return
	 * @throws SQLException 
	 */
	public List<Requirement> findAll() throws SQLException {	
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_requirement AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' AND t2.`state`='可预约' ORDER BY t3.`sort` ASC,t1.`searchrank` ASC,t1.`logintimes` DESC;";
		//String sql = "SELECT * FROM t_requirement";	
		return this.findAll(sql);
	}

	/**
	 * 根据需求id查询需求信息
	 * @param requirementid
	 * @return
	 * @throws SQLException 
	 */
	public Requirement findRequirement(Integer requirementid) throws SQLException {
		String sql = "SELECT * FROM t_requirement WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;	
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, requirementid);
		
		ResultSet  rs = prestmt.executeQuery();
		
		if(rs.next())
		{
			//将一项纪录封装成一个Requirement对象
			Requirement r = new Requirement();
			
			r.setArea(rs.getString("area"));
			r.setBirthday(rs.getString("birthday"));
			r.setClasstime(rs.getString("classtime"));
			r.setContacts(rs.getString("contacts"));
			r.setDegree(rs.getString("degree"));
			r.setDescription(rs.getString("description"));
			r.setGender(rs.getString("gender"));
			r.setGrade(rs.getString("grade"));
			r.setId(rs.getLong("id"));
			r.setIssuetime(rs.getString("issuetime"));
			r.setMemberid(rs.getLong("memberid"));
			r.setPhone(rs.getString("phone"));
			r.setSalary(rs.getInt("salary"));
			r.setSchool(rs.getString("school"));
			r.setState(rs.getString("state"));
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


	
public List<Requirement> findAll(String sql) throws SQLException {
		
		List<Requirement> requirements = new ArrayList<Requirement>();
		
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
			//将一项纪录封装成一个Requirement对象
			Requirement r = new Requirement();
			
			r.setArea(rs.getString("area"));
			r.setBirthday(rs.getString("birthday"));
			r.setClasstime(rs.getString("classtime"));
			r.setContacts(rs.getString("contacts"));
			r.setDegree(rs.getString("degree"));
			r.setDescription(rs.getString("description"));
			r.setGender(rs.getString("gender"));
			r.setGrade(rs.getString("grade"));
			r.setId(rs.getLong("id"));
			r.setIssuetime(rs.getString("issuetime"));
			r.setMemberid(rs.getLong("memberid"));
			r.setPhone(rs.getString("phone"));
			r.setSalary(rs.getInt("salary"));
			r.setSchool(rs.getString("school"));
			r.setState(rs.getString("state"));
			r.setStudentname(rs.getString("studentname"));
			r.setStugender(rs.getString("stugender"));
			r.setSubject(rs.getString("subject"));
	
			//将requirement对象加入到list中
			requirements.add(index++, r);

		}
		
		rs.close();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return requirements;

	}


	/**
	 * 根据需求id修改需求信息
	 * @param requirement
	 * @return
	 * @throws SQLException
	 */
	public int update(Requirement requirement) throws SQLException {
		String sql = "UPDATE t_requirement SET studentname=?,birthday=?,stugender=?,"
				+ "grade=?,subject=?,description=?,contacts=?,phone=?,area=?,salary=?,degree=?,"
				+ "gender=?,school=?,classtime=?,issuetime=?,state=? WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;

		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		prestmt.setString(1, requirement.getStudentname());
		prestmt.setString(2, requirement.getBirthday());
		prestmt.setString(3, requirement.getStugender());
		prestmt.setString(4, requirement.getGrade());
		prestmt.setString(5, requirement.getSubject());
		prestmt.setString(6, requirement.getDescription());
		prestmt.setString(7, requirement.getContacts());
		prestmt.setString(8, requirement.getPhone());
		prestmt.setString(9, requirement.getArea());
		prestmt.setLong(10, requirement.getSalary());
		prestmt.setString(11, requirement.getDegree());
		prestmt.setString(12, requirement.getGender());
		prestmt.setString(13, requirement.getSchool());
		prestmt.setString(14, requirement.getClasstime());
		
		// 将Date转换成指定形式的时间字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currtime = sdf.format(new java.util.Date());

		prestmt.setString(15, currtime);
		prestmt.setString(16, requirement.getState());
		prestmt.setLong(17, requirement.getId());
		
		int result = prestmt.executeUpdate();
		prestmt.close();
		ConnectionManager.freeConnection(connection);
		return result;
	}

	/**
	 * 根据指定sql更新需求信息
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public int update(String sql) throws SQLException {
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

	public int getRequirementNum() {
		try {
			return this.findAll() == Collections.EMPTY_LIST ? 0 : this.findAll().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int getRequirementNum(String sql) {
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
