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

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.MemberType;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.MemberTypeService;

public class QueryMemberServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryMemberServlet() {
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
		  
		//处理后台条件条件查询会员
		
		String flagstr = (String)request.getParameter("flag");
		Integer  flag = Integer.parseInt(flagstr);
		//获取参数
		String idstr = (String)request.getParameter("id");
		Long id = 0L;	//用户没输入id时，让id为0
		if(idstr != null && !idstr.equals("")) 
			id = Long.parseLong(idstr);
		
		String username = (String)request.getParameter("username");
		if(username == null || username.equals("")) 	
			username = "NO";
		
		String role = (String)request.getParameter("role");	
		
		//拼接成SQL语句
		String sql = "SELECT * FROM t_member WHERE id="+ id +",username='"+ username +"',role='"+ role +"'";
		//对SQL语句进行处理
		if(sql.contains("WHERE id=0,username='NO',role='不限'"))
			sql = "SELECT * FROM t_member";
		if(sql.contains("id=0,"))
			sql = sql.replaceAll("id=0,", "");			
		if(sql.contains("username='NO',"))
			sql = sql.replaceAll("username='NO',", "");
		if(sql.contains("role='不限'"))
			sql = sql.replaceAll("role='不限'", "");
		if(sql.endsWith(","))	//若结尾还有逗号，将逗号去掉
			sql = sql.substring(0, sql.length()-1);

		MemberService ls  = new MemberService();
		List<Member> memberList = new ArrayList<Member>();
		try {
			memberList = ls.findMemberBySQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(	memberList != Collections.EMPTY_LIST)	//MemberType不为空
		{
			request.setAttribute("memberList", memberList);
			
			switch(flag)
			{
			case 1:
				request.getRequestDispatcher("memberList.jsp").forward(request, response);
				break;
			case 2:
				request.getRequestDispatcher("vipservice.jsp").forward(request, response);
				break;
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
