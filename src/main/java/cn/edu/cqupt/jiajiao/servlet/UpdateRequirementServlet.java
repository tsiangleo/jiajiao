package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.RequirementService;

public class UpdateRequirementServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateRequirementServlet() {
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
		case 1://根据需求id更新需求信息
			
			String idstr7 = request.getParameter("id");
			Long id7 = Long.parseLong(idstr7);
			
			String studentname7 = request.getParameter("studentname");
			String stugender7 = request.getParameter("stugender");
			String grade7 = request.getParameter("grade");
			String subject7 = request.getParameter("subject");
			String description7 = request.getParameter("description");
			String contacts7 = request.getParameter("contacts");
			String phone7 = request.getParameter("phone");
			String area7 = request.getParameter("area");
			String gender7 = request.getParameter("gender");
			String school7 = request.getParameter("school");
			String degree7 = request.getParameter("degree");
			String classtime7 = request.getParameter("classtime");		
			String state7 = request.getParameter("state");
			
			String yearstr7 = request.getParameter("year");
			String monthstr7 = request.getParameter("month");
			String daystr7 = request.getParameter("day");
	
			Integer year7 = Integer.parseInt(yearstr7);
			Integer month7 = Integer.parseInt(monthstr7);
			Integer day7 = Integer.parseInt(daystr7);
			
			String salarystr7 = request.getParameter("salary");
			Integer salary7 = Integer.parseInt(salarystr7);
	
			//封装成Requirement对象
			Requirement requirement7 = new Requirement();
			
			requirement7.setArea(area7);		
			requirement7.setClasstime(classtime7);
			requirement7.setContacts(contacts7);
			requirement7.setDegree(degree7);
			requirement7.setDescription(description7);
			requirement7.setGender(gender7);
			requirement7.setGrade(grade7);		
			requirement7.setPhone(phone7);
			requirement7.setSalary(salary7);
			requirement7.setSchool(school7);
			requirement7.setState(state7);
			requirement7.setStudentname(studentname7);
			requirement7.setStugender(stugender7);
			requirement7.setSubject(subject7);
			requirement7.setId(id7);
			
			String birthday7 = year7 + "-" + ((month7 > 9)? month7:"0" + month7) + "-" + ((day7 > 9)? day7:"0" + day7);
			
			requirement7.setBirthday(birthday7);

			// 将Date转换成指定形式的时间字符串  
	        SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        String Issuetime7 = sdf7.format(new java.util.Date());
	        requirement7.setIssuetime(Issuetime7);
	        
			//获得对应的账户ID
			HttpSession session7 = request.getSession(false);
			Member member = null;
			String username7 = null;
			if(session7 != null)
			{
				member = (Member)session7.getAttribute("member");
				username7 = member.getUsername();
			}
			
			MemberService mb7 = new MemberService();
			Long mid7 = null;
			try {
				mid7 = mb7.getID(username7);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			requirement7.setMemberid(mid7);
			
			RequirementService rs7  = new RequirementService();
			
			int result7 = 0;
			try {
				result7 = rs7.update(requirement7);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result7 == 1)	//保存成功
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('需求信息更新成功！');parent.location.href='memberCenter.jsp';</script>");
				break;
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('需求信息更新失败！稍后再试！');parent.location.href='memberCenter.jsp';</script>");
				break;
				
			}
			
		case 2://修改状态
			
			String idstr9 = request.getParameter("id");
			Long id9 = Long.parseLong(idstr9);
			
			//一些标志信息
			String msgstr = request.getParameter("msg");
			Integer msg = Integer.parseInt(msgstr);
			
			RequirementService rs9  = new RequirementService();
			int result9 = 0;
			try {
				result9 = rs9.updateState(id9,msg == 0 ? "已预约" : "可预约");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result9 == 1)	//更新成功
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('标记成功！');parent.location.href='memberCenter.jsp';</script>");
				break;
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('标记失败！稍后再试！');parent.location.href='memberCenter.jsp';</script>");
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
