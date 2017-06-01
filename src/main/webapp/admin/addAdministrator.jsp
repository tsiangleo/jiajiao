<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <td height="31"><div class="titlebt">添加管理员</div></td>
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
            <td class="left_txt">当前位置：添加管理员</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;添加管理员</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><form name="form1" method="post" action="administrator.do?flag=1">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td width="25%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">用户名：</td>
    <td width="2%" bgcolor="#f2f2f2">&nbsp;</td>
    <td width="73%" height="30" bgcolor="#f2f2f2"><input name="username" type="text" id="username" size="30" /></td>
  </tr>
  <tr>
    <td width="25%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">密码：</td>
    <td width="2%" bgcolor="#f2f2f2">&nbsp;</td>
    <td width="73%" height="30" bgcolor="#f2f2f2"><input name="password" type="text" id="password" size="30" /></td>
  </tr>
  <tr>
    <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">真实姓名：</td>
    <td bgcolor="#f2f2f2">&nbsp;</td>
    <td height="30" bgcolor="#f2f2f2"><input name="realname" type="text" id="realname" size="30" /></td>
  </tr>
  <tr>
    <td width="25%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">性别：</td>
    <td width="2%" bgcolor="#f2f2f2">&nbsp;</td>
    <td width="73%" height="30" bgcolor="#f2f2f2">
        <input type="radio" name="gender" value="男" id="gender_0">男
      <input type="radio" name="gender" value="女" id="gender_1">女
      </td>
  </tr>
  <tr>
    <td width="25%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">联系电话：</td>
    <td width="2%" bgcolor="#f2f2f2">&nbsp;</td>
    <td width="73%" height="30" bgcolor="#f2f2f2"><input name="phone" type="text" id="phone" size="30" /></td>
  </tr>
  <tr>
    <td width="25%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">角色：</td>
    <td width="2%" bgcolor="#f2f2f2">&nbsp;</td>
    <td width="73%" height="30" bgcolor="#f2f2f2"><label for="role"></label>
      <select name="role" id="role">
        <option value="普通管理员">普通管理员</option>
        <option value="超级管理员">超级管理员</option>
      </select></td>
  </tr>
  <tr>
    <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
    <td bgcolor="#f2f2f2">&nbsp;</td>
    <td height="30" bgcolor="#f2f2f2"><input type="submit" value="添加" name="B1" />
      &nbsp;&nbsp;&nbsp;
      <input type="reset" value="取消" name="B12" /></td>
  </tr>
  <tr>
    <td height="30" colspan="4" align="right" class="left_txt2"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
    </table></td>
  </tr>
              </table>
            </form></td>
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
 