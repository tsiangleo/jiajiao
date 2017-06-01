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


%> 
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">

               <table cellpadding="1" cellspacing="1" border="0" class="mberTab">
                <tbody><tr>
                  <th colspan="4">来自学员的评价： </th>
                </tr>
        <tr align="center">
                  <td ><strong>总体评价</strong></td>
                  <td ><strong>评价内容</strong></td>
                  <td ><strong>评价时间</strong></td>
                  <td ><strong>评价者</strong></td>
                  <td ><strong>教员回复</strong></td>
     			 </tr>            
                   
<%  List<Evaluation> evaluationlist = ( List<Evaluation>)request.getAttribute("evaluationlist"); 
if(evaluationlist != null)
{
	for(int i = 0;i<evaluationlist.size();i++)
	{
	%>
                
                <tr>
                 <td ><%=evaluationlist.get(i).getTotalevaluation() %></td>
                  <td ><%=evaluationlist.get(i).getContent() %></td>
                   <td ><%=evaluationlist.get(i).getTime() %></td>
                    <td ><%=evaluationlist.get(i).getAuthor() %></td>
                     <td ><%=evaluationlist.get(i).getReply() %></td>
      			</tr>
    <%}
} %>       
      			</tbody>
                </table>
      
        </div>
    
    </td>
  </tr>
</table>
        
</body></html>