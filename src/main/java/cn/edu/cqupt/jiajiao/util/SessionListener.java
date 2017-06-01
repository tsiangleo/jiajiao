package cn.edu.cqupt.jiajiao.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.edu.cqupt.jiajiao.domain.Link;
import cn.edu.cqupt.jiajiao.domain.News;
import cn.edu.cqupt.jiajiao.domain.Notice;
import cn.edu.cqupt.jiajiao.domain.Requirement;
import cn.edu.cqupt.jiajiao.domain.Sysinfo;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.LinkService;
import cn.edu.cqupt.jiajiao.service.NewsService;
import cn.edu.cqupt.jiajiao.service.NoticeService;
import cn.edu.cqupt.jiajiao.service.RequirementService;
import cn.edu.cqupt.jiajiao.service.SysinfoService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class SessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(session.isNew())
		{
			//查询链接数据，用于显示链接
			ArrayList<Link> linkList = null;
			LinkService ls = new LinkService();
			try {
				linkList = (ArrayList<Link>) ls.findAll();
			} catch (SQLException e) {
								e.printStackTrace();
			}		
			if(linkList != null && linkList.size() > 0)
			{
				session.setAttribute("linkList", linkList);	//将友情链接信息存在session中
			}
						
			//查询公告数据，用于显示公告
			ArrayList<Notice> noticeList = null;
			NoticeService ns = new NoticeService();
			try {
				noticeList = (ArrayList<Notice>) ns.findAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(noticeList != null && noticeList.size() > 0)
			{
				session.setAttribute("noticeList", noticeList);	//将公告信息存在session中
			}
			
			//将推荐学员放到session中
			RequirementService tss = new RequirementService();
			List<Requirement> VIPStudent = null;
			try {
				VIPStudent = tss.findTop10();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(	VIPStudent != null && VIPStudent != Collections.EMPTY_LIST)	//teacher不为空
			{
				session.setAttribute("VIPRequirement", VIPStudent);	//将信息存在session中
			}	
			
			//将点击数最高的新闻放到session中	
			NewsService ns1 = new NewsService();
			
			List<News> news1 = null;
			try {
				news1 = ns1.findTop10Click();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(	news1 != null && news1 != Collections.EMPTY_LIST)	//news1不为空
			{
				session.setAttribute("HotNews", news1);	//将信息存在session中
			}					
			
			//将网站的参数信息放到Application中
			Sysinfo sysinfo = null;
			SysinfoService ss = new SysinfoService();
			try {
				sysinfo = ss.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(sysinfo != null)
			{
				//取得Application对象 
		        ServletContext application = session.getServletContext(); 
	            application.setAttribute("sysinfo", sysinfo);	//将参数信息存在application中
			}		
				
			//获取VIP教员信息放到session中
			TeacherService ts2  = new TeacherService();
			List<Teacher> VIPteachers = null;
			try {
				VIPteachers = ts2.findVIPTOP6();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(	VIPteachers != null && VIPteachers != Collections.EMPTY_LIST)	//teacher不为空
			{		
				session.setAttribute("VIPteachers", VIPteachers);	//将信息存在session中
			}
	
		}
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
