<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>
<div class="content_wraper">
<!-- 以下为主体 -->
  
<script language="javascript">
function onfocus_check(id) { id.style.border='2px #FF0000 solid'; }
function onblur_check(id) { id.style.border='1px #6CB5FF solid'; }

function user_form1_check() 
{
	if (user_form1.username.value=='') 
	{ 
		alert('请输入用户名!'); user_form1.username.focus(); return false;
	}

	check_value='abcdefghijklmnopqrstuvwxyz0123456789_';//用户检测用户输入的用户名是否是这些字符
	username_length=user_form1.username.value.length;
	
	for(i=1;i<=username_length;i++)
	{
		if (check_value.indexOf(user_form1.username.value.charAt(i))==-1) 
			{ alert('用户名只能输入字母、数字、下划线!'); user_form1.username.focus(); return false; } 
	}
	
	if (username_length<4 || username_length>20) 
		{ alert('用户名的长度在4-20之间!'); user_form1.username.focus(); return false; }

	if (user_form1.password.value=='')
		{ alert('请输入密码!'); user_form1.password.focus(); return false; }
	
//	if (user_form1.code.value=='')
	//	{ alert('请输入验证码!'); user_form1.code.focus(); return false; }
}


function user_form2_check() 
{
	if (user_form2.username.value=='') 
	{ 
		alert('请输入用户名!'); user_form2.username.focus(); return false;
	}

	check_value='abcdefghijklmnopqrstuvwxyz0123456789_';//用户检测用户输入的用户名是否是这些字符
	username_length=user_form2.username.value.length;
	
	for(i=1;i<=username_length;i++)
	{
		if (check_value.indexOf(user_form2.username.value.charAt(i))==-1) 
			{ alert('用户名只能输入字母、数字、下划线!'); user_form2.username.focus(); return false; } 
	}
	
	if (username_length<4 || username_length>20) 
		{ alert('用户名的长度在4-20之间!'); user_form2.username.focus(); return false; }
	
	if (user_form2.password.value=='')
		{ alert('请输入密码!'); user_form2.password.focus(); return false; }
	
	//if (user_form2.code.value=='')
	//	{ alert('请输入验证码!'); user_form2.code.focus(); return false; }
}

</script>

<table width="1000" align="center" bgcolor="#FFFFFF" border="0">

  <tbody><tr>
    <td width="47%"><fieldset class="fieldset1">
    <legend class="legendtitle">教师登录</legend>
<form id="user_form1" name="user_form1" method="post" action="login.do?role=teacher" onsubmit="return user_form1_check()" >
        <table   bgcolor="#FFFFFF" align="center" border="0" cellpadding="0" cellspacing="0" >
            <tbody>
                    <font color="#FF0000"> 
	               <center> <%
						String teacherloginMsg = (String)request.getAttribute("teacherloginMsg");
						if(teacherloginMsg != null)
							out.println(teacherloginMsg);
	 				%>    
	 				</center>    		
	 				</font>
            <tr>
              <td width="30%"  height="40" align="right">用 户 名:</td>
              <td width="70%" height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;">
              <input type="text" name="username" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);"></td>             
            </tr>
            
            <tr>
              <td width="30%" height="40" align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
              <td width="70%" height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;">
              <input name="password" type="password" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(password);" onblur="javascript:onblur_check(password);"></td>
       		</tr>
                 
            
            <tr>
              <td  height="40" align="right">验 证 码:</td>   
              <!--  以下两对TD是生成验证码的-->
              <td width="60" height="40" align="left" style="font-size:12px;line-height:160%;"><input type="text" name="code" id="textfield" style="width:40px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(code);" onblur="javascript:onblur_check(code);"></td>
              <td width="160" align="left" style="font-size:12px;line-height:160%;"><a href="javascript:location.reload();"><img  id="imgcode" src="image.jsp" alt="验证码" border="0">换一张</a></td>      
            </tr>
            
            <tr>
              <td height="80" colspan="4" align="center" style="font-size:12px;line-height:160%;"><input name="imageField" type="image" src="./images/login.png" width="80" height="30" border="0"></td>
            </tr>			
			</tbody></table>
        </form>  
    </fieldset></td>
    <td width="4%">&nbsp;</td>
    <td width="49%"><fieldset class="fieldset1">
    <legend class="legendtitle">家长登录</legend>
    <form name="user_form2" id="user_form2" method="post" action="login.do?&&role=student" onsubmit="return user_form2_check()" >
        <table   bgcolor="#FFFFFF" align="center"  width="450" border="0" cellpadding="0" cellspacing="0" >
            <tbody>
               <font color="#FF0000"> 
	               <center> <%
						String stuloginMsg = (String)request.getAttribute("stuloginMsg");
						if(stuloginMsg != null)
							out.println(stuloginMsg);
	 				%>    
	 				</center>    		
	 				</font>
            <tr>
              <td width="30%"  height="40" align="right">用 户 名:</td>
              <td width="70%" height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;">
              <input type="text" name="username" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);"></td>             
            </tr>
            
            <tr>
              <td width="30%" height="40" align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
              <td width="70%" height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;">
              <input name="password" type="password" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(password);" onblur="javascript:onblur_check(password);"></td>
       		</tr>
                 
             <tr>
              <td  height="40" align="right">验 证 码:</td>   
              <!--  以下两对TD是生成验证码的-->
              <td width="60" height="40" align="left" style="font-size:12px;line-height:160%;"><input type="text" name="code" id="textfield" style="width:40px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(code);" onblur="javascript:onblur_check(code);"></td>
              <td width="160" align="left" style="font-size:12px;line-height:160%;"><a href="javascript:location.reload();" ><img  id="imgcode" src="image.jsp" alt="验证码" border="0">换一张</a></td>      
            </tr>        
            
            <tr>
              <td height="80" colspan="4" align="center" style="font-size:12px;line-height:160%;"><input name="imageField" type="image" src="./images/login.png" width="80" height="30" border="0"></td>
            </tr>			
			</tbody></table>
        </form>  
    </fieldset></td>
  </tr>
</tbody></table>
  
  
  
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>