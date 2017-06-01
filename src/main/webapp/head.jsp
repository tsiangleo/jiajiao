<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<%
String headusername = null,headrole = null;
Member headmember = null;
headmember = (Member)session.getAttribute("member");
Sysinfo headsysinfo = (Sysinfo)application.getAttribute("sysinfo");
 %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=headsysinfo.getKeywords() %>">
	<meta http-equiv="description" content="<%=headsysinfo.getDescription() %>">
	
<title><%=headsysinfo == null? "重庆家教网":headsysinfo.getSitename() %></title>
<link href="css/global.css" rel="stylesheet" type="text/css">
<link href="css/index.css" rel="stylesheet" type="text/css">
<link href="css/inside.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
<link href="css/arc.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="style/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="style/DD_belatedPNG_0.0.7a.js"></script>
<script type="text/javascript" src="style/index.js"></script>
<script type="text/javascript" src="style/top.js"></script>

<style type="text/css">
.nav {
	MARGIN: 1px 0; 
	WIDTH: 100%; 
	FONT-FAMILY: verdana; 
	HEIGHT: 21px; 
	BACKGROUND-COLOR: #970B0B;
	font-family:Arial, Helvetica, sans-serif;
    font-size:12px;
}
.nav UL {
	PADDING: 0px; 
	DISPLAY: block; 
	MARGIN: 0px; 
	LIST-STYLE-TYPE: none; 
	HEIGHT: 49px; 
	BACKGROUND-COLOR: #9bcf00;	
	COLOR: #ffffff; 
}
.nav LI {
	BORDER-RIGHT: #ffffff 1px solid; 
	DISPLAY: block; 
	FLOAT: left; 
	HEIGHT: 41px;
	font-family:"微软雅黑", Helvetica, sans-serif;
    font-size:17px;
	margin-top:4px;
	text-align:center;
}
.nav LI A {
	
	DISPLAY: block; 
	FONT-WEIGHT: none; 
	COLOR: #ffffff; 
	LINE-HEIGHT: 16px; 
	TEXT-DECORATION: none;
	padding:14px;
}
.nav LI A:hover {
	COLOR:#562505; 
	BACKGROUND-COLOR: #f4f524; 
	TEXT-DECORATION: none;
}
.current{
  color:#ffffff;
  background:#666666;
}
.nav li#date{
  color:#ffffff;
  PADDING:2px 15px 0; 
}
</style>
<script language="javascript" type="text/javascript">
var  $c=function(array){var nArray = [];for (var i=0;i<array.length;i++) nArray.push(array[i]);return nArray;};
Array.prototype.each=function(func){
for(var i=0,l=this.length;i<l;i++) {func(this[i],i);};
};
document .getElementsByClassName=function(cn){
var hasClass=function(w,Name){
var hasClass = false;
w.className.split(' ').each(function(s){
if (s == Name) hasClass = true;
});
return hasClass;
}; 
var elems =document.getElementsByTagName("*")||document.all;
            var elemList = [];
           $c(elems).each(function(e){
if(hasClass(e,cn)){elemList.push(e);}
		   })
        return $c(elemList);
};		
function change_bg(obj){
var a=document.getElementsByClassName("nav")[0].getElementsByTagName("a");
for(var i=0;i<a.length;i++){a[i].className="";}
obj.className="current";
}
</script>

</head>


<body>

<div id="header">
  <div id="topbox">
    <div id="logo" class="transfpng"><a href="#"><img src="<%=headsysinfo.getSitelogo() %>" alt="<%=headsysinfo.getSitename() %>" width="298" height="93" /></a></div>
    <div class="shipin_recommand">
      <div class="shipin_recommand_words">
              
          
 	  <%if(headmember == null) 
 	   {%>
 	  	  <a href="regist_jz.jsp"><img src="images/lq01.png" width="102" height="25" /> </a>           
          <a href="regist_jj.jsp"><img src="images/lq02.png" width="102" height="25" /></a>
          <a href="login.jsp"><img src="images/lq03.png" width="80" height="24" /></a>
      <%}
      else
       {
       
       %> 
       <font style="font-family:黑体; font-size:16px; color:#000">
       
       	欢迎您，<img src="images/lq09.gif" width="16" height="16" /><font color="#ff0000"><%=headmember.getUsername() %></font>
       	，您是：<font color="#ff0000" ><%=headmember.getType() %></font>！
          &nbsp;<a href="logout.do">注销</a>
       </font>
     <%} %>
        </div>
    </div>
  </div><!-- topbox end -->
  
  <div id="topbox2">
   
    
      <div class="nav">
        <ul>
          <li><a href="index.do" onclick="change_bg(this)">首页</a></li>
          <li><a href="queryRequirement.do?flag=1" onclick="change_bg(this)">学员信息库</a></li>
          <li><a href="queryTeacher.do?flag=1" onclick="change_bg(this)">教员信息库</a></li>
      	  <li><a href="queryNews.do?flag=1" onclick="change_bg(this)">教育资讯</a></li>
       <%if(headmember != null) 
 	   {%><li><a href="memberCenter.jsp" onclick="change_bg(this)">会员中心</a></li>
 	   <%} %> 
        </ul>
      </div><!-- mainNav结束 -->
      
   
    <!-- navbox结束 -->
    
  </div><!-- topbox2结束 -->
</div><!-- header结束 -->
<!---------------------------------------------------------------导航与主体分割线------------------------------------------------------------------------------->

  </body>

</html>
