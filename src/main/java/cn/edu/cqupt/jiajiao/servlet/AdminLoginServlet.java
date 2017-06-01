package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.AdminLogging;
import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.service.AdminLoggingService;
import cn.edu.cqupt.jiajiao.service.AdministratorService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class AdminLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminLoginServlet() {
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
		
		String loginrole = request.getParameter("role");
		String usernamelogin = request.getParameter("username");
		String passwordlogin = request.getParameter("password");

		Administrator memberlogin = new Administrator();
	
		memberlogin.setPassword(MD5Util.GetMD5Code(passwordlogin));
		memberlogin.setUsername(usernamelogin);
		memberlogin.setRole(loginrole);
		
		
		//将登陆信息封装到AdminLogging
		AdminLogging alog = new AdminLogging();
		alog.setUsername(usernamelogin);
		//获取登陆ip
		String ip = request.getRemoteAddr();
		alog.setLoginip(ip);
		//获取登陆时间
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String loginDate = sdf3.format(new java.util.Date());
		alog.setLogintime(loginDate);
		
		
		
		AdministratorService mslogin = new AdministratorService();
		try {
			if (mslogin.login(memberlogin) == 1) {	// 登录成功
				alog.setResult("登陆成功");
				
				
				
				
				HttpSession session = request.getSession(false);
				if(session != null )
				{	
					Administrator ad = null;
					ad = mslogin.query(usernamelogin);
					
					session.setAttribute("administrator", ad);
				}
				else// session == null
				{
					HttpSession newsession = request.getSession(true);
					newsession.setAttribute("administrator", memberlogin);
				}
								
				//转到首页，而非会员中心
				response.sendRedirect("index.jsp");

			} else if(mslogin.login(memberlogin) == 0){
				alog.setResult("账号被锁定");
				
				request.setAttribute("loginMsg", "对不起，您的账号已被锁定！");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else if(mslogin.login(memberlogin) == -1){
				alog.setResult("用户名或密码错误");
				
				request.setAttribute("loginMsg", "用户名或密码错误！");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//保存登陆日志
			AdminLoggingService ass = new AdminLoggingService();
			try {
				ass.save(alog);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
