package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.TeacherService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		  
		//从login.jsp页面获取用户输入的验证码
	     String code = request.getParameter("code");
	    //从seesion中获取系统生成的验证码
	     HttpSession sesion = request.getSession(false);

	     String chars  = null;
	     if(sesion != null)
	    	 chars = (String)sesion.getAttribute("character");
//	     if(!code.equalsIgnoreCase(chars))
//	     {
//	    	response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out=response.getWriter();
//			out.print("<script type='text/javascript'>alert('验证码错误！');self.location=document.referrer;</script>");
//			return;
//	     }
//	     
		// 会员登录
		String loginrole = request.getParameter("role");
		String usernamelogin = request.getParameter("username");
		String passwordlogin = request.getParameter("password");

		Member memberlogin = new Member();
		memberlogin.setPassword(MD5Util.GetMD5Code(passwordlogin));
		memberlogin.setUsername(usernamelogin);
		
		if (loginrole.equals("teacher"))
			memberlogin.setRole("教员");
		else
			memberlogin.setRole("学员");

		MemberService mslogin = new MemberService();
		try {
			if (mslogin.login(memberlogin) == 1) {	// 登录成功
				//获取登陆ip
				String ip = request.getRemoteAddr();
				memberlogin.setLoginip(ip);
				//获取登陆时间
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String loginDate = sdf3.format(new java.util.Date());
				memberlogin.setLogintime(loginDate);
				//更新登陆信息
				mslogin.updateLogin(memberlogin);
				
				//将最新的Member信息放到session中
				Member updatedmember = mslogin.query(memberlogin.getUsername());
				HttpSession session = request.getSession(false);
				if(session != null )
				{	if(session.getAttribute("photo") == null)
						session.setAttribute("photo", "upLoadFile/default.jpg");
					session.setAttribute("member", updatedmember);
				}
				else// session == null
				{
					HttpSession newsession = request.getSession(true);
					newsession.setAttribute("member", updatedmember);
				}
				

				//若是教员登陆，将教员的photo放到session中，同时将推荐的需求信息放到session中
				if(memberlogin.getRole().equals("教员"))	
				{
					//将教员的photo放到session中
					TeacherService ts = new TeacherService();
					Teacher t= ts.findTeacherByMemid(updatedmember.getId());
					HttpSession sessiont = request.getSession(false);
					if(t == null)
						sessiont.setAttribute("photo", "upLoadFile/default.jpg");
					else
						sessiont.setAttribute("photo",t.getPhoto());
					
					//将推荐的需求信息放到session中
					if(t == null)
					{
						List<Requirement> recommendRequirement = ts.RecommendRequirement(t);
						if(recommendRequirement != null && recommendRequirement.size() != 0)
						{
							sessiont.setAttribute("recommendRequirement",recommendRequirement);
						}
					}
				}
				
				
				//若是学员登陆，将推荐的教员信息放到session中
				if(memberlogin.getRole().equals("学员"))	
				{
					RequirementService rs = new RequirementService();
					List<Requirement> r =  rs.findRequirementByMemid(updatedmember.getId());
					
					//将推荐的教员信息放到session中
					Map<Requirement, List<Teacher>> teacherRequirement = null;
					try {
						teacherRequirement = rs.RecommendTeacher(r);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(teacherRequirement != null && teacherRequirement.size() != 0)
					{
						HttpSession sessionr = request.getSession(false);
						sessionr.setAttribute("teacherRequirement",teacherRequirement);
					}
				}
				
				
				//转到会员中心
				response.sendRedirect("memberCenter.jsp");	//index.do

			} else if(mslogin.login(memberlogin) == 0){
				if(memberlogin.getRole().equals("教员"))
				{
					request.setAttribute("teacherloginMsg", "对不起，您的账号已被锁定！");
				}
				else
				{
					request.setAttribute("stuloginMsg", "对不起，您的账号已被锁定！");
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else if(mslogin.login(memberlogin) == -1){
				if(memberlogin.getRole().equals("教员"))
				{
					request.setAttribute("teacherloginMsg", "用户名或密码错误！");
				}
				else
				{
					request.setAttribute("stuloginMsg", "用户名或密码错误！");
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
