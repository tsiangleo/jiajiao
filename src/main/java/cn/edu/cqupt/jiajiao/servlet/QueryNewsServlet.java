package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.PageControl;
import cn.edu.cqupt.jiajiao.service.NewsService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class QueryNewsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryNewsServlet() {
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
		case 1://查询新闻信息（没有条件），点击菜单上的【新闻资讯库】
			NewsService ns  = new NewsService();
			
			int recordCount = 0;	//一共有多少记录 
			recordCount = ns.getNewsNum();
      
			//获取分页对象，传参 
            String pageStr = request.getParameter("page"); 
            int currentPage = 1; 
            if (pageStr != null) { 
                currentPage = Integer.parseInt(pageStr); 
            } 
            PageControl view = new PageControl(20, recordCount, currentPage); 
            //获取参数 
            int fromIndex = view.getFromIndex();//起始位置 
            int pageSize = view.getPageSize();//每页显示的记录数 
            
            
			List<News> newsList = null;
			newsList = ns.findAll(fromIndex,pageSize);
			if(	newsList != null && newsList != Collections.EMPTY_LIST)	//news不为空
			{
				request.setAttribute("pageControl", view);
				request.setAttribute("newsList", newsList);
				request.setAttribute("newstype", ns.queryNewsType());
				RequestDispatcher rd = request.getRequestDispatcher("newsList.jsp");
				rd.forward(request, response);
			}	
			break;
		
			
		case 2://查询新闻信息（有条件）
			
			String pageStr2 = request.getParameter("page"); 
			String type = request.getParameter("type");
			
			if(type == null)
			{
				type = (String) request.getSession(false).getAttribute("type");
			}
			if(type.equals("不限"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("queryNews.do?flag=1");
				rd.forward(request, response);
				return;
			}
			else
			{
				
				if(pageStr2 == null)
				{
					
					request.getSession(false).setAttribute("type", type);	
				}
				else
				{
					type = (String) request.getSession(false).getAttribute("type");
				}
				
			}
				
			NewsService ns2  = new NewsService();
			
			int recordCount2 = 0;	//一共有多少记录 
			recordCount2 = ns2.getNewsNumByType(type);
      
			//获取分页对象，传参 
            pageStr2 = request.getParameter("page"); 
            int currentPage2 = 1; 
            if (pageStr2 != null) { 
                currentPage2 = Integer.parseInt(pageStr2); 
            } 
            PageControl view2 = new PageControl(20, recordCount2, currentPage2); 
            //获取参数 
            int fromIndex2 = view2.getFromIndex();//起始位置 
            int pageSize2 = view2.getPageSize();//每页显示的记录数 
   
            
			List<News> newsList2 = null;
			newsList2 = ns2.findByType(type,fromIndex2,pageSize2);
			if(	newsList2 != null && newsList2 != Collections.EMPTY_LIST)	//news不为空
			{
				request.setAttribute("pageControl2", view2);
				request.setAttribute("newsList", newsList2);
				request.setAttribute("newstype", ns2.queryNewsType());
				RequestDispatcher rd = request.getRequestDispatcher("newsList.jsp");
				rd.forward(request, response);
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
