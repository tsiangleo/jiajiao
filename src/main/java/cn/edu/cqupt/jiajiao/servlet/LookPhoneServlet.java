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
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class LookPhoneServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LookPhoneServlet() {
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
		  
		if(request.getParameter("flag").equals("t"))//查看教师电话
		{
			HttpSession session = request.getSession(false);
			Member member = null;
			if(session != null)
				member = (Member)session.getAttribute("member");
			
			MemberService ms = new MemberService();
			Member newmember = null;
			try {
				newmember = ms.query(member.getUsername());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String mptstr = (String)request.getParameter("mpt");
			Integer mpt = Integer.parseInt(mptstr);
			
			//教师id
			String tidstr = (String)request.getParameter("tid");
			Long tid = Long.parseLong(tidstr);
			
			if((newmember.getBalance() - mpt) < 0)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('账户余额不足，无法查看！');parent.location.href='javascript:history.go(-1);';</script>");
				return;
			}
				
			int result = 0;
			try {
				result = ms.updateBalance(member.getId(),0 - mpt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result ==1)
			{
				//更新session
				Member m = newmember;
				m.setBalance(newmember.getBalance() - mpt);
				session.setAttribute("member", m);
				
				//会员id@教员id
				String key = member.getId()+"@"+tid;
				session.setAttribute(key, "true");
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>self.location=document.referrer;</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('无法查看！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
			}
			
		}
		else if(request.getParameter("flag").equals("r"))//查看家长电话
		{
			HttpSession session = request.getSession(false);
			Member member = null;
			if(session != null)
				member = (Member)session.getAttribute("member");
			
			String mptstr = (String)request.getParameter("mpt");
			Integer mpt = Integer.parseInt(mptstr);
			
			String ridstr = (String)request.getParameter("rid");
			Long rid = Long.parseLong(ridstr);
			
			System.out.println((member.getBalance() - mpt)+"");
			if((member.getBalance() - mpt) < 0)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('账户余额不足，无法查看！');parent.location.href='javascript:history.go(-1);';</script>");
				return;
			}
			
			MemberService ms = new MemberService();	
			int result = 0;
			try {
				result = ms.updateBalance(member.getId(),0 - mpt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result ==1)
			{
				//会员id@教员id
				String key = member.getId()+"@"+rid;
				session.setAttribute(key, "true");
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>self.location=document.referrer;</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('无法查看！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
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
