<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN">

<title>重庆家教网</title>

<script type="text/javascript" src="style/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="style/DD_belatedPNG_0.0.7a.js"></script>
<script type="text/javascript" src="style/index.js"></script>
<script type="text/javascript" src="style/top.js"></script>
<link href="css/inside.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
<link href="css/arc.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css">
<!--<link href="css/global.css" rel="stylesheet" type="text/css"> -->

</head>
<body>
<%
	Member member = (Member)session.getAttribute("member");
	String lastip = member.getLastip();
	String lasttime = member.getLasttime();
	String loginip = member.getLoginip();
	String logintime = member.getLogintime();
	
	List<Requirement> recommendRequirement = (List<Requirement>)session.getAttribute("recommendRequirement");
	
	Map<Requirement, List<Teacher>>  teachermap = (Map<Requirement, List<Teacher>>)session.getAttribute("teacherRequirement");
%> 
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">
                    <br>
               <table cellpadding="1" cellspacing="1"  border="0"class="mberTab">
                <tbody><tr>
                  <th  colspan="4"><strong>登陆信息提示</strong></th>
                </tr>
              
                <tr>
                  <td width="50%"  align="right"><strong>上次登陆时间：</strong></td>
                  <td width="50%" class="green"><%=lasttime %></td>
                </tr>
                
                 <tr>
                  <td width="50%" align="right"><strong>上次登陆IP：</strong></td>
                  <td width="50%" class="green"><%=lastip %></td>
                </tr>
                 
                <tr>
                  <td width="50%" align="right"><strong>本次登陆时间：</strong></td>
                  <td width="50%" class="green"><%=logintime %></td>
                </tr>
                
                <tr>
                  <td align="right"><strong>本次登IP：</strong></td>
                  <td class="green"><%=loginip %></td>
                </tr>
              </tbody>
              </table>
              
              <br>
               <%if(recommendRequirement != null)
              { %>
               <table cellpadding="1" cellspacing="1" border="0" class="mberTab">
                <tbody><tr>
                  <th colspan="4">系统推荐学员信息 </th>
                </tr>
               
                <tr>
                <td align="center"><strong>家长称呼</strong></td>
                <td align="center"><strong>授课区域</strong></td>
                <td align="center"><strong>求教科目</strong></td>
                 <td align="center"><strong>操作</strong></td>
     			</tr> 
     			<%for(int i = 0;i<recommendRequirement.size();i++)
     			{ %>
                    
                        <tr>
                        <td align="center"><%=recommendRequirement.get(i).getContacts() %></td>
                        <td align="center"><%=recommendRequirement.get(i).getArea() %></td>
                         <td align="center"><%=recommendRequirement.get(i).getSubject() %></td>
                        <td align="center"> <a href="queryRequirementDetail.do?flag=1&&id=<%=recommendRequirement.get(i).getId() %> " target="_top">查看</a></td>
                        </tr> 
                    </a>
      			<%} %>
      			</tbody>
                </table>
      	<%} %>
      	
      	
      	<%if(teachermap != null)
              { %>
               <table cellpadding="1" cellspacing="1" border="0" class="mberTab">
                <tbody><tr>
                  <th colspan="4">您发布的以下需求信息有了最新的推荐教员 </th>
                </tr>
               
                 <tr>
	                <td align="center"><strong>需求编号</strong></td>
	                <td align="center"><strong>联系人</strong></td>
	                <td align="center"><strong>发布时间</strong></td>
	                <td align="center"><strong>状态</strong></td>
	                <td align="center"><strong>操作</strong></td>
     			</tr>
     			
     			<%
     			for(Requirement key : teachermap.keySet())
    		    {
     			%>
     			<tr>
     				<td align="center"><a href="queryRequirementDetail.do?flag=1&&id=<%=key.getId() %>" target="_top"><%=key.getId() %></a></td>
                  	<td align="center"><%=key.getContacts() %></td>
                    <td align="center"><%=key.getIssuetime() %></td>
                    <td align="center"><%=key.getState() %></td>
                    <td align="center"><a href="recommendTeacher_frame_fragment.jsp?id=<%=key.getId() %>">查看系统推荐教员信息</a></td>
               </tr>
      			<%} %>
      			</tbody>
                </table>
      	<%} %>
      	
        </div>
    
    </td>
  </tr>
</table>
        
</body></html>