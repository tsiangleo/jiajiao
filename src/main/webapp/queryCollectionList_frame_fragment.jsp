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
ArrayList<cn.edu.cqupt.jiajiao.domain.Collection> collections = (ArrayList<cn.edu.cqupt.jiajiao.domain.Collection>)request.getAttribute("collections");
%> 
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">

               <table cellpadding="1" cellspacing="1" border="0" class="mberTab">
                <tbody><tr>
                  <th colspan="4">您目前收藏的教员信息如下： </th>
                </tr>
                
                <tr>
	                <td align="center"><strong>记录编号</strong></td>
	                <td align="center"><strong>教员编号</strong></td>
	                <td align="center"><strong>收藏时间</strong></td>
	                <td align="center"><strong>操作</strong></td>
     			</tr> 
                <%
                for(int i = 0;i < collections.size();i++)
                 { %>    
                <tr>
                	<td align="center"><%=collections.get(i).getId() %></td>
                  	<td align="center"><a href="queryTeacherDetail.do?id=<%=collections.get(i).getTeacherid() %>" target="_parent"><%=collections.get(i).getTeacherid() %></a></td>
                    <td align="center"><%=collections.get(i).getTime() %></td>
                    <td align="center">
                    	<a href="collection.do?flag=3&&id=<%=collections.get(i).getId() %>" onclick='return confirm("确定要移除收藏夹吗?")'>从收藏夹中移除</a>
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