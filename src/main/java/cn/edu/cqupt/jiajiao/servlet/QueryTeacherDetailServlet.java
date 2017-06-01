package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Evaluation;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.EvaluationService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class QueryTeacherDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryTeacherDetailServlet() {
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
		  
		//根据教师id,查询教员详细信息
		//获取教员id
		String teacheridstr = (String)request.getParameter("id");
		Long teacherid = Long.parseLong(teacheridstr);
		
		TeacherService ts4  = new TeacherService();
		Teacher teachinfo = new Teacher();
		try {
			teachinfo = ts4.findTeacher(teacherid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		EvaluationService es = new EvaluationService();
		List<Evaluation> evaluationlist= (List<Evaluation>)es.findAll(teacherid);
		
		request.setAttribute("teacherinfo", teachinfo);
		request.setAttribute("evaluationlist", evaluationlist);
		RequestDispatcher rd = request.getRequestDispatcher("teacherDetail.jsp");
		rd.forward(request, response);
	
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
