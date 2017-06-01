package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Student;
import cn.edu.cqupt.jiajiao.service.StudentService;

public class QueryAndUpdateStudentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryAndUpdateStudentServlet() {
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
		  
		//根据学生的id,查询学员详细信息
		//修改学员信息
			String flagstr = request.getParameter("flag");
			Integer flag = Integer.parseInt(flagstr);
	
			
			String idstr = request.getParameter("id");
			Integer stuid = Integer.parseInt(idstr);
			StudentService ss4  = new StudentService();
			Student student4 = null;
			try {
				student4 = ss4.findStudent(stuid);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			request.setAttribute("studentinfo", student4);
			RequestDispatcher rd = request.getRequestDispatcher(
					flag == 1 ? "queryStudent_frame_fragment.jsp" : "updateStudent_frame_fragment.jsp");
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
