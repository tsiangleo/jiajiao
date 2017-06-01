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

<% ArrayList<Requirement> requirements = (ArrayList<Requirement>)request.getAttribute("requirements");
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
                    <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">学员库</a></div>
                    <div class="cate_title">
                        <h1>
                            学员列表</h1>
                    </div>
                    <div class="content_list">
                        <table width="655" border="0" cellspacing="0" cellpadding="5">
                           
                            <%for(int i = 0;i < requirements.size();i++)
                           { %>
                            <tr><!--一个学员开始处 -->
                                
                                <td width="100%">
                                    <strong class="font14">	 【学员： <%=requirements.get(i).getStudentname() %>	】</strong>
                                	<strong class="font14">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学员编号： <%=requirements.get(i).getId() %></strong>
                                </td>     
                            </tr>
                            <tr>
                                <td>
                                    <table >
                                    	<tr>
                                        	<td width="246"><font color="#0033FF">学员性别：</font><%=requirements.get(i).getStugender() %></td>
                                            <td width="237"><font color="#0033FF">课时费用：</font><font color="#FF0000">
									<% if(requirements.get(i).getSalary() == 39)
													{	out.print("40元以下/时"); %>
											<%
											 }else if(requirements.get(i).getSalary() == 101) 
											{	out.print("100元以上/时");  %>
											<%} else if(requirements.get(i).getSalary() == 0)
											{out.print("面议");} 											
											else 
											{out.println(requirements.get(i).getSalary() + "元/时");} %>	
													</font></td>
                                        </tr>
                                        <tr>
                                     	   <td  width="246"><font color="#0033FF">出生日期:</font><%=requirements.get(i).getBirthday() %></td>
                                        	<td  width="237"><font color="#0033FF">所在年级：</font><%=requirements.get(i).getGrade()%></td>      
                                        </tr>
                                         <tr>
                                        	<td  width="483"><font color="#0033FF">求教科目：</font><%=requirements.get(i).getSubject() %></td>               
                                        </tr>
                                         <tr>
                                        	<td width="483"><font color="#0033FF">辅导地区：</font><%=requirements.get(i).getArea() %></td>
                                        </tr>
                                        <tr>
                                        	<td width="483"><font color="#0033FF">学习情况：</font><%=requirements.get(i).getDescription() %></td>
                                            <td align="center">  <a href="queryRequirementDetail.do?flag=1&&id=<%=requirements.get(i).getId() %>"><img src="images/lookdetail.png" width="140" height="40" /></a> </td>
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
	<a href= "queryRequirement.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryRequirement.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryRequirement.do?flag=1&&page=<%=(pageControl.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl.getCurrentPage() + 1) > pageControl.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryRequirement.do?flag=1&&page=<%=(pageControl.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryRequirement.do?flag=1&&page=<%=pageControl.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
</div>
</div>
<%} %>

 <%if(pageControl2 != null) 
 {%>                       
<div id="AspNetPager1">
<div style="width:40%;float:left;">
	共<%=pageControl2.getRecordCount() %>条记录　每页<%=pageControl2.getPageSize() %>条　当前第<%=pageControl2.getCurrentPage() %>/<%=pageControl2.getPageCount() %>页
</div><div style="width:60%;float:left;">
	<a href= "queryRequirement.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl2.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryRequirement.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryRequirement.do?flag=2&&page=<%=(pageControl2.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl2.getCurrentPage() + 1) > pageControl2.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryRequirement.do?flag=2&&page=<%=(pageControl2.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryRequirement.do?flag=2&&page=<%=pageControl2.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
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
        <h3>推荐学员</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<Requirement> VIPRequirement = (ArrayList<Requirement>)session.getAttribute("VIPRequirement");
         int reqnum  = VIPRequirement.size() > 5 ? 5 : VIPRequirement.size();
        for(int i = 0;i< reqnum ;i++)
        {
         %>
                 <li><a href="queryRequirementDetail.do?flag=1&&id=<%=VIPRequirement.get(i).getId() %>">
                            <%=VIPRequirement.get(i).getContacts() %>&nbsp;&nbsp;
                            <%=VIPRequirement.get(i).getSubject() %>&nbsp;&nbsp;
                            <%=VIPRequirement.get(i).getArea() %>
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
      <div class="bktop">
        <h3>系统公告</h3><span class="more"><a href="#">more</a></span></div>
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