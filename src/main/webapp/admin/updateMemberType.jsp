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

<% MemberType membertype = (MemberType)request.getAttribute("membertype");	

%>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">会员组管理</div></td>
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
            <td class="left_txt">当前位置：更新会员组</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;更新会员组</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" action="updateMemberType.do?step=2&&id=<%=membertype.getId() %>">
              <tr>
                <td width="16%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">会员组名称：</td>
                <td width="4%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="80%" height="30" bgcolor="#f2f2f2"><input name="typename" value="<%=membertype.getTypename() %>" type="text" id="typename" size="30" /></td>
                
              </tr>
              
              <tr>
                <td width="16%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">会员组排序：</td>
                <td width="4%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="80%" height="30" bgcolor="#f2f2f2"><input name="sort" value="<%=membertype.getSort() %>" type="text" id="sort" size="30" /></td>
                
              </tr>
              
              <tr>
                <td height="30" align="right" class="left_txt2">账户充值时的折扣：</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" value="<%=membertype.getDiscount() %>"name="discount" size="30" id="discount" />
                  <span class="left_txt2">（如8折则输入0.8；不打折则输入0）</span></td>
                
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">每次查看电话消耗的金币数：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" value="<%=membertype.getMoneypt() %>" name="moneypt" size="30" id="moneypt" />                  <span class="left_txt2">（如2）</span></td>
               
              </tr>
           
            <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">购买会员所需费用：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" value="<%=membertype.getExpense() %>" name="expense" size="30" id="expense" />
                  <span class="left_txt2">（单位：元）</span></td>
               
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">会员有效期：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" value="<%=membertype.getValidperiod() %>"  name="validperiod" size="30" id="validperiod" />
                  <span class="left_txt2">（单位：天）</span></td>
               
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
