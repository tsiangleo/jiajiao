<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>


<!---------------------------------------------------------------导航与主体分割线------------------------------------------------------------------------------->

<!-- 以下为主体 -->
<div class="content_wraper">

<!------------------------------条件搜索开始---------------------------------------->

<%@ include file="search.jsp" %>

<!------------------------------条件搜索结束----------------------------------------->
   
   

<!------------------------------教员、学员列表开始处----------------------------------------->
  <div class="bk" id="listcontent_box">
 
    <div class="bknr">
      <!---  kais--->
      
      <table width="1000">
      
      		<tr height="40">
            	<td width="450">
                 <div class="shitilist_module_tit">
            		<h3><a href="queryTeacher.do?flag=1" target="_blank">教员信息</a></h3>
          		</div>
                </td>
                <td ></td>
                <td >
                
        			<div class="shitilist_module_tit">
            		<h3><a href="queryRequirement.do?flag=1" target="_blank">学员信息</a></h3>
          			</div>
                
                </td>
            </tr>
            
          <tr>
                <td width="450">
      				<table width="100%" border="0" cellspacing="0" cellpadding="0"  style="text-align:center;">
                        <tbody>
                        <tr>
                        	<td width="10%"></td>
                            <td width="15%"><strong>姓名</strong></td>
                            
                            <td width="20%"><strong>辅导科目</strong></td>
                            <td width="20%"><strong>学历</strong></td>
                            <td width="25%" style="text-align:center;"><strong>就读学校</strong></td>         
                            <td width="10%"><strong>查看</strong></td>
                        </tr>
                        <%
                        List<Teacher> teachers = (List<Teacher>)request.getAttribute("teachers");
                        if(teachers != null && !teachers.isEmpty()){
                        
                        for(int i = 0;i<teachers.size();i++)
                         {%> 
                        <tr>
                       		<td width="10%"></td>
                            <td width="15%"><%=teachers.get(i).getTeachername() %></td>
                           
                            <td width="20%"><%=teachers.get(i).getSubject() %></td>
                            <td width="20%"><%=teachers.get(i).getDegree() %></td>
                            <td width="25%" style="text-align:center;"><%=teachers.get(i).getSchool() %></td>
                            <td width="10%"><a href="queryTeacherDetail.do?id=<%=teachers.get(i).getId() %>">查看</a></td>
                        </tr>
                       <%} 
                       }%>
          
                    </tbody>
                    </table>                 
            	</td >
                
                <td width="100"></td>
                
                <td width="450">
       					<table width="100%" border="0" cellspacing="0" cellpadding="0"  style="text-align:center;">
                        <tbody>
                        <tr>
                            <td width="20%"><strong>联系人</strong></td>  
                            <td width="15%"><strong>求教科目</strong></td>
                            <td width="20%"><strong>授课区域</strong></td>         
                            <td width="30%"><strong>发布时间</strong></td>         
                            <td width="15%"><strong>查看</strong></td>
                        </tr>
                        <%
                        List<Requirement> requirements = (List<Requirement>)request.getAttribute("requirements");
                        if(requirements != null && !requirements.isEmpty()){
                        	
                        	for(int j = 0;j<requirements.size();j++)
                         {%> 
                        <tr>
                            <td width="20%"><%=requirements.get(j).getContacts() %></td>   
   				            <td width="15%"><%=requirements.get(j).getSubject() %></td>
                            <td width="20%"><%=requirements.get(j).getArea() %></td>
                            <td width="30%"><%=requirements.get(j).getIssuetime() %></td>          
                            <td width="15%"><a href="queryRequirementDetail.do?flag=1&&id=<%=requirements.get(j).getId() %>">查看</a></td>
                        </tr>
                         <%} 
                         }%>
                    </tbody>
                    </table>               
      
           		 </td>
          </tr>
      </table>
     
      
    </div>
    <div class="bktopxb">
      <div class="bktopzx"></div>
      <div class="bktopyx"></div>
    </div>
  </div>
  <!------------------------------教员、学员列表结束处----------------------------------------->
   
   
   
   <!------------------------------VIP教员开始----------------------------------------->
  <div class="bk" id="teacher_box">
    <div class="bktop" style="height:45px"><img src="style/teacher_tit.png" width="357" height="45"> </div>
    <div class="bknr">
      <div class="teacherlist">
        <ul>
        <%
         List<Teacher> VIPteachers = (List<Teacher>)session.getAttribute("VIPteachers");
          if(VIPteachers != null && !VIPteachers.isEmpty()){
          
         for(int j = 0;j<VIPteachers.size();j++)
       {
       
       %> 
 
              <li><a href="queryTeacherDetail.do?id=<%=VIPteachers.get(j).getId() %>"><img src="<%=VIPteachers.get(j).getPhoto() %>" width="96" height="108"><br><%=VIPteachers.get(j).getTeachername() %></a></li>
     
     <%}
     } %>   
                         
        </ul>
        <div class="clearThis"></div>
      </div>
    </div>
    <div class="bktopxb">
      <div class="bktopzx"></div>
      <div class="bktopyx"></div>
    </div>
  </div>
  <!------------------------------VIP教员结束----------------------------------------->
  
  <!------------------------------新闻公告开始----------------------------------------->
  <div class="bk" id="shiti_box">
    <div class="bktop" style="height:45px;"><img src="style/shiticenter_tit.png" width="641" height="45"> </div>
    <div class="bknr">
      <div class="shitilist">
      
      <%
      HashMap<String,List<News>> newsmap = (HashMap<String,List<News>>)request.getAttribute("newsmap");
       if(newsmap != null && !newsmap.isEmpty()){
      int f = 0;
      for(String typename : newsmap.keySet())
      {
       %>
        <div class="shitilist_module">
          <div class="shitilist_module_tit">
            <h3><a href="#" target="_blank"><%=typename %></a></h3>
          </div>
          <ul>
          <%
          List<News> news = newsmap.get(typename);
          int num = news.size() > 5 ? 5 : news.size();	//每类新闻最多输出5条新闻
          for(int i = 0 ;i<num;i++)
          {
           %>
            <li><a href="queryNewsDetail.do?id=<%=news.get(i).getId() %>" target="_blank"><%=news.get(i).getTitle() %></a></li>
          <%} %> 
                       
          </ul>
        </div>
        <%
        f++;
        if(f == 2)
        { %>
         <div class="clearThis"></div>
         
      <%} 
      }
      }%>
          
        <div class="shitilist_module" style="margin-bottom: 2px;">
          <div class="shitilist_module_tit">
            <h3><a href="#" target="_blank">系统公告</a></h3>
          </div>
          <ul>        
          
           <% ArrayList<Notice> noticeList = (ArrayList<Notice>)session.getAttribute("noticeList");
           int num2 = noticeList.size()>5 ? 5:noticeList.size();
        for(int i = 0;i<num2;i++)
        {
         %>
            <li><a href="queryNoticeDetail.do?id=<%=noticeList.get(i).getId() %>"><%=noticeList.get(i).getTitle() %></a></li>
       <%} %> 
                  
          </ul>
        </div>
        <div class="clearThis"></div>
        
        <div class="clearThis"></div>
      </div>
    </div>
    <div class="bktopxb">
      <div class="bktopzx"></div>
      <div class="bktopyx"></div>
    </div>
    <div class="clearThis"></div>
  </div>
  <div class="clearThis"></div>
  <!------------------------------新闻公告结束----------------------------------------->
  
  

<!------------------------------链接开始处----------------------------------------->

  <div class="bk" id="flink">
    <div class="bktop">
      <div class="bktopzb"></div>
      <div class="bktopyb"></div>
      <div class="clearThis"></div>
    </div>
    <div class="bknr">
      <div class="flink_tit"><img src="style/flink_tit.png" width="86" height="15"></div>
      <div class="flink_list">
        <ul>
        <% ArrayList<Link> linkList = (ArrayList<Link>)session.getAttribute("linkList");
        for(int k = 0;k<linkList.size();k++)
        {
         %>
          <li><a href="<%=linkList.get(k).getUrl() %>"><%=linkList.get(k).getName() %></a></li>
       <%} %>
       
        </ul>
        <div class="clearThis"></div>
      </div>
    </div>
    <div class="bktopxb">
      <div class="bktopzx"></div>
      <div class="bktopyx"></div>
    </div>
  </div>
  <!------------------------------链接结束处----------------------------------------->
  
</div>


<jsp:include page="foot.jsp" flush="true" />

</body></html>