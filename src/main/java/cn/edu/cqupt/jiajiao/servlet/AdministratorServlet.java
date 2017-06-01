package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.AdminLogging;
import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.MemberType;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.AdminLoggingService;
import cn.edu.cqupt.jiajiao.service.AdministratorService;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.MemberTypeService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.TeacherService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class AdministratorServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdministratorServlet() {
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
		case 1://添加管理员
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String realname = request.getParameter("realname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String role = request.getParameter("role");

			// 2、将请求参数封装到领域对象Administrator
			Administrator admin = new Administrator();
			admin.setUsername(username);
			admin.setPassword(MD5Util.GetMD5Code(password));
			admin.setPhone(phone);
			admin.setGender(gender);
			admin.setRealname(realname);
			admin.setRole(role);

			// 3、调用Service组件处理
			AdministratorService as = new AdministratorService();

			try {
				if (as.hasAdministrator(admin.getUsername()) == false) {
					int result = 0;
					try {
						result = as.save(admin);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 4、根据处理结果转发到对应视图
					if (result == 1) // 保存成功
					{
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter();
						out.println("<script>alert('添加成功！');window.location.href='administrator.do?flag=4';</script>");
					

					} else {
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter();
						out.println("<script>alert('添加失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
					

					}
				} else // 用户名已存在
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('用户名已存在！');parent.location.href='javascript:history.go(-1);';</script>");			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			break;
			
		case 2://管理员登陆
			
			
			break;
		case 3://管理员注销

			HttpSession session = request.getSession(false);
			if(session != null)
			{
				session.invalidate();

				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您已成功退出！');top.location.href='login.jsp';</script>");
		
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您已经退出了！不要重复退出！');top.location.href='login.jsp';</script>");
			}
			break;
		case 4:	//查询管理员列表
			
			AdministratorService ls  = new AdministratorService();
			List<Administrator> memberList = new ArrayList<Administrator>();
			try {
				memberList = ls.findAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(	memberList != Collections.EMPTY_LIST)	//MemberType不为空
			{
				request.setAttribute("administratorList", memberList);
				RequestDispatcher rd = request.getRequestDispatcher("administratorList.jsp");
				rd.forward(request, response);
			}
			
			break;
		case 5://修改黑名单
		case 6:
			
			//获取id和会员类型
			String idstr7 = (String)request.getParameter("id");
			Long id7 = Long.parseLong(idstr7);
			
			String state = null;
			if(flag == 5 )
				state="是";
			else
				state="否";
			
			AdministratorService ms78 = new AdministratorService();
			int result7 = 0;
			try {
				result7 = ms78.updateBlackList(id7, state);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result7 ==1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作成功！');window.location.href='javascript:history.go(-1);self.location=document.referrer;';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
				
			}
			
			break;
		case 7:	//重置密码为123456
			
			//获取id和会员类型
			String idstr9 = (String)request.getParameter("id");
			Long id9 = Long.parseLong(idstr9);
			
			AdministratorService ms9 = new AdministratorService();
			int result9 = 0;
			try {
				result9 = ms9.updatePassword(id9, MD5Util.GetMD5Code("123456"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result9 ==1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作成功！');window.location.href='javascript:history.go(-1);self.location=document.referrer;';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
				
			}
			break;
			
		case 8://查询制定用户名的管理员
			String adminame = request.getParameter("username");
			
			AdministratorService ls8  = new AdministratorService();		
			Administrator ad = null;
			try {
				ad = ls8.query(adminame);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(	ad != null && ad != Collections.EMPTY_LIST)
			{
				List<Administrator> adList = new ArrayList<Administrator>();
				adList.add(ad);
				request.setAttribute("administratorList", adList);
				RequestDispatcher rd = request.getRequestDispatcher("administratorList.jsp");
				rd.forward(request, response);
			}
				
			break;
		case 9://删除指定id的管理员
			
			String idstr = request.getParameter("id");
			Long id = Long.parseLong(idstr);
			
			AdministratorService ls3 = new AdministratorService();
			
			int result = 0;
			result = ls3.delete(id);
			
			if(result == 1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作成功！');window.location.href='javascript:history.go(-1);self.location=document.referrer;';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');window.location.href='javascript:history.go(-1);';</script>");
				
			}
			
			break;
			
		case 10://修改密码
			
			HttpSession session6 = request.getSession(false);
			Administrator member3 = null;
			Long memberid6 = null;
			String username6 = null;
			
			if(session6 != null)
			{
				member3 = (Administrator)session6.getAttribute("administrator");	
				memberid6 = member3.getId();
				username6 = member3.getUsername();
			}
			
			String oldpassword = (String)request.getParameter("oldpassword");
			String newpassword = (String)request.getParameter("newpassword");
			
			AdministratorService ms6 = new AdministratorService();
			Administrator mb6 = null;
			try {
				mb6 = ms6.query(username6);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(mb6.getPassword().equals(MD5Util.GetMD5Code(oldpassword)))//用户输入的原始密码正确
			{
			
				int result6 = 0;
				
				try {
					result6 = ms6.updatePassword(memberid6,MD5Util.GetMD5Code(newpassword));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(result6 == 1)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('密码修改成功！');parent.location.href='index.jsp';</script>");
					
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('密码修改失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
					
				}
				break;
			}
			else//用户输入的原始密码不对
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('原密码错误！');parent.location.href='javascript:history.go(-1);';</script>");
				
			}
			
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
