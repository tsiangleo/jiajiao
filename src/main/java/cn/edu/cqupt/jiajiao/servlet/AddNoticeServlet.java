package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.Notice;
import cn.edu.cqupt.jiajiao.service.NewsService;
import cn.edu.cqupt.jiajiao.service.NoticeService;

public class AddNoticeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddNoticeServlet() {
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
		  
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String Issuetime = sdf.format(new java.util.Date());       
        //封装成Notice对象
        Notice notice = new Notice();
		
        notice.setContent(content);
        notice.setTitle(title);
        notice.setPublishtime(Issuetime);
        
        
        NoticeService ns = new NoticeService();
       
        int result = 0;
        try {
			result = ns.save(notice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == 1)
        {
        	response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('公告发布成功！');this.location.href='javascript:history.go(-2);';</script>");	
        }
        else
        {
        	response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>alert('公告发布失败！稍后再试！');this.location.href='javascript:history.go(-1);';</script>");	
  
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
