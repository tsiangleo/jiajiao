<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<%
Sysinfo footsysinfo = (Sysinfo)application.getAttribute("sysinfo");
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
   
<!-------------------------------------------------------------底部与主体分割线------------------------------------------------------------------------------->
<div id="footer">
    <div class="footer_links">
        <a href="#">首页</a> │ <a href="#">教育资讯</a> │ <a href="#">同步试题</a>
        │ <a href="#">关于我们</a> │ <a href="#">联系我们</a> │ <a href="#">
            教员必读</a> │ <a href="#">学员必读</a> │ <a href="#">法律声明</a> │ <a href="admin/login.jsp" target="_blank">后台管理</a>
    </div>
    
    <div class="footcontent">
       <center>
      <%if(footsysinfo != null)
      { %>
           <%=footsysinfo.getICP() %>&nbsp; 客服QQ：<%=footsysinfo.getServiceqq() %> &nbsp; 联系我们：<%=footsysinfo.getAdminemail() %>
            <br>
           <%=footsysinfo.getCopyright() %>
            
   <%} %>
        </center>
        <div class="clearThis">
        </div>
    </div>
    
</div>

  </body>
</html>
