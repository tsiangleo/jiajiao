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
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class UpdateMemberServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMemberServlet() {
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
	
			case 1://修改会员账户信息
				HttpSession session4 = request.getSession(false);
				Member member = null;
				String username4 = null;
				if(session4 != null)
				{
					member = (Member)session4.getAttribute("member");
					username4 = member.getUsername();
				}
				
				MemberService ms4 = new MemberService();
				Member member4 = null;
				try {
					member4 = ms4.query(username4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("memberInfo", member4);
				RequestDispatcher rd = request
						.getRequestDispatcher("email_frame_fragment.jsp");
				rd.forward(request, response);
	
	
				break;
				
			case 2://修改邮箱
				HttpSession session5 = request.getSession(false);
				Member member2 = null;
				Long memberid5 = null;
				if(session5 != null)
				{
					member2 = (Member)session5.getAttribute("member");
					memberid5 = member2.getId();
				}

				String email5 = (String)request.getParameter("email");
				
				MemberService ms5 = new MemberService();
				
				int result5 = 0;
				
				try {
					result5 = ms5.updateEmail(memberid5,email5);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(result5 == 1)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('邮箱设置成功！');parent.location.href='memberCenter.jsp';</script>");
					
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('邮箱设置失败！');parent.location.href='memberCenter.jsp';</script>");
					
				}
				break;
				
			case 3://修改密码
				
				HttpSession session6 = request.getSession(false);
				Member member3 = null;
				Long memberid6 = null;
				String username6 = null;
				
				if(session6 != null)
				{
					member3 = (Member)session6.getAttribute("member");
					memberid6 = member3.getId();
					username6 = member3.getUsername();
				}
				
				
				String oldpassword = (String)request.getParameter("oldpassword");
				String newpassword = (String)request.getParameter("newpassword");
				
				MemberService ms6 = new MemberService();
				Member mb6 = null;
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
						out.println("<script>alert('密码修改成功！');parent.location.href='memberCenter.jsp';</script>");
						
					}
					else
					{
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter();
						out.println("<script>alert('密码修改失败！');parent.location.href='memberCenter.jsp';</script>");
						
					}
					break;
				}
				else//用户输入的原始密码不对
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('原密码错误！');parent.location.href='javascript:history.go(-1);';</script>");
					
				}
				
			case 4://修改账户余额
				
				//获取id和金额
				String idstr4 = (String)request.getParameter("id");
				String balancestr = (String)request.getParameter("balance");
				Integer balance = Integer.parseInt(balancestr);
				Long id4 = Long.parseLong(idstr4);
				
				MemberService ms7 = new MemberService();	
				int result4 = 0;
			try {
				result4 = ms7.updateBalance(id4,balance);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(result4 ==1)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作成功！');window.location.href='vipservice.jsp';</script>");
					
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
					
				}
				
			break;
			case 5://修改排序优先等级
				
				//获取id和排序优先等级
				String idstr5 = (String)request.getParameter("id");
				String searchrankstr = (String)request.getParameter("searchrank");
				Integer searchrank = Integer.parseInt(searchrankstr);
				Long id5 = Long.parseLong(idstr5);
				
				MemberService ms55 = new MemberService();	
				int result55 = 0;
			try {
				result55 = ms55.updateSearchRank(id5,searchrank);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(result55 ==1)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作成功！');window.location.href='vipservice.jsp';</script>");
					
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
					
				}
				
			break;
			case 6://修改会员类型
				
				//获取id和会员类型
				String idstr6 = (String)request.getParameter("id");
				String type = (String)request.getParameter("type");
				Long id6 = Long.parseLong(idstr6);
				
				MemberService ms66 = new MemberService();	
				int result66 = 0;
			try {
				result66 = ms66.updateType(id6,type);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(result66 ==1)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作成功！');window.location.href='vipservice.jsp';</script>");
					
				}
				else
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
					
				}
				
			break;
			
		case 7://修改黑名单
		case 8:
			
			//获取id和会员类型
			String idstr7 = (String)request.getParameter("id");
			Long id7 = Long.parseLong(idstr7);
			
			String state = null;
			if(flag == 7 )
				state="是";
			else
				state="否";
			
			MemberService ms78 = new MemberService();
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
				out.println("<script>alert('操作成功！');window.location.href='queryMemberList.do';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
			}
			
			break;
		case 9:	//重置密码为123456
			
			//获取id和会员类型
			String idstr9 = (String)request.getParameter("id");
			Long id9 = Long.parseLong(idstr9);
			
			MemberService ms9 = new MemberService();
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
				out.println("<script>alert('操作成功！');window.location.href='queryMemberList.do';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
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
