<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>
<div class="content_wraper">
<!---------------------------------------------------------------导航与主体分割线------------------------------------------------------------------------------->


</style><script language="javascript">

function onfocus_check(id) { id.style.border='2px #FF0000 solid'; }
function onblur_check(id) { id.style.border='1px #6CB5FF solid'; }

function user_form_check() {
if (user_form.username.value=='') { alert('请输入用户名!'); user_form.username.focus(); return false; }
check_value='abcdefghijklmnopqrstuvwxyz0123456789_';
username_length=user_form.username.value.length;
for(i=1;i<=username_length;i++) {
if (check_value.indexOf(user_form.username.value.charAt(i))==-1) { alert('用户名只能输入字母、数字、下划线!'); user_form.username.focus(); return false; } }
if (username_length<4 || username_length>20) { alert('用户名的长度在4-20之间!'); user_form.username.focus(); return false; }
if (user_form.password.value=='') { alert('请输入密码!'); user_form.password.focus(); return false; }
if (user_form.password_1.value=='') { alert('请再次输入密码!'); user_form.password_1.focus(); return false; }
if (user_form.password.value!=user_form.password_1.value) { alert('两次输入密码必须相同!'); user_form.password_1.focus(); return false; }
if (user_form.email.value=='') { alert('请输入电子邮箱!'); user_form.email.focus(); return false; }
var filter=/^\s*([A-Za-z0-9_-]+(\.\w+)*@(\w+\.)+\w{2,3})\s*$/;
if (!filter.test(document.user_form.email.value)) { alert('请输入正确的电子邮箱格式!'); user_form.email.focus(); return false; }
if (user_form.role.value=='') { alert('请选择角色!'); user_form.role.focus(); return false; }
if (user_form.phone.value=='') { alert('请输入移动电话!'); user_form.phone.focus(); return false; }
if (isNaN(user_form.phone.value)) { alert('移动电话必须为数字!'); user_form.phone.focus(); return false; }
if (user_form.phone.value.length<11 || user_form.phone.value.length>11) { alert('请输入正确的移动电话号码!'); user_form.phone.focus(); return false; }
//if (user_form.code.value=='') { alert('请输入验证码!'); user_form.code.focus(); return false; }
}
</script>




        <form name="user_form" method="post" action="regist.do" onsubmit="return user_form_check()" >
        <table align="center" bgcolor="#FFFFFF" width="1000" border="0" cellpadding="0" cellspacing="0" style="border:1px #BCDFFF solid;">
            <tbody><tr>
              <td height="30" colspan="4" align="left" background="images/sort_top.jpg"><table width="960" border="0" cellpadding="0" cellspacing="0">
                  <tbody><tr><td width="120" align="left" style="font-size:20px;color:#FF6600;font-weight:bold;">　家教注册</td>
                    <td width="850" style="font-size:12px;">请认真填写您的真实有效的信息，否则本站无法通过您的身份认证。（温馨提示：带 <font color="#FF0000">*</font> 号的为必填项）</td>
                  </tr>
              </tbody></table></td>
            </tr>
            
       
            <tr height="20"></tr>
              
   			<tr>
   				<td height="40" align="left" style="font-size:12px;line-height:160%;"> </td>
             	<td height="40" colspan="2" align="left" style="font-size:18px;line-height:160%;">
             		 <font color="#FF0000"> 
	                <%
						String registMsg = (String)request.getAttribute("registMsg");
						if(registMsg != null)
							out.println(registMsg);
	 				%>        		
	 				</font>
             	</td>
                <td height="40" align="left" style="font-size:12px;line-height:160%;"></td>
            </tr>
            
           <input name="role" type="hidden" value="教员">
            
            <tr>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font> 用 户 名：              </td>
              <td height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;"><input type="text" name="username" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);"></td>
              <td height="40" align="left" style="font-size:12px;line-height:160%;"><font color="#FF0000">（只能输入字母，数字，下划线，长度在4-20之间）</font></td>
            </tr>
            
            <tr>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font> 密　　码：
              </td>
              <td height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;"><input name="password" type="password" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(password);" onblur="javascript:onblur_check(password);"></td>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
            
            <tr>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font> 确定密码：
              </td>
              <td height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;"><input name="password_1" type="password" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(password_1);" onblur="javascript:onblur_check(password_1);"></td>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
                        
            <tr>			
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font> 电子邮箱：
                </td>
              <td height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;"><input name="email" type="text" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(email);" onblur="javascript:onblur_check(email);"></td>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
              
         
            <tr>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font> 您的电话：                </td>
              <td height="40" colspan="2" align="left" style="font-size:12px;line-height:160%;"><input name="phone" type="text" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(phone);" onblur="javascript:onblur_check(phone);"></td>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
            
            <tr>
              <td height="40" align="left" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<label for="code"><font color="#FF0000">*</font> 验 证 码：</label>              </td>
              
              <!--  以下两对TD是生成验证码的-->
              <td width="60" height="40" align="left" style="font-size:12px;line-height:160%;"><input type="text" name="code" id="textfield" style="width:40px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(code);" onblur="javascript:onblur_check(code);"></td>
              <td width="160" align="left" style="font-size:12px;line-height:160%;"><a href="javascript:location.reload();" ><img  id="imgcode" src="image.jsp" alt="验证码" border="0">换一张</a></td>      
               
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
            <tr>
              <td height="80" colspan="4" align="center" style="font-size:12px;line-height:160%;"><input name="imageField" type="image" src="./images/regist.png" width="80" height="30" border="0"></td>
            </tr>			
			</tbody></table>
        </form>  
         
       </div> 
</body>
<jsp:include page="foot.jsp" flush="true" />
</html>
