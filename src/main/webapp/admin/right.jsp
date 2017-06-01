<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<%@ page import="java.lang.management.ManagementFactory" %>
<%@ page import="com.sun.management.OperatingSystemMXBean" %>
<%@ page import="java.util.Properties" %>

<%
 Properties props=System.getProperties(); //系统属性
 OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
 Administrator administrator = (Administrator)session.getAttribute("administrator");

 %>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">欢迎界面</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">
    
    </td>
    <td>
    
    
    
      <TABLE class=main_tab id=mainTable cellSpacing=0
cellPadding=0 width=100% border=0>
        <!--关于TBODY标记-->
        <TBODY >
            <th><span class="left_ts">【欢迎页】</span></th>
              <TR>
                <TD vAlign=top align=middle><TABLE width=98% height="64" border=0 align="center" cellPadding=0 cellSpacing=0>
                  <TBODY>
                    <TR>
                      <TD height="5" colspan="3"></TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD height="25" bgcolor="#FAFBFC"><span class="left_txt"><%=administrator.getUsername() %>,您好！欢迎使用家教网后台管理系统！</span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD width="32%" bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="63%" height="25" bgcolor="#FAFBFC"><span class="left_txt">已用内存：<%=(osmb.getTotalPhysicalMemorySize() - osmb.getFreePhysicalMemorySize()) / 1024 / 1024 %>MB&nbsp;&nbsp;&nbsp;&nbsp;剩余内存：<%=osmb.getFreePhysicalMemorySize() / 1024/1024 %>MB&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最大内存：<%=osmb.getTotalPhysicalMemorySize() / 1024/1024 %>MB</span></TD>
                      <TD width="5%" height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD width="32%" bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="63%" height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="5%" height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD height="5" colspan="3"></TD>
                    </TR>
                  </TBODY>
                </TABLE></TD>
              </TR>
  </TBODY>
  
  <TBODY >
        <th><span class="left_ts">【服务器信息】</span></th>
              <TR>
                <TD vAlign=top align=middle><TABLE width=98% height="133" border=0 align="center" cellPadding=0 cellSpacing=0>
                  <TBODY>
                    <TR>
                      <TD height="5" colspan="3"></TD>
                    </TR>
                    <TR>
                      <TD width="31%" bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="66%" height="25" bgcolor="#FAFBFC"><span class="left_txt">服务器的站点名称：<%=request.getServerName() %></span></TD>
                      <TD width="3%" height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="66%" bgcolor="#FAFBFC"><span class="left_txt">服务器<span class="TableRow2">ＩＰ</span>：<%=request.getLocalAddr() %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">操作系统：<%=props.getProperty("os.name") %>&nbsp;<%=props.getProperty("os.version") %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">服务器端口：<%=request.getServerPort() %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD width="66%" bgcolor="#FAFBFC"><span class="left_txt">服务器的名称和版本：<%=this.getServletContext().getServerInfo() %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">JAVA运行环境：<%=props.getProperty("java.specification.name") %>&nbsp;<%=props.getProperty("java.specification.version") %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">JAVA虚拟机：<%=props.getProperty("java.vm.name") %>&nbsp;<%=props.getProperty("java.vm.version") %> </span> <span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                     <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">服务器的Servlet主版本号：<%=this.getServletContext().getMajorVersion() %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>      
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD bgcolor="#FAFBFC"><span class="left_txt">服务器的Servlet次版本号：<%=this.getServletContext().getMinorVersion() %></span><span class="left_ts"> </span></TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                      <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
                    </TR>
                    <TR>
                      <TD height="5" colspan="3"></TD>
                    </TR>
                  </TBODY>
                </TABLE></TD>
              </TR>
  </TBODY>
  
  <!--关于tBodies集合-->
  <TBODY >
  <th><span class="left_ts">【本地浏览器信息】</span></th>
  <TR>
    <TD vAlign=top align=middle><TABLE width=98% border=0 align="center" cellPadding=0 cellSpacing=0>
      <TBODY>
        <TR>
          <TD colspan="3"></TD>
        </TR>
        <TR>
          <TD height="5" colspan="3"></TD>
        </TR>
        
        <TR>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD width="67%" height="25" bgcolor="#FAFBFC"><span class="left_txt"><span class="TableRow2">浏览器信息：<%=request.getHeader("user-agent") %></span>：</span></TD>
          <TD width="2%" height="25" bgcolor="#FAFBFC">&nbsp;</TD>
        </TR>
        <TR>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD width="67%" bgcolor="#FAFBFC"><span class="left_txt"><span class="TableRow2">客户端ＩＰ：<%=request.getRemoteAddr() %></span>：</span></TD>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
        </TR>
        <TR>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD bgcolor="#FAFBFC"><span class="left_txt">客户端主机名：<%=request.getRemoteHost() %></span></TD>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
        </TR>
        <TR>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD bgcolor="#FAFBFC"><span class="left_txt">语言：<%=request.getHeader("accept-language") %></span></TD>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
        </TR>
        <TR>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
          <TD height="25" bgcolor="#FAFBFC">&nbsp;</TD>
        </TR>
        <TR>
          <TD height="5" colspan="3"></TD>
        </TR>
      </TBODY>
    </TABLE></TD>
  </TR>
  </TBODY>
    </TABLE></td>
    <td></td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><!--JavaScript部分-->
      <SCRIPT language=javascript>
function secBoard(n)
{
for(i=0;i<secTable.cells.length;i++)
secTable.cells[i].className="sec1";
secTable.cells[n].className="sec2";
for(i=0;i<mainTable.tBodies.length;i++)
mainTable.tBodies[i].style.display="none";
mainTable.tBodies[n].style.display="block";
}
          </SCRIPT></td>
  </tr>
</table>
</body>
