package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class QueryAndUpdateTeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryAndUpdateTeacherServlet() {
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
		  
		//queryAndUpdateTeacher.do
		//会员中心查询和更新教师信息
		//根据session中的会员id,查询教员详细信息
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		HttpSession session5 = request.getSession(false);
		Member member5 = null;
		Long memberid5 = null;
		if(session5 != null)
		{
			member5 = (Member) session5.getAttribute("member");
			memberid5 = member5.getId();
		}
		
		TeacherService ts5  = new TeacherService();
		Teacher teachinfo5 = new Teacher();
		try {
			teachinfo5 = ts5.findTeacherByMemid(memberid5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(teachinfo5 == null)
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您目前还没有信息！');parent.location.href='memberCenter.jsp';</script>");
		}
		else
		{
			request.setAttribute("teacherinfo", teachinfo5);
			RequestDispatcher rd5 = request.
			getRequestDispatcher(flag == 1 ? "queryTeacher_frame_fragment.jsp" : "updateTeacher_frame_fragment.jsp");
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
