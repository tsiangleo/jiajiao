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

import cn.edu.cqupt.jiajiao.domain.PageControl;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class QueryTeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryTeacherServlet() {
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
	
			
		case 1://查询教员信息（没有条件），点击菜单上的【教员库】
			
			TeacherService tsp  = new TeacherService();
			int recordCount = 0;	//一共有多少记录 
			recordCount = tsp.getTeacherNum();;
      
			//获取分页对象，传参 
            String pageStr = request.getParameter("page"); 
            int currentPage = 1; 
            if (pageStr != null) { 
                currentPage = Integer.parseInt(pageStr); 
            } 
            PageControl view = new PageControl(10, recordCount, currentPage); 
            //获取参数 
            int fromIndex = view.getFromIndex();//起始位置 
            int pageSize = view.getPageSize();//每页显示的记录数 
            
            
            List<Teacher> teachersp = null;
			try {
				teachersp = tsp.findAll(fromIndex,pageSize);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(	teachersp != null && teachersp != Collections.EMPTY_LIST)	//teacher不为空
			{
				request.setAttribute("pageControl", view);
				request.setAttribute("teachers", teachersp);
				RequestDispatcher rd = request.getRequestDispatcher("teacherList.jsp");
				rd.forward(request, response);
			}		
			break;
			
		case 2://查询教员信息（含条件），条件查询
			
			String pageStr2 = request.getParameter("page"); 
			String sql = null;
			if(pageStr2 == null)
			{
				//获取参数
				String subject3 = (String)request.getParameter("subject");
				String school3 = (String)request.getParameter("school");
				String servicearea3 = (String)request.getParameter("servicearea");
				String gender3 = (String)request.getParameter("gender");
				
				//拼接成SQL语句
				sql = "SELECT * FROM t_teacher " +
						"WHERE subject IN ('"+ subject3 +"','不限') AND servicearea IN('"+ servicearea3 +"','不限') AND school='"+ school3 +"' AND gender='"+ gender3 +"'";
				
				//对SQL语句进行处理
				if(sql.contains("WHERE subject IN ('不限','不限') AND servicearea IN('不限','不限') AND school='不限' AND gender='不限'"))
					sql = "SELECT * FROM t_teacher";
	
				if(sql.contains("AND school='不限'"))
					sql = sql.replaceAll("AND school='不限'", "");
			
				if(sql.contains("AND gender='不限'"))
					sql = sql.replaceAll("AND gender='不限'", "");
				
				//要将拼接后的SQL放到session中，负责当用户点击上一页的时候sql没了
				request.getSession(false).setAttribute("sql", sql);
			
			}
			else
			{
				sql = (String) request.getSession(false).getAttribute("sql");
			}
			
			//调用业务逻辑方法处理
			TeacherService ts3  = new TeacherService();
			

			int recordCount2 = 0;	//一共有多少记录 
			recordCount2 = ts3.getTeacherNum(sql);
      
			//获取分页对象，传参 
            pageStr2 = request.getParameter("page"); 
            int currentPage2 = 1; 
            if (pageStr2 != null) { 
                currentPage2 = Integer.parseInt(pageStr2); 
            } 
            PageControl view2 = new PageControl(10, recordCount2, currentPage2); 
            //获取参数 
            int fromIndex2 = view2.getFromIndex();//起始位置 
            int pageSize2 = view2.getPageSize();//每页显示的记录数 
   
            
			List<Teacher> teachers3 = new ArrayList<Teacher>();
			try {
				teachers3 = ts3.findteacherBySQL(sql,fromIndex2,pageSize2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(	teachers3 != Collections.EMPTY_LIST)	//teacher不为空
			{
				request.setAttribute("pageControl2", view2);
				request.setAttribute("teachers", teachers3);
				RequestDispatcher rd = request.getRequestDispatcher("teacherList.jsp");
				rd.forward(request, response);
			}
			break;
			
		case 3://后台查询待认证教师列表
			
			String sql3 = "SELECT * FROM t_teacher WHERE hascertificate='是' AND authentication!='已认证'";
			//调用业务逻辑方法处理
			TeacherService ts33  = new TeacherService();
			List<Teacher> teachers33 = new ArrayList<Teacher>();
			try {
				teachers33 = ts33.findteacherBySQL(sql3);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(	teachers33 != Collections.EMPTY_LIST)	//teacher不为空
			{
				request.setAttribute("teachers", teachers33);
				RequestDispatcher rd = request.getRequestDispatcher("teacherList.jsp");
				rd.forward(request, response);
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
