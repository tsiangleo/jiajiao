package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.service.RequirementService;

public class QueryRequirementDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryRequirementDetailServlet() {
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
		  
		//根据需求id,查询需求详细信息

		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		String requirementidstr = (String)request.getParameter("id");
		Integer requirementid = Integer.parseInt(requirementidstr);
		
		RequirementService rs4  = new RequirementService();
		Requirement requirementinfo = new Requirement();
		try {
			requirementinfo = rs4.findRequirement(requirementid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("requirementinfo", requirementinfo);
		

		if(flag == 1)
		{
			RequestDispatcher rd = request.getRequestDispatcher("requirementDetail.jsp");
			rd.forward(request, response);
		}
		else if(flag == 2)
		{
			//获取标志，以便转发到不同的视图
			String queryandupdatestr = (String)request.getParameter("queryandupdate");
			Integer queryandupdate = Integer.parseInt(queryandupdatestr);
			
			RequestDispatcher rd = request.getRequestDispatcher(queryandupdate == 0 ? "queryRequirement_frame_fragment.jsp" : "updateRequirement_frame_fragment.jsp");
			rd.forward(request, response);
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
