package cn.edu.cqupt.jiajiao.service;

import java.sql.SQLException;

import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class InitializeService {
	
	/**
	 * 初始化超级管理员
	 */
	public void initSuperAdmin(){
		try {
			AdministratorService as = new AdministratorService();
			if (as.hasAdministrator("admin")){
				return;
			}
				
			Administrator admin = new Administrator();
			admin.setUsername("admin");
			admin.setPassword(MD5Util.GetMD5Code("admin"));
			admin.setPhone("18888888888");
			admin.setGender("男");
			admin.setRealname("马化腾");
			admin.setRole("超级管理员");
			admin.setBlacklist("否");
			as.save(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("超级管理员初始化");
	}
}
