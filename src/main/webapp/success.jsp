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
  <table bgcolor="#FFFFFF" width="1000" border="0">
  <tr>
    <td width="309" height="90">&nbsp;</td>
    <td width="99" background="images/ok.jpg" height="90">&nbsp;</td>
    <td width="576" height="90"><font style="font-family:黑体; font-size:28px; color:#F30">恭喜您，发布成功！</font></td>
  </tr>
  <tr>
    <td height="39">&nbsp;</td>
    <td>&nbsp;</td>
    <td height="40"><font style="font-family:黑体; font-size:14px"> 点击这里<a href="memberCenter.jsp?fromsuccess=1"><font color="#0099FF">查看信息详情</font></a></font></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
        <td height="40"><font style="font-family:黑体; font-size:14px">或者<a href="addRequirement.jsp" target="mainframe"><font color="#0099FF">继续发布信息</font></a></font></td>
  </tr>
</table>
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>