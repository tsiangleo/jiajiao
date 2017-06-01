package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.AdminLogging;
import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.service.AdminLoggingService;
import cn.edu.cqupt.jiajiao.service.AdministratorService;

public class AdminLoggingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminLoggingServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires",0);
		
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		switch(flag)
		{
		case 1://查询系统中的所有登陆日志
			
			AdminLoggingService ls  = new AdminLoggingService();
			List<AdminLogging> memberList = new ArrayList<AdminLogging>();
			memberList = ls.findAll();
			if(	memberList != null && memberList != Collections.EMPTY_LIST)
			{
				request.setAttribute("adminloggingList", memberList);
				RequestDispatcher rd = request.getRequestDispatcher("adminloggingList.jsp");
				rd.forward(request, response);
			}
			
			break;
			
		case 2://查询系统中制定用户的所有登陆日志
			
			String username = request.getParameter("username");
			AdminLoggingService ls2  = new AdminLoggingService();
			List<AdminLogging> logingList = new ArrayList<AdminLogging>();
			logingList = ls2.findAll(username);
			
			if(	logingList != null && logingList != Collections.EMPTY_LIST)
			{
				request.setAttribute("adminloggingList", logingList);
				RequestDispatcher rd = request.getRequestDispatcher("adminloggingList.jsp");
				rd.forward(request, response);
			}
			
			break;
			
		case 3://删除制定id的日志
			
			String idstr = request.getParameter("id");
			Long id = Long.parseLong(idstr);
			
			AdminLoggingService ls3 = new AdminLoggingService();
			
			int result = 0;
			result = ls3.delete(id);
			
			if(result == 1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作成功！');window.location.href='javascript:history.go(-1);self.location=document.referrer;';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
				
			}
		
			break;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
