package cn.edu.cqupt.jiajiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.edu.cqupt.jiajiao.service.InitializeService;

/**
 * web容器初始化后，初始化数据库表
 * @author tsiang
 *
 */
public class InitializeServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		InitializeService initializeService = new InitializeService();
		initializeService.initSuperAdmin();
	}

}
