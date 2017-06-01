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
<% ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");	
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">会员管理</div></td>
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
            <td class="left_txt">当前位置：会员管理</td>
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
                <td align="left"><form name="form1" method="post" action="queryMember.do?flag=1">
                  <span class="left_txt">ID:
                  <input name="id" type="text" id="id" size="15" />
                  用户名：
<input name="username" type="text" id="username" size="15" />
角色：
<label for="role"></label>
<select name="role" id="role">
  <option value="不限">不限</option>
  <option value="教员">教员</option>
  <option value="学员">学员</option>
</select>
&nbsp;&nbsp;</span>
                  <input type="submit" name="button" id="button" value="搜索">
                </form></td>
                  <td align="right"><span class="left_txt">
                    
                  &nbsp;&nbsp;</span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;会员列表</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="1">
              <tr >
                <td width="6%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                <table  border="1" bordercolor="#CCCCCC" width="100%"  cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="2%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><input type="checkbox" name="All"onClick="checkAll('mm')" id="CheckboxGroup1_"></td>
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>ID</strong></td>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>用户名</strong></td>
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>角色</strong></td>
                      <td width="13%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>电子邮箱</strong></td>
                      <td width="5%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>账户余额</strong></td>
                      <td width="3%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>展示级别</strong></td>
                      <td width="10%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>联系电话</strong></td>
                      <td width="6%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>会员组</strong></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>注册时间</strong></td>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>注册IP</strong></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>VIP到期时间</strong></td>
                      
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>登陆次数</strong></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>最后登陆时间</strong></td>
                      <td width="3%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>黑名单</strong></td>
                      <td width="9%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong>操作</strong></td>
                    </tr>
             <%for(int i = 0; i < memberList.size(); i++) 
            {%>
                    <tr>
                      <td width="2%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><input type="checkbox" name="mm" onClick="checkItem('All')" value="id取值"id="CheckboxGroup1_0"></td>
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getId() %></td>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getUsername() %></td>
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getRole() %></td>
                      <td width="13%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getEmail() %></td>
                      <td width="5%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getBalance() %>元</td>
                      <td width="3%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getSearchrank() %></td>
                      <td width="10%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getPhone() %></td>
                      <td width="6%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getType() %></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getRegistdate() %></td>
                      <td width="8%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getRegistip() %></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getVIPdeadline() %></td>
                      
                      <td width="4%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getLogintimes() %></td>
                      <td width="7%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getLogintime() %></td>
                      <td width="3%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><%=memberList.get(i).getBlacklist() %></td>
                      <td width="9%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">
                      		<%if(memberList.get(i).getBlacklist().equals("否")) 
                      		{%>
                      		<a href="updateMember.do?flag=7&&id=<%=memberList.get(i).getId() %>" onclick='return confirm("确定要将该用户加入黑名单吗?")'>拉黑</a>&nbsp;&nbsp;
                     		<%} %>
                     		<%if(memberList.get(i).getBlacklist().equals("是")) 
                      		{%>
                      		<a href="updateMember.do?flag=8&&id=<%=memberList.get(i).getId() %>" onclick='return confirm("确定要解除吗")'>解除</a>&nbsp;&nbsp;
                     		<%} %>
                     		<a href="updateMember.do?flag=9&&id=<%=memberList.get(i).getId() %>" onclick='return confirm("确定要将密码重置为123456吗")'>重置密码</a>&nbsp;&nbsp;
                     		
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
