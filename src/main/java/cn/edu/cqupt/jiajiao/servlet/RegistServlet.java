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
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class RegistServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
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
		  
		// 注册(仅添加会员的账户信息)
		// 1、获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");

		// 2、将请求参数封装到领域对象Member
		Member member = new Member();
		member.setUsername(username);
		member.setEmail(email);
		member.setPassword(MD5Util.GetMD5Code(password));
		member.setPhone(phone);

		// 将Date转换成指定形式的时间字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String registDate = sdf.format(new java.util.Date());
		member.setRegistdate(registDate);
		member.setLogintime(registDate);
		
		//保存注册IP
		String ip = request.getRemoteAddr();
		member.setRegistip(ip);
		member.setLoginip(ip);
		
		if (role.equals("教员"))
			member.setRole("教员");
		else
			member.setRole("学员");

		// 3、调用Service组件处理
		MemberService ms = new MemberService();

		try {
			if (ms.hasMember(member.getUsername()) == false) {
				int result = 0;
				try {
					result = ms.save(member);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 4、根据处理结果转发到对应视图
				if (result == 1) // 保存成功
				{
					HttpSession session = request.getSession(true);
					//保存到session中
					Member updatedmember = ms.query(member.getUsername());
					session.setAttribute("member", updatedmember);
					
					session.setAttribute("photo", "upLoadFile/default.jpg");
					RequestDispatcher rd = request
							.getRequestDispatcher("registSucc.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("registMsg", "注册失败！");
					RequestDispatcher rd = request
							.getRequestDispatcher("regist.jsp");
					rd.forward(request, response);


				}
			} else // 用户名已存在
			{

				request.setAttribute("registMsg", "用户名已存在！");
				RequestDispatcher rd = request
						.getRequestDispatcher("regist.jsp");
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
