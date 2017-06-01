<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>
<div class="content_wraper">
<!-- 以下为主体 -->
  

  <%
    String photo = (String)session.getAttribute("photo");
    Member member = (Member)session.getAttribute("member");
	String username = member.getUsername();
	String role = member.getRole();
	Long memberid = member.getId();
	
%> 
<table width="1000"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#BCDFFF" bgcolor="#FFFFFF">
  <tr >
    <td width="20%" valign="top"><table width="100%" border="1" bordercolor="#FFFFFF" cellspacing="1" cellpadding="1">
      <tr>
        <td  height="180" align="center" valign="top" bordercolor="#BCDFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="1"  bordercolor="#FFFFFF">
          <tr>
            <td  height="20"  background="images/columbg.png" align="center" valign="top" bordercolor="#BCDFFF"><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">您的资料</font></td>
          </tr>
          <%if(role.equals("教员")) 
          {	
          %>
          <tr>
            
	          <td align="center"><img  width="120" height="130"  src="<%=photo %>"/></td>
	        
          </tr>
       <%} %>
          <tr>
            <td ><table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td  align="right"><img src="images/lq04.gif" width="16" height="16" />&nbsp;用&nbsp;户&nbsp;名:</td>
                  <td  align="left"><%=username %></td>
                </tr>
                <tr>
                  <td  align="right"><img src="images/lq05.gif" width="16" height="16" />&nbsp;角&nbsp;&nbsp;&nbsp;&nbsp;色:</td>
                  <td  align="left"><%=role %></td>
                </tr>
                <tr>
                  <td  align="right"><img src="images/lq06.gif" width="16" height="16" />&nbsp;会&nbsp;员&nbsp;ID:</td>
                  <td  align="left"><%=memberid %></td>
                </tr>
                <tr>
                  <td  align="right"><img src="images/lq07.gif" width="16" height="16" />&nbsp;会员类别:</td>
                  <td  align="left"><%=member.getType() %></td>
                </tr>
                <tr>
                  <td  align="right"><img src="images/lq08.gif" width="16" height="16" />&nbsp;账户余额:</td>
                  <td  align="left"><font color="#FF0000"><%=member.getBalance() %>个金币</font></td>
                </tr>
                
              </table></td>
          </tr>
        </table></td>
      </tr>
      
      <tr>
        <td height="5" align="center" >&nbsp;&nbsp;</td>
      </tr>
      
      <tr>
        <td  height="400" align="center" valign="top" bordercolor="#BCDFFF">
        
        <table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">
         
          <tr>
            <td align="center"  background="images/columbg.png"><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">账户信息管理</font></td>
          </tr>      
          <tr>
            <td align="center"><a href="updateMember.do?flag=1" target="mainiframe">邮箱设置</a></td>
          </tr>
          <tr>
            <td align="center"><a href="password_frame_fragment.jsp" target="mainiframe">修改密码</a></td>
          </tr> 
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          
          <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">会员增值服务</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="membertypeIntroduce.html" target="mainiframe">会员升级</a></td>
          </tr>
          <tr>
            <td align="center"><a href="sortApply.html" target="mainiframe">优先展示</a></td>
          </tr>
          <tr>
            <td align="center"><a href="addBalanceApply.html" target="mainiframe">账户充值</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          <% if(role.equals("学员"))
          	{
           %>
          
         <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">需求信息管理</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="queryRequirementList.do" target="mainiframe">查询我发布的需求信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryRequirementList.do" target="mainiframe">修改需求信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryStudentList.do?flag=2" target="mainiframe">发布新的需求信息</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          
          <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">学员信息管理</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="addStudent_frame_fragment.jsp" target="mainiframe">添加常用学员信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryStudentList.do?flag=1" target="mainiframe">修改学员信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryStudentList.do?flag=1" target="mainiframe">查看学员信息</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">收藏夹</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="collection.do?flag=2" target="mainiframe">查看我收藏的教员</a></td>
          </tr>
          <tr>
            <td align="center"><a href="collection.do?flag=2" target="mainiframe">移除收藏夹</a></td>
          </tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          
    	<%}
    	
    	if(role.equals("教员"))
    	{
    	 %>
    	 <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">教员信息管理</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="addTeacher_frame_fragment.jsp" target="mainiframe">新建我的个人信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryAndUpdateTeacher.do?flag=2" target="mainiframe">修改我的个人信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="queryAndUpdateTeacher.do?flag=1" target="mainiframe">查看我的个人信息</a></td>
          </tr>
          <tr>
            <td align="center"><a href="addCertificate_frame_fragment.jsp" target="mainiframe">进行身份认证</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          
          <tr>
            <td align="center"  background="images/columbg.png""><font color="#FFFFFF"  face="微软雅黑" style="font-size:15px">评价管理</font></td>
          </tr>    
          <tr>
            <td align="center"><a href="evaluation.do?flag=2" target="mainiframe">学员对我的评价</a></td>
          </tr>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
    <%} %>
        </table>
        </td>
      </tr>
    </table></td>
    <td width="1%">&nbsp;</td>
    <td width="79%" align="center" valign="top"  bordercolor="#BCDFFF">
    <%
    String defaut = null;
    String s = request.getParameter("fromsuccess"); 
    if(s != null && s.equals("1"))
    	defaut = "queryRequirementList.do";
    else
    	defaut = "memberCenter_default_fragment.jsp";

    %>
    <iframe name="mainiframe"scrolling="no" frameborder=0 height = "900" width = "100%" src="<%=defaut %>"></iframe>
    </td>
  </tr>
</table>
  
  
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>