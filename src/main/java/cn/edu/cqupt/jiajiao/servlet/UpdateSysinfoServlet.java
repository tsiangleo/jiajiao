package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.service.SysinfoService;

public class UpdateSysinfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateSysinfoServlet() {
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

		switch (flag) {
		case 1://contactus
			String contactus = (String)request.getParameter("contactus");
			
			SysinfoService ss1 = new SysinfoService();
			int result = 0;
			try {
				result = ss1.updateContactus(contactus);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result != 0)
	        {
	        	response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('操作成功！');this.location.href='javascript:history.go(-2);';</script>");	
	        }
	        else
	        {
	        	response.setContentType("text/html;charset=UTF-8");
	    		PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('操作失败！稍后再试！');this.location.href='javascript:history.go(-1);';</script>");	
	  
	        }
			break;
			
		case 2://aboutus
			String aboutus = (String)request.getParameter("aboutus");
			
			SysinfoService ss2 = new SysinfoService();
			int result2 = 0;
			try {
				result2 = ss2.updateAboutus(aboutus);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result2 != 0)
	        {
	        	response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('操作成功！');this.location.href='javascript:history.go(-2);';</script>");	
	        }
	        else
	        {
	        	response.setContentType("text/html;charset=UTF-8");
	    		PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>alert('操作失败！稍后再试！');this.location.href='javascript:history.go(-1);';</script>");	
	  
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
