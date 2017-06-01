package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.PageControl;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class QueryRequirementServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryRequirementServlet() {
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
		  
		//
		//queryRequirement.do
		
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		switch(flag)
		{
		
		case 1://查询需求信息（没有条件）；点击菜单上的【会员库】
			RequirementService rs2 = new RequirementService();
			int recordCount = 0;	//一共有多少记录 
			recordCount = rs2.getRequirementNum();;
      
			//获取分页对象，传参 
            String pageStr = request.getParameter("page"); 
            int currentPage = 1; 
            if (pageStr != null) { 
                currentPage = Integer.parseInt(pageStr); 
            } 
            PageControl view = new PageControl(10, recordCount, currentPage); 
            //获取参数 
            int fromIndex = view.getFromIndex();//起始位置 
            int pageSize = view.getPageSize();//每页显示的记录数 
            
            
			List<Requirement> requirements = null;
			
			try {
				requirements = rs2.findAll(fromIndex,pageSize);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(requirements != null &&	requirements != Collections.EMPTY_LIST)	//requirement不为空
			{
				request.setAttribute("pageControl", view);
				request.setAttribute("requirements", requirements);
				RequestDispatcher rd = request.getRequestDispatcher("requirementList.jsp");
				rd.forward(request, response);
			}
			break;
			
		case 2://查询需求信息（含条件）【条件搜索提交到此处】
			
			String pageStr2 = request.getParameter("page"); 
			String sql = null;
			if(pageStr2 == null)
			{
				//获取参数
				
				String subject3 = (String)request.getParameter("subject");
				String grade3 = (String)request.getParameter("grade");
				String area3 = (String)request.getParameter("area");
				String stugender3 = (String)request.getParameter("stugender");
				
				//拼接成SQL语句
				sql = "SELECT * FROM t_requirement " +
						"WHERE subject='"+ subject3 +"',grade='"+ grade3 +"',area='"+ area3 +"',stugender='"+ stugender3 +"'";
				
				//对SQL语句进行处理
				if(sql.contains("WHERE subject='不限',grade='不限',area='不限',stugender='不限'"))
					sql = "SELECT * FROM t_requirement";
				if(sql.contains("subject='不限',"))
					sql = sql.replaceAll("subject='不限',", "");			
				if(sql.contains("grade='不限',"))
					sql = sql.replaceAll("grade='不限',", "");
				if(sql.contains("area='不限',"))
					sql = sql.replaceAll("area='不限',", "");
				if(sql.contains("stugender='不限'"))
					sql = sql.replaceAll("stugender='不限'", "");
				if(sql.endsWith(","))	//若结尾还有逗号，将逗号去掉
					sql = sql.substring(0, sql.length()-1);
				sql = sql.replaceAll(",", " AND ");
				
				//要将拼接后的SQL放到session中，负责当用户点击上一页的时候sql没了
				request.getSession(false).setAttribute("sql", sql);
			
			}
			else
			{
				sql = (String) request.getSession(false).getAttribute("sql");
			}
			
			
			//调用业务逻辑方法处理
			RequirementService rs3  = new RequirementService();
			
			int recordCount2 = 0;	//一共有多少记录 
			recordCount2 = rs3.getTeacherNum(sql);
      
			//获取分页对象，传参 
            pageStr2 = request.getParameter("page"); 
            int currentPage2 = 1; 
            if (pageStr2 != null) { 
                currentPage2 = Integer.parseInt(pageStr2); 
            } 
            PageControl view2 = new PageControl(10, recordCount2, currentPage2); 
            //获取参数 
            int fromIndex2 = view2.getFromIndex();//起始位置 
            int pageSize2 = view2.getPageSize();//每页显示的记录数 
               
			List<Requirement> requirement3 = new ArrayList<Requirement>();
			try {
				requirement3 = rs3.findrequirementBySQL(sql,fromIndex2,pageSize2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(	requirement3 != Collections.EMPTY_LIST)	//teacher不为空
			{
				request.setAttribute("pageControl2", view2);
				request.setAttribute("requirements", requirement3);
				RequestDispatcher rd = request.getRequestDispatcher("requirementList.jsp");
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
