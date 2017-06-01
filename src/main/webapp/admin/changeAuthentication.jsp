<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
<%
String id = request.getParameter("id");
 %>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
-->
</style>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">教员管理</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td height="71" valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="13" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="left_txt">当前位置：教员注册审核管理</td>
          </tr>
          <tr>
            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              <tr>
                <td></td>
              </tr>
            </table></td>
          </tr>
          
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;升级VIP</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" action="updateTeacher.do?flag=2&&id=<%=id %>">
             <tr>
                <td width="16%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">请选择会员类型：</td>
                <td width="4%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="80%" height="30" bgcolor="#f2f2f2">
                 <select name="authentication" id="authentication">
                    <option value="已认证">审核通过</option>
               		<option value="未通过">审核未通过</option>
                  </select>
                  <span class="left_txt2">（输入正整数）</span></td>
                
              </tr>
              
               <tr>
                 <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
                 <td bgcolor="#f2f2f2">&nbsp;</td>
                 <td height="30" bgcolor="#f2f2f2"><input type="submit" value="提交" name="B1" />&nbsp;&nbsp;&nbsp;
                   <input type="reset" value="取消" name="B12" />
                   </td>
                 
               </tr>
            
              <tr>
                <td height="30" colspan="4" align="right" class="left_txt2"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                  
                </table>
                </td>
              </tr>

            </table></td>
          </tr>
        </table>
          </td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
      <td height="17" valign="top" background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17" /></td>
    <td background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>

</body>
