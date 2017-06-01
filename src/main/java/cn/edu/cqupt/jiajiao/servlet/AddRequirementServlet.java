package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.StudentService;

public class AddRequirementServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddRequirementServlet() {
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
		if(flag == 1)
		{
			String studentname = request.getParameter("studentname");
			String stugender = request.getParameter("stugender");
			String grade = request.getParameter("grade");
			String subject = request.getParameter("subject");
			String description = request.getParameter("description");
			String contacts = request.getParameter("contacts");
			String phone = request.getParameter("phone");
			String area = request.getParameter("area");
			String gender = request.getParameter("gender");
			String school = request.getParameter("school");
			String degree = request.getParameter("degree");
			String classtime = request.getParameter("classtime");
		
			String yearstr = request.getParameter("year");
			String monthstr = request.getParameter("month");
			String daystr = request.getParameter("day");

			Integer year = Integer.parseInt(yearstr);
			Integer month = Integer.parseInt(monthstr);
			Integer day = Integer.parseInt(daystr);
			
			String salarystr = request.getParameter("salary");
			Integer salary = Integer.parseInt(salarystr);

			//封装成Requirement对象
			Requirement requirement = new Requirement();
			
			requirement.setArea(area);		
			requirement.setClasstime(classtime);
			requirement.setContacts(contacts);
			requirement.setDegree(degree);
			requirement.setDescription(description);
			requirement.setGender(gender);
			requirement.setGrade(grade);		
			requirement.setPhone(phone);
			requirement.setSalary(salary);
			requirement.setSchool(school);
			requirement.setState("可预约");
			requirement.setStudentname(studentname);
			requirement.setStugender(stugender);
			requirement.setSubject(subject);

			String birthday = year + "-" + ((month > 9)? month:"0" + month) + "-" + ((day > 9)? day:"0" + day);
			
			requirement.setBirthday(birthday);

			// 将Date转换成指定形式的时间字符串  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        String Issuetime = sdf.format(new java.util.Date());
	        requirement.setIssuetime(Issuetime);
	        
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
			requirement.setMemberid(id);
			
			RequirementService rs  = new RequirementService();
			
			int result = 0;
			try {
				result = rs.save(requirement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == 1)	//保存成功
			{
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('需求信息发布失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
				
			}
			
	
		}
		else if(flag == 2)
		{
			String choosestustr = request.getParameter("choosestu");
			if(choosestustr.equals("请选择"))
			{
				String studentname = request.getParameter("studentname");
				String stugender = request.getParameter("stugender");
				String grade = request.getParameter("grade");
				String subject = request.getParameter("subject");
				String description = request.getParameter("description");
				String contacts = request.getParameter("contacts");
				String phone = request.getParameter("phone");
				String area = request.getParameter("area");
				String gender = request.getParameter("gender");
				String school = request.getParameter("school");
				String degree = request.getParameter("degree");
				String classtime = request.getParameter("classtime");
			
				String yearstr = request.getParameter("year");
				String monthstr = request.getParameter("month");
				String daystr = request.getParameter("day");

				Integer year = Integer.parseInt(yearstr);
				Integer month = Integer.parseInt(monthstr);
				Integer day = Integer.parseInt(daystr);
				
				String salarystr = request.getParameter("salary");
				Integer salary = Integer.parseInt(salarystr);

				//封装成Requirement对象
				Requirement requirement = new Requirement();
				
				requirement.setArea(area);		
				requirement.setClasstime(classtime);
				requirement.setContacts(contacts);
				requirement.setDegree(degree);
				requirement.setDescription(description);
				requirement.setGender(gender);
				requirement.setGrade(grade);		
				requirement.setPhone(phone);
				requirement.setSalary(salary);
				requirement.setSchool(school);
				requirement.setState("可预约");
				requirement.setStudentname(studentname);
				requirement.setStugender(stugender);
				requirement.setSubject(subject);

				String birthday = year + "-" + ((month > 9)? month:"0" + month) + "-" + ((day > 9)? day:"0" + day);
				
				requirement.setBirthday(birthday);

				// 将Date转换成指定形式的时间字符串  
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		        String Issuetime = sdf.format(new java.util.Date());
		        requirement.setIssuetime(Issuetime);
		        
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
				requirement.setMemberid(id);
				
				RequirementService rs  = new RequirementService();
				
				int result = 0;
				try {
					result = rs.save(requirement);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == 1)	//保存成功
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out=response.getWriter();
					out.print("<script type='text/javascript'>alert('需求信息发布成功！');window.location.href='queryRequirementList.do';</script>");
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out=response.getWriter();
					out.print("<script type='text/javascript'>alert('需求信息发布失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
					
				}
			}
			else
			{
				
				String contacts = request.getParameter("contacts");
				String phone = request.getParameter("phone");
				String area = request.getParameter("area");
				String gender = request.getParameter("gender");
				String school = request.getParameter("school");
				String degree = request.getParameter("degree");
				String classtime = request.getParameter("classtime");
				String salarystr = request.getParameter("salary");
				Integer salary = Integer.parseInt(salarystr);

				//封装成Requirement对象
				Requirement requirement = new Requirement();
				
				requirement.setArea(area);		
				requirement.setClasstime(classtime);
				requirement.setContacts(contacts);
				requirement.setDegree(degree);
				requirement.setPhone(phone);
				requirement.setSalary(salary);
				requirement.setSchool(school);
				requirement.setGender(gender);
				requirement.setState("可预约");
				
				//获得学生的ID
				Integer choosestu = Integer.parseInt(choosestustr);
				StudentService stus = new StudentService();
				Student s = null;
				try {
					s = stus.findStudent(choosestu);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(s != null)
				{
					requirement.setDescription(s.getDescription());
					requirement.setGrade(s.getGrade());		
					requirement.setStudentname(s.getStudentname());
					requirement.setStugender(s.getStugender());
					requirement.setSubject(s.getSubject());	
					requirement.setBirthday(s.getBirthday());	
				}
				
				
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
				requirement.setMemberid(id);
				
				RequirementService rs  = new RequirementService();
				
				int result = 0;
				try {
					result = rs.save(requirement);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == 1)	//保存成功
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out=response.getWriter();
					out.print("<script type='text/javascript'>alert('需求信息发布成功！');window.location.href='queryRequirementList.do';</script>");
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out=response.getWriter();
					out.print("<script type='text/javascript'>alert('需求信息发布失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
					
				}
				
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
