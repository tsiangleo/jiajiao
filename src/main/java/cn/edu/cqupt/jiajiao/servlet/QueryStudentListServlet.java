package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.service.StudentService;

public class QueryStudentListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryStudentListServlet() {
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
		  
		//updateMember.do
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);

		switch (flag) {
		case 1:
			
			//根据session中的会员id,查询学员详细信息
			HttpSession session2 = request.getSession(false);
			Member member2 = null;
			Long memberid2 = null;
			if(session2 != null)
			{
				member2 = (Member) session2.getAttribute("member");
				memberid2 = member2.getId();
			}
			
			StudentService ss2  = new StudentService();
			ArrayList<Student> studentList = new ArrayList<Student>();
			try {
				studentList = (ArrayList<Student>) ss2.findStudentByMemid(memberid2);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			if(studentList == Collections.EMPTY_LIST)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您目前还没有添加学员信息！');parent.location.href='memberCenter.jsp';</script>");
				
			}
			else
			{
				request.setAttribute("studentList", studentList);
				RequestDispatcher rd2 = request.getRequestDispatcher("queryStudentList_frame_fragment.jsp");
				rd2.forward(request, response);
				
			}
			break;
		case 2:
			//根据session中的会员id,查询学员详细信息
			HttpSession session22 = request.getSession(false);
			Member member22 = null;
			Long memberid22 = null;
			if(session22 != null)
			{
				member22 = (Member) session22.getAttribute("member");
				memberid22 = member22.getId();
			}
			
			StudentService ss  = new StudentService();
			ArrayList<Student> studentList2 = new ArrayList<Student>();
			try {
				studentList2 = (ArrayList<Student>) ss.findStudentByMemid(memberid22);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			request.setAttribute("studentList", studentList2);
			RequestDispatcher rd2 = request.getRequestDispatcher("addRequirement_frame_fragment.jsp");
			rd2.forward(request, response);
			
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
