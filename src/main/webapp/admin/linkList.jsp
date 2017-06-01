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

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<body>


<% ArrayList<Link> linkList = (ArrayList<Link>)request.getAttribute("linkList");	
%>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">链接管理</div></td>
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
            <td class="left_txt">当前位置：链接管理</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;链接列表</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" action="admintitlechk.asp">
                <tr>
                  <td width="14%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>链接编号</strong></td>
                <td width="25%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>站点名称</strong></td>
                <td width="26%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>站点地址</strong></td>
                <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>站点其它信息</strong></td>
                <td width="16%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>操作</strong></td>
              </tr>
            <%for(int i = 0;i<linkList.size();i++) 
            {%>
              <tr>
               <td width="14%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=linkList.get(i).getId() %></td>
                <td width="25%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=linkList.get(i).getName() %></td>
                <td width="26%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=linkList.get(i).getUrl() %></td>
                <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=linkList.get(i).getInfo() %></td>
                <td width="16%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                	<a href="deleteLink.do?id=<%=linkList.get(i).getId() %>" onclick='return confirm("确定要删除吗?")'>删除</a>&nbsp;&nbsp;
                	<a href="updateLink.do?step=1&&id=<%=linkList.get(i).getId() %>">更新</a>
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
