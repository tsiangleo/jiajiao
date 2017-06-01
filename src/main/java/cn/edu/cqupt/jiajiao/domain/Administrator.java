package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员
 * @author liuqiang
 *
 */
public class Administrator implements Serializable{
	
	private Long id;			//管理员编号
	private String username;	//用户名
	private String password;	//密码
	private String role;		//角色
	private String realname;	//真实姓名
	private String phone;		//联系电话
	private String gender;		//性别
	private Integer logintimes;	//登陆次数
	private String blacklist;	//是否为黑名单
	
	public Administrator(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(Integer logintimes) {
		this.logintimes = logintimes;
	}

	public String getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", realname="
				+ realname + ", phone=" + phone + ", gender=" + gender
				+ ", logintimes=" + logintimes + ", blacklist=" + blacklist
				+ "]";
	}

	
	
}
