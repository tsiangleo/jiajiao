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
  
<table width="1000" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">
              
                <%
                Member member2 = (Member)session.getAttribute("member");
				String username = member2.getUsername();
				String role = member2.getRole();
              	
               %>
               <table height="243" background="images/registsuccess.png" width="1000"cellpadding="1" cellspacing="1"  border="0">
			  <tr>
			    <td height="80">&nbsp;</td>
			  </tr>
			  <tr>
			    <td height="80">&nbsp;</td>
			  </tr>
			   <% if(role.equals("教员")) {%>
               <tr>
                   <td height="93" align="center"><font style="font-family:黑体; font-size:16px; color:#000">您可以去填写家教信息，方便家长联系您，<a href="addTeacher.jsp"><font color="#FF0000">立即填写</font></a>！</font></td>        
                </tr>
                
                <% }
                if(role.equals("学员")) {%>
                 <tr>
                   <td height="93" align="center"><font style="font-family:黑体; font-size:16px; color:#000">您可以去发布需求信息，方便教师联系您，<a href="addRequirement.jsp"><font  color="#FF0000">立即发布</font></a>！</font></td>        
                </tr>
                <%} %>
             </table>
             
 		</div>
    
    </td>
  </tr>
</table>
  
  
  
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>