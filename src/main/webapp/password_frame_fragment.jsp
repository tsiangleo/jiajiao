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

<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">
       <br>
            <form name="user_form" method="post" action="updateMember.do?flag=3" >
            
               <table cellpadding="1" cellspacing="1"  border="0"class="mberTab">
                <tbody><tr>
                  <th  colspan="4"><strong>修改密码</strong></th>
                </tr>
           
                 <tr>
	              <td height="40" width="50%" align="right" style="font-size:12px;line-height:160%;">输入原密码：</td>
	              <td height="40" width="50%"colspan="2" align="left" style="font-size:12px;line-height:160%;">
	              	<input type="password" name="oldpassword" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;">
	              </td>
	           </tr>
                
                <tr>
	              <td height="40" width="50%" align="right" style="font-size:12px;line-height:160%;">输入新密码：</td>
	              <td height="40" width="50%"colspan="2" align="left" style="font-size:12px;line-height:160%;">
	              	<input type="password" name="newpassword" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;">
	              </td>
	           </tr>
	           
	           <tr>
	              <td height="40" width="50%" align="right" style="font-size:12px;line-height:160%;">确认新密码：</td>
	              <td height="40" width="50%"colspan="2" align="left" style="font-size:12px;line-height:160%;">
	              	<input type="password" name="newpassword2" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;">
	              </td>
	           </tr>
               <tr>
                  <td align="right">&nbsp;</td>
                  <td class="green"><span style="font-size:12px;line-height:160%;">
                    <input name="imageField" type="image" src="./images/tijiao.png" width="80" height="30" border="0" />
                    </span>
                 </td>
              </tr>
                         
              </tbody>
              </table>
           </form>
              
        </div>
    
    </td>
  </tr>
</table>
        
</body></html>