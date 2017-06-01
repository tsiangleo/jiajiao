package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.cqupt.jiajiao.dao.RequirementDao;
import cn.edu.cqupt.jiajiao.dao.StudentDao;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.domain.Teacher;

public class StudentService 
{
	private StudentDao studentdao = new StudentDao();

	/**
	 * 保存学员信息
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public int save(Student student) throws SQLException
	{
		return studentdao.save(student);
	}

	/**
	 * 查询账户id为memberid的所有学生信息
	 * @param memberid
	 * @return
	 * @throws SQLException 
	 */
	public List<Student> findStudentByMemid(Long memberid) throws SQLException {
		return studentdao.findStudentByMemid(memberid);
	}

	/**
	 * 根据学员id查询学员
	 * @param stuid
	 * @return
	 * @throws SQLException 
	 */
	public Student findStudent(Integer stuid) throws SQLException {
		return studentdao.findStudent(stuid);
	}

	/**
	 * 更新学员信息
	 * @param student6
	 * @return
	 * @throws SQLException 
	 */
	public int update(Student student) throws SQLException {
		return studentdao.update(student);
	}

	/**
	 * 删除指定id的学员信息
	 * @param stuid7
	 * @return
	 * @throws SQLException 
	 */
	public int delete(Long stuid) throws SQLException {
		return studentdao.delete(stuid);
	}

	
}
