package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员类
 * @author liuqiang
 *
 */
public class Member implements Serializable{
	
	private Long id;			//会员编号
	private String username;	//用户名
	private String password;	//密码
	private String email;		//邮箱
	private Integer balance;	//账户余额
	private String phone;		//联系电话
	private String role;		//角色，区分学员和教员
	private String registdate;	//注册日期
	private String lasttime;	//上次登录时间
	private String lastip;		//上次登录ip
	private String logintime;	//本次登录时间
	private String loginip;		//本次登录ip
	private String type;			//会员类型
	private Integer searchrank;		//会员搜索排序设置
	private String VIPdeadline;		//VIP到期时间
	private Integer logintimes;		//登陆次数
	private String registip;		//注册IP
	private String blacklist;		//是否为黑名单
	
	public Member(){}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegistdate() {
		return registdate;
	}

	public void setRegistdate(String registdate) {
		this.registdate = registdate;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSearchrank() {
		return searchrank;
	}

	public void setSearchrank(Integer searchrank) {
		this.searchrank = searchrank;
	}

	public String getVIPdeadline() {
		return VIPdeadline;
	}

	public void setVIPdeadline(String vIPdeadline) {
		VIPdeadline = vIPdeadline;
	}

	public Integer getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(Integer logintimes) {
		this.logintimes = logintimes;
	}

	public String getRegistip() {
		return registip;
	}

	public void setRegistip(String registip) {
		this.registip = registip;
	}

	public String getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	

	
}
