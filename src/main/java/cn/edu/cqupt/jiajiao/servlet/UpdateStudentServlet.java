package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.StudentService;

public class UpdateStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateStudentServlet() {
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
		  
		String idstr6 = request.getParameter("id");
		Long stuid6 = Long.parseLong(idstr6);
		
		
		String studentname6 = request.getParameter("studentname");
		String stugender6 = request.getParameter("stugender");
		String grade6 = request.getParameter("grade");
		String subject6 = request.getParameter("subject");
		String description6 = request.getParameter("description");
	
		
		String yearstr6 = request.getParameter("year");
		String monthstr6 = request.getParameter("month");
		String daystr6 = request.getParameter("day");
		Integer year6 = Integer.parseInt(yearstr6);
		Integer month6 = Integer.parseInt(monthstr6);
		Integer day6 = Integer.parseInt(daystr6);
		String birthday6 = year6 + "-" + ((month6 > 9)? month6:"0" + month6) + "-" + ((day6 > 9)? day6:"0" + day6);
		
		Student student6 = new Student();
		

		student6.setBirthday(birthday6);
		student6.setDescription(description6);
		student6.setGrade(grade6);
		student6.setId(stuid6);
		student6.setStudentname(studentname6);
		student6.setStugender(stugender6);
		student6.setSubject(subject6);
        
		//获得对应的账户ID
		HttpSession session6 = request.getSession(false);
		Member member = null;	
		String username6 = null;
		if(session6 != null)
		{
			member = (Member)session6.getAttribute("member");	
			username6 = member.getUsername();
		}
		MemberService mb6 = new MemberService();
		Long id6 = null;
		try {
			id6 = mb6.getID(username6);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		student6.setMemberid(id6);
		
		StudentService ss6  = new StudentService();
		
		int result6 = 0;
		try {
			result6 = ss6.update(student6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result6 == 1)	//保存成功
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			out.print("<script type='text/javascript'>alert('学员信息更新成功！');this.location.href='queryStudentList.do';</script>");			
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('学员信息更新失败！稍后再试！');parent.location.href='memberCenter.jsp';</script>");
		
			
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
