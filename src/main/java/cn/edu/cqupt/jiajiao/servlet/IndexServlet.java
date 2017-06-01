package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.Notice;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Sysinfo;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.LinkService;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.NewsService;
import cn.edu.cqupt.jiajiao.service.NoticeService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.SysinfoService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class IndexServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
	z * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		 response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader("Expires",0);
		  
		 
		//获取教员信息放到request中
		TeacherService ts  = new TeacherService();
		List<Teacher> teachers = null;
		try {
			teachers = ts.findTop10();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(	teachers != null && !teachers.isEmpty())	//teacher不为空
		{
			request.setAttribute("teachers", teachers);
		}

		List<Teacher> vipTeacherList = new ArrayList<Teacher>();
		TeacherService ts2 = new TeacherService();
		try {
			vipTeacherList = ts2.findVIPTOP6();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(vipTeacherList != null && !vipTeacherList.isEmpty()){
			request.getSession().setAttribute("VIPteachers", vipTeacherList);
		}
		
		
		//获取需求信息放到request中
		RequirementService rs = new RequirementService();
		List<Requirement> requirements = null;		
		try {
			requirements = rs.findTop10();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(requirements != null &&	!requirements.isEmpty())	//requirement不为空
		{
			request.setAttribute("requirements", requirements);
		}
		

		//获取新闻放到request中
		HashMap<String,List<News>> newsmap = new HashMap<String,List<News>>();		
		NewsService ns2 = new NewsService();
		List<String> typenameList = ns2.queryNewsType();
		
		//获取3组新闻
		for(String typename: typenameList)
		{
			//再获取该类别下的所有新闻
			List<News> news = null;
			try {
				news = ns2.findByType(typename);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//加入hashmap中
			newsmap.put(typename, news);
		}		
		request.setAttribute("newsmap", newsmap);		
		
		
		//转发视图
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
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
