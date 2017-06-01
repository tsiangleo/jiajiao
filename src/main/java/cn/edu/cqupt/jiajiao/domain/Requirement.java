package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员需求信息
 * @author liuqiang
 *
 */
public class Requirement implements Serializable{
	private Long id;		//需求ID
	private Long memberid;	//账户ID，引用自t_member中的id
	private String studentname;	//学员姓名
	private String birthday;	//学员出生日期
	private String stugender;	//性别
	private String grade;		//所在年级
	private String subject;		//求教科目
	private String description;	//学员情况
	private String contacts;	//联系人
	private String phone;		//联系电话
	private String area;		//授课区域
	private Integer salary;		//报酬
	private String degree ;		//学历要求
	private String gender;		//性别要求
	private String school;		//学校要求
	private String classtime;	//授课时间
	private String issuetime;	//发布时间
	private String state;		//状态
	
	public Requirement(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStugender() {
		return stugender;
	}

	public void setStugender(String stugender) {
		this.stugender = stugender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClasstime() {
		return classtime;
	}

	public void setClasstime(String classtime) {
		this.classtime = classtime;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

}
