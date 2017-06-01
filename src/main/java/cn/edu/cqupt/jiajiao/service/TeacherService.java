package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.MemberDao;
import cn.edu.cqupt.jiajiao.dao.TeacherDao;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;

public class TeacherService 
{
	private TeacherDao teacherdao = new TeacherDao();

	public int save(Teacher teacher) throws SQLException
	{
		return teacherdao.save(teacher);
	}

	/**
	 * 查询所有教师
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findAll() throws SQLException {
		
		return  teacherdao.findAll();
	}

	/**
	 * 根据id查询教师信息
	 * @param teacherid
	 * @return
	 * @throws SQLException 
	 */
	public Teacher findTeacher(Long teacherid) throws SQLException {
		return teacherdao.findTeacher(teacherid);
	}

	/**
	 * 根据SQL语句，查询对应的教师信息
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findteacherBySQL(String sql) throws SQLException {
		return teacherdao.findAll(sql);
	}

	/**
	 * 根据教员的名字查找教员信息
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	public Teacher findTeacher(String username) throws SQLException {
		return teacherdao.findTeacher(username);
	}

	/**
	 * 根据教员的账户id查找教员信息
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Teacher findTeacherByMemid(Long id) throws SQLException {
		
		ArrayList<Teacher> t = new ArrayList<Teacher>();
		t = (ArrayList<Teacher>) findteacherBySQL("SELECT * FROM t_teacher WHERE memberid="+id+"");
		if(t == Collections.EMPTY_LIST || t.size() == 0)
			return null;
		else
			return t.get(0);
	}

	/*
	 * 更新教师信息
	 */
	public int upadte(Teacher teacher) throws SQLException {
		return teacherdao.upadte(teacher);
	}

	public int  updateHasCertificate(Long id, String newstate) throws SQLException {
		String sql = "UPDATE t_teacher SET hascertificate='"+newstate+"' WHERE id="+id+"";
		return teacherdao.upadteBySQL(sql);
		
	}

	public int updateAuthentication(Long id, String authentication) throws SQLException {
		String sql = "UPDATE t_teacher SET authentication='"+authentication+"' WHERE id="+id+"";
		return teacherdao.upadteBySQL(sql);
	}
	
	public int updateEvaluation(Long id, int value) {
		String sql = "UPDATE t_teacher SET evaluation=evaluation+"+value+" WHERE id="+id+"";
		try {
			return teacherdao.upadteBySQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 查询前10个教师信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findTop10() throws SQLException {
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_teacher AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' ORDER BY t3.`sort` ASC,t2.`evaluation` DESC,t1.`searchrank` ASC,t1.`logintimes` DESC LIMIT 0,10";
		return teacherdao.findAll(sql);
	}


	/**
	 * 查询前6个VIP家教
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findVIPTOP6() throws SQLException {
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_teacher AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' AND t1.`type`!='普通会员' ORDER BY t3.`sort` ASC,t2.`evaluation` DESC,t1.`searchrank` ASC,t1.`logintimes` DESC LIMIT 0,6";
		return teacherdao.findAll(sql);
	}

	/**
	 * 根据teacher信息推荐需求信息
	 * @param Teacher
	 * @return 推荐的需求列表
	 * @throws SQLException 
	 */
	public List<Requirement> RecommendRequirement(Teacher t) throws SQLException {
		//Teacher 辅导科目不限，辅导地区不限
		//Requirement：学历不限，学校不限，性别要求不限
		String sql = "SELECT * FROM t_requirement WHERE grade='"+t.getGrade()+"' AND salary="+t.getSalary()+" AND '"+t.getSubject()+"' IN (t_requirement.`subject`,'不限') AND '"+t.getServicearea()+"' IN (t_requirement.`area`,'不限') AND degree IN ('"+t.getDegree()+"','不限') AND gender IN ('"+t.getGender()+"','不限') AND school IN ('"+t.getSchool()+"','不限') AND state='可预约' LIMIT 0,15";
		RequirementService rs = new RequirementService();
		return rs.findrequirementBySQL(sql);
		
	}

	
	
	
	/**
	 * 获得教师数量
	 * @return
	 */
	public int getTeacherNum() {
		return teacherdao.getTeacherNum();
	}

	/**
	 * 返回从fromindex之后的PageSize条大小的记录
	 * @param fromIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findAll(int fromIndex, int pageSize) throws SQLException {
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_teacher AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' ORDER BY t3.`sort` ASC,t2.`evaluation` DESC,t1.`searchrank` ASC,t1.`logintimes` DESC LIMIT "+fromIndex+","+pageSize;
		return teacherdao.findAll(sql);
	}

	/**
	 * 根据给定 的SQL查询返回教师数量
	 * @param sql
	 * @return
	 */
	public int getTeacherNum(String sql) {
		return teacherdao.getTeacherNum(sql);
	}

	/**
	 * 返回从fromindex之后的PageSize条大小的记录
	 * @param fromIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Teacher> findteacherBySQL(String sql, int fromIndex,int pageSize) throws SQLException {
		String SQL = sql + " LIMIT "+fromIndex+","+pageSize;
		return teacherdao.findAll(SQL);
	}
	
}
