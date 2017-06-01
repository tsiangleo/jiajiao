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

public class AddStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStudentServlet() {
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
		  
		//添加学员信息
		String studentname = request.getParameter("studentname");
		String stugender = request.getParameter("stugender");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
			
		String yearstr = request.getParameter("year");
		String monthstr = request.getParameter("month");
		String daystr = request.getParameter("day");

		Integer year = Integer.parseInt(yearstr);
		Integer month = Integer.parseInt(monthstr);
		Integer day = Integer.parseInt(daystr);
		
		String birthday = year + "-" + ((month > 9)? month:"0" + month) + "-" + ((day > 9)? day:"0" + day);
		
		//封装成Requirement对象
		Student student = new Student();

		student.setDescription(description);		
		student.setGrade(grade);		
		student.setStudentname(studentname);
		student.setStugender(stugender);
		student.setSubject(subject);
		student.setBirthday(birthday);
        
		//获得对应的账户ID
		HttpSession session = request.getSession(false);
		Member member = null;
		String username = null;
		if(session != null)
		{
			member = (Member)session.getAttribute("member");
			username = member.getUsername();
		}
		
		MemberService mb = new MemberService();
		Long id = null;
		try {
			id = mb.getID(username);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		student.setMemberid(id);
		
		StudentService ss  = new StudentService();
		
		int result = 0;
		try {
			result = ss.save(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1)	//保存成功
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('学员信息添加成功！');this.location.href='queryStudentList.do';</script>");			
		
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('学员信息添加失败！稍后再试！');parent.location.href='memberCenter.jsp';</script>");
		
			
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
