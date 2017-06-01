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

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.MemberType;
import cn.edu.cqupt.jiajiao.service.LinkService;
import cn.edu.cqupt.jiajiao.service.MemberTypeService;

public class QueryMemberTypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryMemberTypeServlet() {
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
		  
		String flagstr = (String)request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		MemberTypeService ls  = new MemberTypeService();
		List<MemberType> membertypeList = new ArrayList<MemberType>();
		try {
			membertypeList = ls.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(	membertypeList != Collections.EMPTY_LIST)	//MemberType不为空
		{
			
			switch(flag)
			{
			case 1:
				request.setAttribute("membertypeList", membertypeList);
				request.getRequestDispatcher("memberTypeList.jsp").forward(request, response);
				break;
			case 2:
				
				String idstr = (String)request.getParameter("id");
				Long id = Long.parseLong(idstr);
				request.setAttribute("membertypeList", membertypeList);
				request.setAttribute("id", id);
				request.getRequestDispatcher("changetype.jsp").forward(request, response);
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
