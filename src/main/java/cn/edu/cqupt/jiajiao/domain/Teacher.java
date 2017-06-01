package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 教员详细信息
 * @author liuqiang
 *
 */
public class Teacher implements Serializable{
	private Long id;			//教员编号
	private Long memberid;		//会员编号
	private String teachername;	//教员姓名
	private String mobilephone;	//移动电话
	private String birthday;	//出生日期
	private String gender;		//性别
	private String school;		//学校
	private String degree;		//学历
	private String specialty;	//专业
	private String address;		//住址
	private String authentication;	//认证情况
	private String subject;			//教授科目
	private String grade;			//辅导年级
	private String servicearea;		//授课区域
	private String servicetype;		//辅导方式
	private String photo;			//最近照片
	private String certificate;		//所获证书
	private Integer salary;			//薪水要求
	private String description;		//自我描述
	private String notes;			//补充信息
	private int evaluation;			//评价值
	private String hascertificate; //是否已经认证
	
	public Teacher(){}

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

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getServicearea() {
		return servicearea;
	}

	public void setServicearea(String servicearea) {
		this.servicearea = servicearea;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getHascertificate() {
		return hascertificate;
	}

	public void setHascertificate(String hascertificate) {
		this.hascertificate = hascertificate;
	}

	
	
}
