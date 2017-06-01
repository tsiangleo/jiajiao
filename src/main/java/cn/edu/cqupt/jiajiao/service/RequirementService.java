package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.cqupt.jiajiao.dao.RequirementDao;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;

public class RequirementService 
{
	private RequirementDao requirementdao = new RequirementDao();

	public int save(Requirement requirement) throws SQLException
	{
		return requirementdao.save(requirement);
	}

	/**
	 * 查询所有需求信息
	 * @return
	 * @throws SQLException 
	 */
	public List<Requirement> findAll() throws SQLException {
		return requirementdao.findAll();
	}

	/**
	 * 根据需求id查询需求信息
	 * @param requirementid
	 * @return
	 * @throws SQLException 
	 */
	public Requirement findRequirement(Integer requirementid) throws SQLException {
		return requirementdao.findRequirement(requirementid);
		
	}

	public List<Requirement> findrequirementBySQL(String sql) throws SQLException {
		return requirementdao.findAll(sql);
	}

	/**
	 * 根据会员id查询需求信息
	 * @param memberid5
	 * @return
	 * @throws SQLException 
	 */
	public List<Requirement> findRequirementByMemid(Long memberid5) throws SQLException {
		String sql = "SELECT * FROM t_requirement WHERE memberid="+memberid5+"";
		return requirementdao.findAll(sql);
	}

	/**
	 * 更新需求信息
	 * @param requirement
	 * @return
	 * @throws SQLException 
	 */
	public int update(Requirement requirement) throws SQLException {
		return requirementdao.update(requirement);
	}

	/**
	 * 根据id将需求信息更新到新状态
	 * @param id
	 * @param newState
	 * @return
	 * @throws SQLException 
	 */
	public int updateState(Long id, String newState) throws SQLException {
		String sql = "UPDATE t_requirement SET state='"+newState+"' WHERE id="+id+"";
		return requirementdao.update(sql);
	}

	public List<Requirement> findTop10() throws SQLException {
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_requirement AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' AND t2.`state`='可预约' ORDER BY t3.`sort` ASC,t1.`searchrank` ASC,t1.`logintimes` DESC LIMIT 0,10";
		return requirementdao.findAll(sql);
	}

	/**
	 * 推荐教员信息
	 * @param r
	 * @return
	 * @throws Exception 
	 */
	public Map<Requirement, List<Teacher>> RecommendTeacher(List<Requirement> r) throws Exception {
		//Teacher 辅导科目不限，辅导地区不限
		//Requirement：学历不限，学校不限，性别要求不限
		Map<Requirement, List<Teacher>>  teachermap = new  HashMap<Requirement, List<Teacher>>();
		for(int i = 0;i<r.size();i++)
		{
			String sql = "SELECT * FROM t_teacher WHERE grade='"+r.get(i).getGrade()+"' AND salary="+r.get(i).getSalary()+" AND subject IN('"+r.get(i).getSubject()+"' ,'不限') AND servicearea IN('"+r.get(i).getArea()+"','不限') AND '"+r.get(i).getDegree()+"' IN(t_teacher.`degree`,'不限') AND '"+r.get(i).getGender()+"' IN(t_teacher.`gender`,'不限') AND '"+r.get(i).getSchool()+"' IN(t_teacher.`school`,'不限') LIMIT 0,10";
			TeacherService ts= new TeacherService();
			List<Teacher> t = ts.findteacherBySQL(sql);
			if(t != null && t.size() != 0)
				teachermap.put(r.get(i), t);
			
		}
		return teachermap;
		
	}

	/**
	 * 查询需求的条数
	 * @return
	 */
	public int getRequirementNum() {
		return requirementdao.getRequirementNum();
	}

	/**
	 * 返回从fromindex之后的PageSize条大小的记录
	 * @param fromIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Requirement> findAll(int fromIndex, int pageSize) throws SQLException {
		String sql = "SELECT t3.`sort`,t1.`searchrank`,t1.`logintimes`,t2.* FROM t_member AS t1,t_requirement AS t2,t_membertype AS t3 WHERE t1.`id`=t2.`memberid` AND t1.`type`=t3.`typename` AND t1.`blacklist`='否' AND t2.`state`='可预约' ORDER BY t3.`sort` ASC,t1.`searchrank` ASC,t1.`logintimes` DESC LIMIT "+fromIndex+","+pageSize;
		return requirementdao.findAll(sql);
	}
	/**
	 * 根据给定SQL查询需求的条数
	 * @return
	 */
	public int getTeacherNum(String sql) {
		return requirementdao.getRequirementNum(sql);
	}

	public List<Requirement> findrequirementBySQL(String sql, int fromIndex,int pageSize) throws SQLException {
		String SQL = sql + " LIMIT "+fromIndex+","+pageSize;
		return requirementdao.findAll(SQL);
	}
	
}
