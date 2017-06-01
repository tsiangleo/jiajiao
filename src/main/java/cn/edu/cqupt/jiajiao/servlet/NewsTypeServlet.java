package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class NewsTypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsTypeServlet() {
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
		case 1://添加新闻类型
			String type = request.getParameter("type");
			String sql = "INSERT INTO t_newstype(newsType) values(?)";

			Connection connection = ConnectionManager.getConnection();
			PreparedStatement prestmt = null;

			try {
				prestmt = connection.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				prestmt.setString(1, type);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int result = 0;
			try {
				result = prestmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prestmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConnectionManager.freeConnection(connection);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			if(result == 1)
			{
				out.print("<script type='text/javascript'>alert('新闻类型添加成功！');this.location.href='javascript:history.go(-2);';</script>");	
			}
			else
			{
				out.print("<script type='text/javascript'>alert('新闻类型添加失败，稍后再试！');this.location.href='javascript:history.go(-1);';</script>");	
			}
			break;
		case 2://查找新闻类型列表
			
			String sql2 = "SELECT * FROM t_newstype";
			List<String> newstypeList = new ArrayList<String>();
			
			Connection connection2 = ConnectionManager.getConnection();
			PreparedStatement prestmt2 = null;
			
			try {
				prestmt2 = connection2.prepareStatement(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ResultSet rs = null;
			try {
				rs = prestmt2.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int index = 0;
			try {
				while(rs.next())
				{			
					newstypeList.add(index++, rs.getString("newsType"));			
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				prestmt2.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			if(newstypeList.size() == 0 || newstypeList == Collections.EMPTY_LIST)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out2 = response.getWriter();
				out2.println("<script>alert('请先添加新闻种类，再发布新闻！');parent.location.href='index.jsp';</script>");
				
			}
			else
			{
				request.setAttribute("newstypeList", newstypeList);
				RequestDispatcher rd2 = request.getRequestDispatcher("addNews.jsp");
				rd2.forward(request, response);
				
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
