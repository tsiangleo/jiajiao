<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>
<div class="content_wraper">
<!-- 以下为主体 -->
  
  <%@ include file="search.jsp" %>

<% ArrayList<Teacher> teachers = (ArrayList<Teacher>)request.getAttribute("teachers");
 PageControl pageControl =(PageControl)request.getAttribute("pageControl");
  PageControl pageControl2 =(PageControl)request.getAttribute("pageControl2");
%>
        <div class="bk left" id="mainContentbox">
            <div class="bktop">
                <div class="bktopzb">
                </div>
                <div class="bktopyb">
                </div>
                <div class="clearThis">
                </div>
            </div>
            <div class="bknr">
                <div class="mainContent">
                    <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">教员库</a></div>
                    <div class="cate_title">
                        <h1>
                            教员列表</h1>
                    </div>
                    <div class="content_list">
                        <table width="655" border="0" cellspacing="0" cellpadding="5">
                           
                           <%for(int i = 0;i < teachers.size();i++)
                           { %>
                            <tr><!--一个学员开始处 -->
                                <td width="138" rowspan="2">
                                    <img src="<%=teachers.get(i).getPhoto() %>" width="140" height="150" />
                                </td>
                                <td width="80%">
                                    <strong class="font14">	【教员： <%=teachers.get(i).getTeachername() %>	】</strong>
                                	<strong class="font14">&nbsp;&nbsp;【教员编号： <%=teachers.get(i).getId() %>】&nbsp;&nbsp;【认证情况： <%=teachers.get(i).getAuthentication() %>】	</strong>
                                </td>     
                            </tr>
                            <tr>
                                <td>
                                    <table width="495">
                                    	<tr>
                                        	<td width="246"><font color="#0033FF">辅导年级：</font><font color="#FF0000"><%=teachers.get(i).getGrade() %></font></td>
                                            <td width="237"><font color="#0033FF">课时费用：</font><font color="#FF0000">
                                            <% if(teachers.get(i).getSalary() == 39)
													{	out.print("40元以下/时"); %>
											<%
											 }else if(teachers.get(i).getSalary() == 101) 
											{	out.print("100元以上/时");  %>
											<%} else if(teachers.get(i).getSalary() == 0)
											{out.print("面议");} 											
											else 
											{out.println(teachers.get(i).getSalary() + "元/时");} %>	
													</font></td>
                                        </tr>
                                        <tr>
                                     	   <td  width="246"><font color="#0033FF">最高学历:</font><%=teachers.get(i).getDegree() %></td>
                                        	<td  width="237"><font color="#0033FF">所在学校：</font><%=teachers.get(i).getSchool() %></td>      
                                        </tr>
                                         <tr>
                                        	<td  width="483"><font color="#0033FF">辅导科目：</font><%=teachers.get(i).getSubject() %></td>               
                                        </tr>
                                         <tr>
                                        	<td width="483"><font color="#0033FF">辅导地区：</font><%=teachers.get(i).getServicearea() %></td>
                                        </tr>
                                        <tr>
                                        	<td width="483"><font color="#0033FF">个人简介：</font><%=teachers.get(i).getDescription() %></td>
                                            <td align="center">  <a href="queryTeacherDetail.do?id=<%=teachers.get(i).getId() %>"><img src="images/lookdetail.png" width="140" height="40" /></a> </td>
                                        </tr>
                                        
                                    </table>

                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" height="20">
                                    <div style="height: 5px; border-bottom: dashed 1px #666;">
                                    </div>
                                </td>
                            </tr><!--一个学员结束处 -->
                            <%} %>
                            
                             
                        </table>
                    </div>
                    <div class="pager">
 <%if(pageControl != null) 
 {%>                       
<div id="AspNetPager1">
<div style="width:40%;float:left;">
	共<%=pageControl.getRecordCount() %>条记录　每页<%=pageControl.getPageSize() %>条　当前第<%=pageControl.getCurrentPage() %>/<%=pageControl.getPageCount() %>页
</div><div style="width:60%;float:left;">
	<a href= "queryTeacher.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryTeacher.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryTeacher.do?flag=1&&page=<%=(pageControl.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl.getCurrentPage() + 1) > pageControl.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryTeacher.do?flag=1&&page=<%=(pageControl.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryTeacher.do?flag=1&&page=<%=pageControl.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
</div>
</div>
<%} %>

 <%if(pageControl2 != null) 
 {%>                       
<div id="AspNetPager1">
<div style="width:40%;float:left;">
	共<%=pageControl2.getRecordCount() %>条记录　每页<%=pageControl2.getPageSize() %>条　当前第<%=pageControl2.getCurrentPage() %>/<%=pageControl2.getPageCount() %>页
</div><div style="width:60%;float:left;">
	<a href= "queryTeacher.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl2.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryTeacher.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryTeacher.do?flag=2&&page=<%=(pageControl2.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl2.getCurrentPage() + 1) > pageControl2.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryTeacher.do?flag=2&&page=<%=(pageControl2.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryTeacher.do?flag=2&&page=<%=pageControl2.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
</div>
</div>
<%} %>


                        <div class="clearThis">
                        </div>
                        </div>
                </div>
            </div>
            <div class="bktopxb">
                <div class="bktopzx">
                </div>
                <div class="bktopyx">
                </div>
            </div>
        </div>
        
  <div id="slider_list" class="right">
    <div class="bk recommend_list">
      <div class="bktop">
        <h3>推荐教员</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<Teacher> VIPteachers = (ArrayList<Teacher>)session.getAttribute("VIPteachers");
         int technum  = VIPteachers.size() > 5 ? 5 : VIPteachers.size();
        for(int i = 0;i< technum ;i++)
        {
         %>
                 <li><a href="queryTeacherDetail.do?flag=1&&id=<%=VIPteachers.get(i).getId() %>">
                            <%=VIPteachers.get(i).getTeachername() %>&nbsp;&nbsp;
                            <%=VIPteachers.get(i).getSubject() %>&nbsp;&nbsp;
                            <%=VIPteachers.get(i).getDegree() %>
                    </a>
                </li>                  
       <%} %>              
        </ul>
        
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
     <div class="bk recommend_list" id="hotnews">
      <div class="bktop"><h3>热点新闻</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<News> hotNews = (ArrayList<News>)session.getAttribute("HotNews");
         int newsnum  = hotNews.size() > 5 ? 5 : hotNews.size();
        for(int i = 0;i< newsnum ;i++)
        {
         %>
          <li><a href="queryNewsDetail.do?id=<%=hotNews.get(i).getId() %>"><%=(hotNews.get(i).getTitle().length()>15 ? hotNews.get(i).getTitle().substring(0,15)+"..." : hotNews.get(i).getTitle()) %></a></li>
       <%} %>
        </ul>
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
    <div class="bk recommend_list" id="hot_shipin">
      <div class="bktop"><h3>系统公告</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
     <% ArrayList<Notice> noticeList = (ArrayList<Notice>)session.getAttribute("noticeList");
        for(int i = 0;i<noticeList.size();i++)
        {
         %>
          <li><a href="queryNoticeDetail.do?id=<%=noticeList.get(i).getId() %>"><%=noticeList.get(i).getTitle() %></a></li>
       <%} %>
                
        </ul>
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
  </div>

        <div class="clearThis">
        </div>

  
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>