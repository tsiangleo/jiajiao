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
	                <td align="center"><strong>需求编号</strong></td>
	                <td align="center"><strong>联系人</strong></td>
	                <td align="center"><strong>发布时间</strong></td>
	                <td align="center"><strong>状态</strong></td>
	                <td align="center"><strong>操作</strong></td>
     			</tr> 
                <%
                for(int i = 0;i < requirements.size();i++)
                 { %>    
                <tr>
                	<td align="center"><%=requirements.get(i).getId() %></td>
                  	<td align="center"><%=requirements.get(i).getContacts() %></td>
                    <td align="center"><%=requirements.get(i).getIssuetime() %></td>
                    <td align="center"><%=requirements.get(i).getState() %></td>
                    <td align="center">
                    	
                    	<a href="queryRequirementDetail.do?flag=2&&queryandupdate=0&&id=<%=requirements.get(i).getId() %>">查看</a>&nbsp;	
                    	<a href="queryRequirementDetail.do?flag=2&&queryandupdate=1&&id=<%=requirements.get(i).getId() %>">修改</a>&nbsp;
                    	                  	
                    	<% 
                    	if(requirements.get(i).getState().equals("已预约"))
                    	{
                    	 %>
                    	 <a href="updateRequirement.do?flag=2&&msg=1&&id=<%=requirements.get(i).getId() %>" onclick='return confirm("确定要标记为【可预约】吗?")'>标记为可预约</a>                   	
                      <%}
                    	if(requirements.get(i).getState().equals("可预约"))
                     	{%>
                    	<a href="updateRequirement.do?flag=2&&msg=0&&id=<%=requirements.get(i).getId() %>" onclick='return confirm("确定要标记为【已预约】吗?")'>标记为已预约</a>
                      <%} %>
                    </td>
               </tr> 
               <%} %> 
      			</tbody>
                </table>
      
        </div>
    
    </td>
  </tr>
</table>
        
</body></html>