package cn.edu.cqupt.jiajiao.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Administrator;
import cn.edu.cqupt.jiajiao.domain.Member;

public class AuthenticationFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1、判断登陆
		HttpServletRequest httpservletRequest = (HttpServletRequest)request;
		HttpServletResponse httpservletResponse = (HttpServletResponse)response;
		//获取请求的URI
		String requestPath = httpservletRequest.getServletPath();

		
		if(requestPath.contains("/admin/"))	//若是后台管理
		{
			HttpSession session = httpservletRequest.getSession(false);
			Administrator admin = null;
			if(session != null)
				admin = (Administrator)session.getAttribute("administrator");
			
			if(!requestPath.equals("/admin/login.jsp") && !requestPath.equals("/admin/adminLogin.do"))
			{
				if(admin == null)
				{
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter();
					out.println("<script>alert('请先登录再操作！');parent.location.href='/jiajiao/admin/login.jsp';</script>");
					return;
				}
			}
			
		}
		else if(!requestPath.equals("/login.jsp") && !requestPath.equals("/regist_jj.jsp") && !requestPath.equals("/regist_jz.jsp")
				&& !requestPath.equals("/login.do") && !requestPath.equals("/regist.do")
				&& !requestPath.equals("/queryRequirementList.do") && !requestPath.equals("/queryRequirement.do")
				&& !requestPath.equals("/queryTeacher.do") && !requestPath.equals("/index.jsp")
				&& !requestPath.equals("/image.jsp") && !requestPath.equals("/queryNews.do")
				&& !requestPath.equals("/queryNotice.do") && !requestPath.equals("/index.do")
				&& !requestPath.equals("/queryNewsDetail.do") && !requestPath.equals("/queryNoticeDetail.do")
				&& !requestPath.equals("/logout.do"))
		{
			HttpSession session = httpservletRequest.getSession(false);
			Member member = null;
			if(session != null)
				member = (Member)session.getAttribute("member");
			//28集视频
			if(member == null)
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('请先登录再操作！');parent.location.href='login.jsp';</script>");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
