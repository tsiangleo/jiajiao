<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
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

ArrayList<Requirement> requirements = (ArrayList<Requirement>)request.getAttribute("requirementinfo");
String idstr = request.getParameter("id");
Long id = Long.parseLong(idstr);
Map<Requirement, List<Teacher>>  teachermap = (Map<Requirement, List<Teacher>>)session.getAttribute("teacherRequirement");

%> 
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">

               <table cellpadding="1" cellspacing="1" border="0" class="mberTab">
                <tbody><tr>
                  <th colspan="4">您发布的所有需求信息如下： </th>
                </tr>
                
                <tr>
	                <td align="center"><strong>教员编号</strong></td>
	                <td align="center"><strong>教员姓名</strong></td>
	                <td align="center"><strong>辅导科目</strong></td>
	                <td align="center"><strong>辅导年级</strong></td>
	                <td align="center"><strong>操作</strong></td>
     			</tr> 
     			<%
     		for(Requirement key : teachermap.keySet())
    		{
    		   if(key.getId() == id)
    		   {
    		     List<Teacher> teachers = teachermap.get(key);
     			%>
     			
                <%
                for(int i = 0;i < teachers.size();i++)
                 { %>    
                <tr>
                	<td align="center"><%=teachers.get(i).getId() %></td>
                  	<td align="center"><%=teachers.get(i).getTeachername() %></td>
                    <td align="center"><%=teachers.get(i).getSubject() %></td>
                    <td align="center"><%=teachers.get(i).getGrade() %></td>
                    <td align="center"><a href="queryTeacherDetail.do?id=<%=teachers.get(i).getId() %>" target="_top">查看</a></td>
               </tr> 
               <%} 
               }
               
             }
		      %> 
      			</tbody>
                </table>
      
        </div>
    
    </td>
  </tr>
</table>
        
</body></html>