<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
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

<% ArrayList<Teacher> teachers = (ArrayList<Teacher>)request.getAttribute("teachers");

%>
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
            <td class="left_txt">当前位置：教员认证</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;待认证教员列表</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" action="admintitlechk.asp">
                <tr>
                  <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>教员编号</strong></td>
                <td width="9%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>教员姓名</strong></td>
                <td width="11%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>电话</strong></td>
                <td width="15%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>学校</strong></td>
                <td width="15%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>专业</strong></td>
                <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>学历</strong></td>
                <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>认证状态</strong></td>
                <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>操作</strong></td>
              </tr>
            <%for(int i = 0;i<teachers.size();i++)
            {
             %>
              <tr>
               <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getId() %></td>
                <td width="9%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getTeachername() %></td>
                <td width="11%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getMobilephone() %></td>
                <td width="15%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getSchool() %></td>
                <td width="15%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getSpecialty() %></td>
                
                <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getDegree() %> </td>
                <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=teachers.get(i).getAuthentication() %></td>
                <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                	<a href="queryCertificate.do?id=<%=teachers.get(i).getId() %>">查看证件</a>&nbsp;&nbsp;&nbsp;
                	<a href="changeAuthentication.jsp?id=<%=teachers.get(i).getId() %>">修改认证状态</a>
                </td>
  			</tr>
		<%} %>
            </table>
            </td>
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
