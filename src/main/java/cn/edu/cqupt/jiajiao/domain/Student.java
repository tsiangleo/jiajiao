package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 学员信息
 * @author liuqiang
 *
 */
public class Student implements Serializable{
	private Long id;		//需求ID
	private Long memberid;	//账户ID，引用自t_member中的id
	private String studentname;	//学员姓名
	private String birthday;	//学员出生日期
	private String stugender;	//性别
	private String grade;		//所在年级
	private String subject;		//求教科目
	private String description;	//学员情况

	public Student(){}

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

	

}
