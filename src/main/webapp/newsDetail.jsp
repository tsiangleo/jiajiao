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
  
<% News newsinfo = (News)request.getAttribute("newsinfo"); 
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
                    <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">教育资讯</a></div>       
                    <div class="cate_title">
                        <h1 id="VideoTitle"><%=newsinfo.getTitle() %></h1>
                       <center> 来源：<%=newsinfo.getSource() %>&nbsp;&nbsp;时间：<%=newsinfo.getPublishtime() %>&nbsp;&nbsp;点击：<%=newsinfo.getClick() %>次
                    	</center>

                    </div>
                    
                    <div class="navlinks">
		            <ul></ul>
		            <div class="clearThis"></div>
		            </div>
		          
                    
                    
                    <div id="VideoContent" class="arc_content">
					<%=newsinfo.getContent() %>
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