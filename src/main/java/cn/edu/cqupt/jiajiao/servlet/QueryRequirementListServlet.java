package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.service.RequirementService;

public class QueryRequirementListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryRequirementListServlet() {
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
		  
		HttpSession session5 = request.getSession(false);	
		Member member5 = null;
		Long memberid5 = null;
		if(session5 != null)
		{
			member5 = (Member) session5.getAttribute("member");
			memberid5 = member5.getId();
		}
		
		RequirementService rs5  = new RequirementService();
		ArrayList<Requirement> requirementinfo5 = new ArrayList<Requirement>();
		
		try {
			requirementinfo5 = (ArrayList<Requirement>) rs5.findRequirementByMemid(memberid5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(requirementinfo5 == null)
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您目前还没有信息！');parent.location.href='memberCenter.jsp';</script>");
		}
		else
		{
			request.setAttribute("requirementinfo", requirementinfo5);
			RequestDispatcher rd5 = request.getRequestDispatcher("queryRequirementList_frame_fragment.jsp");
			rd5.forward(request, response);

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
