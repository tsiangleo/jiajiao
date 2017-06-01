package cn.edu.cqupt.jiajiao.domain;

import java.io.Serializable;

/**
 * 管理员登陆日志
 */
public class AdminLogging implements Serializable{
	private Long id;			//日志id
	private String username;	//管理员用户名
	private String logintime;	//登陆时间
	private String loginip;		//登陆IP
	private String result;		//结果
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
