package cn.edu.cqupt.jiajiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.jiajiao.domain.Evaluation;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.service.EvaluationService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class EvaluationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EvaluationServlet() {
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
			case 1:	
				save(request, response);				
				break;
			case 2:		
				findAll(request, response);		
				break;
		}
	}

	/**
	 * 查询某个教员的所有评价
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("member");
		
		EvaluationService es = new EvaluationService();
		TeacherService ts = new TeacherService();
		Long teacherid = 0L;
		try {
			teacherid = ts.findTeacherByMemid(member.getId()).getId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Evaluation> evaluationlist= (List<Evaluation>)es.findAll(teacherid);
		
		request.setAttribute("evaluationlist", evaluationlist);
		RequestDispatcher rd = request.getRequestDispatcher("evaluation_frame_fragment.jsp");
		rd.forward(request, response);
	}

	/**
	 * 保存评价
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String totalevaluation = request.getParameter("totalevaluation");
		String content = request.getParameter("content");
		String teacheridstr = request.getParameter("teacherid");
		Long teacherid = Long.parseLong(teacheridstr);
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currdate = sdf.format(new java.util.Date());
		Member member = (Member)request.getSession().getAttribute("member");
		
		Evaluation evaluation = new Evaluation();
		evaluation.setAuthor(member.getUsername());
		evaluation.setContent(content);
		evaluation.setTeacherid(teacherid);
		evaluation.setTime(currdate);
		evaluation.setTotalevaluation(totalevaluation);
		
		EvaluationService es = new EvaluationService();
		int result = es.save(evaluation);
		
		//更新教师的评价值
		int value = 0;
		if(totalevaluation.equals("好评"))
			value = 1;
		if(totalevaluation.equals("中评"))
			value = 0;
		if(totalevaluation.equals("差评"))
			value = -1;
		
		TeacherService ts= new TeacherService();
		int result2 = ts.updateEvaluation(teacherid, value);
		
		if(result == 1 && result2 == 1)
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('发布评价成功！');self.location=document.referrer;</script>");
				
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('操作失败！稍后子再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
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
