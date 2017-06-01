package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Collection;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.CollectionService;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.TeacherService;
import cn.edu.cqupt.jiajiao.util.MD5Util;

public class CollectionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CollectionServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader("Expires",0);
		  
		
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);

		switch (flag) {
		case 1:	//加入收藏夹
			//获得教员id
			String tidstr = request.getParameter("tid");
			Long teacherid = Long.parseLong(tidstr);
			
			HttpSession session = request.getSession(false);
			Member member = null;
			String role = null;
			if(session != null)
			{
				member = (Member)session.getAttribute("member");
				role = member.getRole();
			}
			
			if(role.equals("教员"))
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('只有学员身份才能收藏！');parent.location.href='javascript:history.go(-1);';</script>");
				break;	
			}
			
			//获得学员id
			Long memberid = member.getId();

			// 将Date转换成指定形式的时间字符串
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String collectionDate = sdf.format(new java.util.Date());

			
			Collection collection = new Collection();
			collection.setMemberid(memberid);
			collection.setTeacherid(teacherid);
			collection.setTime(collectionDate);


			// 3、调用Service组件处理
			CollectionService cs = new CollectionService();
			boolean c = false;
			try {
				c = cs.hasCollection(memberid,teacherid);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(c == true)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('已收藏！不要重复收藏！');parent.location.href='javascript:history.go(-1);';</script>");
				break;	
			}
			
			
			int result = 0;
			
			try {
				result = cs.save(collection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == 1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('收藏成功！');parent.location.href='javascript:history.go(-1);';</script>");
				break;	
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('收藏失败！');parent.location.href='javascript:history.go(-1);';</script>");
				break;	
			}
		
		case 2:	//查看收藏夹
			//获得学员id
			HttpSession session2 = request.getSession(false);
			Member member2 = null;
			Long memberid2 = null;
			if(session2 != null)
			{
				member2 = (Member)session2.getAttribute("member");
				memberid2 = member2.getId();
			}
			
			CollectionService cs2 = new CollectionService();
			ArrayList<Collection> collections = new ArrayList<Collection>();
			
			try {
				collections = (ArrayList<Collection>) cs2.findAll(memberid2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(collections == Collections.EMPTY_LIST)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您目前的收藏夹为空！');parent.location.href='javascript:history.go(-1);';</script>");
				break;
			}
			else
			{
				request.setAttribute("collections", collections);
				RequestDispatcher rd2 = request.getRequestDispatcher("queryCollectionList_frame_fragment.jsp");
				rd2.forward(request, response);
				break;
			}
			
		case 3://移除收藏夹
			//获得被移除的记录 的id
			String idstr3 = request.getParameter("id");
			Long id3 = Long.parseLong(idstr3);
			
			CollectionService cs3 = new CollectionService();
			int result3 = 0;
			try {
				result3 = cs3.delete(id3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result3 == 1)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>alert('移除成功！');self.location=document.referrer;</script>");
				break;
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('移除失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				break;
			}
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
