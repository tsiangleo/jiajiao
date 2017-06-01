<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>

<% ArrayList<AdminLogging> adminloggingList = (ArrayList<AdminLogging>)request.getAttribute("adminloggingList");	
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

<SCRIPT LANGUAGE="JavaScript">    
function checkAll(str)    
{    
    var a = document.getElementsByName(str);    
    var n = a.length;    
    for (var i=0; i<n; i++)    
    a[i].checked = window.event.srcElement.checked;    
}    
function checkItem(str)    
{    
    var e = window.event.srcElement;    
    var all = eval("document.all."+ str);    
    if (e.checked)    
    {    
        var a = document.getElementsByName(e.name);    
        all.checked = true;    
        for (var i=0; i<a.length; i++)    
        {    
            if (!a[i].checked)   
            {    
                all.checked = false; break;   
            }    
        }   
    }    
    else    
        all.checked = false;    
}   
</SCRIPT>   
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">登陆日志</div></td>
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
            <td class="left_txt">当前位置：登陆日志</td>
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
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left"><form name="form1" method="post" action="adminLogging.do?flag=2">
                  <span class="left_txt">
                  用户名：
                  <input name="username" type="text" id="username" size="15" />
<label for="role"></label>
&nbsp;&nbsp;</span>
                  <input type="submit" name="button" id="button" value="搜索">
                </form></td>
                  <td align="right"><span class="left_txt">&nbsp;&nbsp;</span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;登陆日志列表</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="1">
              <tr >
                <td width="6%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                <table  border="1" bordercolor="#CCCCCC" width="100%"  cellspacing="0" cellpadding="0">
                  <form name="form1" method="POST" action="admintitlechk.asp">
                    <tr>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><input type="checkbox" name="All"onClick="checkAll('mm')" id="CheckboxGroup1_"></td>
                      <td width="11%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>ID</strong></td>
                      <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>用户名</strong></td>
                      <td width="21%" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>登陆时间</strong></td>
                      <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>登陆IP</strong></td>
                      <td width="17%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>结果</strong></td>
                      <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>操作</strong></td>
                    </tr>
                    <%for(int i = 0;i<adminloggingList.size();i++) 
                    {%>
                    <tr>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><input type="checkbox" name="mm" onClick="checkItem('All')" value="id取值"id="CheckboxGroup1_0"></td>
                      <td width="11%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=adminloggingList.get(i).getId() %></td>
                      <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=adminloggingList.get(i).getUsername() %></td>
                      <td width="21%" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=adminloggingList.get(i).getLogintime() %></td>
                      <td width="19%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=adminloggingList.get(i).getLoginip() %></td>
                      <td width="17%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=adminloggingList.get(i).getResult() %></td>
                      <td width="12%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                      
                      <a href="adminLogging.do?flag=3&&id=<%=adminloggingList.get(i).getId() %>" onclick='return confirm("确定要删除这条记录吗")'>删除</a>
                     	
                     </td>
                    </tr>
                    <%} %>

                  </form>
                </table></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                <td  width="9%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><span class="left_txt"><a href="#">删除选中的</a></span></td>
                  
                <td width="91%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">&nbsp;共有<strong>&nbsp;243</strong>&nbsp;条记录，当前第<strong>&nbsp;1</strong>&nbsp;页，共&nbsp;<strong>10</strong>&nbsp;页 上一页 下一页 首页 末页</td>
                
              </tr>
            
              

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
