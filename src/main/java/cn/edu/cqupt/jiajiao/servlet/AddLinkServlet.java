package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.service.LinkService;
import cn.edu.cqupt.jiajiao.service.NewsService;

public class AddLinkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddLinkServlet() {
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
	
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String info = request.getParameter("info");
		  
        //封装成link对象
        Link link = new Link();
		
        link.setInfo(info);
        link.setName(name);
        link.setUrl(url);
        
        LinkService ls = new LinkService();
       
        int result = 0;
        try {
			result = ls.save(link);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == 1)
        {
        	response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('链接添加成功！');this.location.href='queryLink.do';</script>");	
        }
        else
        {
        	response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('链接添加失败！稍后再试！');this.location.href='javascript:history.go(-1);';</script>");	
  
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
