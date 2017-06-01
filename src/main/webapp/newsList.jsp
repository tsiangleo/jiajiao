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
  


<% ArrayList<News> newsList = (ArrayList<News>)request.getAttribute("newsList");
ArrayList<String> newstype = (ArrayList<String>)request.getAttribute("newstype");	

 PageControl pageControl =(PageControl)request.getAttribute("pageControl");
  PageControl pageControl2 =(PageControl)request.getAttribute("pageControl2");
  
%>
        
        <div class="bk left" id="mainContentbox">
      <div class="bktop">
        <div class="bktopzb"> </div>
        <div class="bktopyb"> </div>
        <div class="clearThis"> </div>
      </div>
      <div class="bknr">
        <div class="mainContent">
          <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">教育资讯</a></div>
          <div >
	          	<form id="form1" name="form1" method="post" action="queryNews.do?flag=2">
				  <label for="type">&nbsp;&nbsp;按类别查看资讯：</label>
				  <select name="type">
				  		<option value="不限">不限</option>
				  <%
				  
				 if(newstype != null)
				 {
					  for(int i = 0;i<newstype.size();i++) 
					  {%>
		                <option value="<%=newstype.get(i) %>"><%=newstype.get(i) %></option>
		           	<%}
		           } %>
		          </select>
				  <input type="submit" name="button" id="button" value="给我搜" />
				</form>      
          </div>
          
          <div class="cate_title">
            <h1 id="catatitle">
           资讯列表&nbsp;<%  if(newsList != null)
		{%>
            <%=newsList.get(0).getType() %>
            <%}%>
           
            </h1>
          </div>
          <div class="content_list">
            <div class="list_title">
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <th height="34" scope="col"> 标题 </th>
                  <th width="166" align="center" style="background: url(style/list_tit_spliter.png) no-repeat left center;"
                                        scope="col"> 点击量 </th>
                </tr>
              </table>
            </div>
            <ul>
            
            <%
        if(newsList != null)
		{
				 for(int i = 0;i < newsList.size();i++)
             { %>
               <li><a href="queryNewsDetail.do?id=<%=newsList.get(i).getId() %>"> <%=newsList.get(i).getTitle() %></a><span class="clicknum"><%=newsList.get(i).getClick() %></span></li>
              
           <%} 
         }  %>
              
            </ul>
          </div>
          <div class="pager">
          
  <%if(pageControl != null) 
 {%>                       
<div id="AspNetPager1">
<div style="width:40%;float:left;">
	共<%=pageControl.getRecordCount() %>条记录　每页<%=pageControl.getPageSize() %>条　当前第<%=pageControl.getCurrentPage() %>/<%=pageControl.getPageCount() %>页
</div><div style="width:60%;float:left;">
	<a href= "queryNews.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryNews.do?flag=1&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryNews.do?flag=1&&page=<%=(pageControl.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl.getCurrentPage() + 1) > pageControl.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryNews.do?flag=1&&page=<%=(pageControl.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryNews.do?flag=1&&page=<%=pageControl.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
</div>
</div>
<%} %>

 <%if(pageControl2 != null) 
 {%>                       
<div id="AspNetPager1">
<div style="width:40%;float:left;">
	共<%=pageControl2.getRecordCount() %>条记录　每页<%=pageControl2.getPageSize() %>条　当前第<%=pageControl2.getCurrentPage() %>/<%=pageControl2.getPageCount() %>页
</div><div style="width:60%;float:left;">
	<a href= "queryNews.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">首页</a>
	
	<% if ((pageControl2.getCurrentPage() - 1) <= 0)
	 { %> 
	<a href="queryNews.do?flag=2&&page=1" disabled="disabled" style="margin-right:5px;">上一页</a>
	<% } 
	else 
	{ %> 
   <a href="queryNews.do?flag=2&&page=<%=(pageControl2.getCurrentPage() - 1)%>" disabled="disabled" style="margin-right:5px;">上一页</a> 
 	<% }%> 
 	
 	<%if ((pageControl2.getCurrentPage() + 1) > pageControl2.getPageCount()) 
 	  {}
 	  else
 	  { %> 
		<a href="queryNews.do?flag=2&&page=<%=(pageControl2.getCurrentPage() + 1)%>"  disabled="disabled" style="margin-right:5px;">下一页</a> 
		<% 
	  } %> 
	
	<a href="queryNews.do?flag=2&&page=<%=pageControl2.getPageCount()%>" disabled="disabled" style="margin-right:5px;">尾页</a>
</div>
</div>
<%} %>

            
            <div class="clearThis"> </div>
          </div>
        </div>
      </div>
      <div class="bktopxb">
        <div class="bktopzx"> </div>
        <div class="bktopyx"> </div>
      </div>
    </div>
    
    
        
  <div id="slider_list" class="right">

    <div class="bk recommend_list" id="hotnews">
      <div class="bktop"><h3>热点新闻</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<News> hotNews = (ArrayList<News>)session.getAttribute("HotNews");
       
       if(hotNews != null)
       {
         int newsnum  = hotNews.size() > 5 ? 5 : hotNews.size();
        for(int i = 0;i< newsnum ;i++)
        {
         %>
          <li><a href="queryNewsDetail.do?id=<%=hotNews.get(i).getId() %>"><%=(hotNews.get(i).getTitle().length()>15 ? hotNews.get(i).getTitle().substring(0,15)+"..." : hotNews.get(i).getTitle()) %></a></li>
       <%} 
       
       }%>
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
       
       if(noticeList != null)
       {
        for(int i = 0;i<noticeList.size();i++)
        {
         %>
          <li><a href="queryNoticeDetail.do?id=<%=noticeList.get(i).getId() %>"><%=noticeList.get(i).getTitle() %></a></li>
       <%}
       } %>   
                    
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