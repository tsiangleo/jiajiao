<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN">

<title>重庆家教网</title>

<script type="text/javascript" src="style/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="style/DD_belatedPNG_0.0.7a.js"></script>
<script type="text/javascript" src="style/index.js"></script>
<script type="text/javascript" src="style/top.js"></script>
<link href="css/inside.css" rel="stylesheet" type="text/css" />
<link href="css/list.css" rel="stylesheet" type="text/css" />
<link href="css/arc.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css">
<!--<link href="css/global.css" rel="stylesheet" type="text/css"> -->

</head>
<body>
<%
Student studentinfo = (Student)request.getAttribute("studentinfo"); 
 %>
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
	<form name="user_form" method="post" action="requirement.do?flag=1" >
    	<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">
                    <br>
               <table cellpadding="1" cellspacing="1"  border="0"class="mberTab">
                 <tbody>
                   <tr>
                     <td class="green"><table cellpadding="1" cellspacing="1"  border="0"class="mberTab">
                       <tbody>
                         <tr>
                           <th  colspan="4"><table width="690" border="0" cellpadding="0" cellspacing="0">
                             <tbody>
                               <tr>
                                 <td width="120" align="left">查询信息</td>
                                 <td width="850">您的个人信息如下：</td>
                               </tr>
                             </tbody>
                           </table></th>
                         </tr>
                        
                         <tr>
                           <td align="center"><span style="font-size:12px;line-height:160%;">　<font color="#FF0000" style="font-size:16px">学员基本情况</font></span></td>
                           <td class="green">&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">学员姓名：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getStudentname() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">出生年月：</span></td>
                          <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getBirthday() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 性&nbsp;&nbsp;&nbsp;&nbsp;别</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getStugender() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>所在年级：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getGrade() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>求教科目：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getSubject() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">学员情况：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=studentinfo.getDescription() %>"  readonly="readonly" name="phone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(username);" onblur="javascript:onblur_check(username);" id="phone" />
                           </span>
                           </td>
                         </tr>
                         
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"></span></td>
                           <td width="50%" class="green"><span style="font-size:15px;line-height:160%;"><a href="javascript:history.go(-1);">点击返回</a> </span>
                           </td>
                         </tr>
            
                       </tbody>
                     </table></td>
                   </tr>
                 </tbody>
              </table>

    </div>
    
    </td>
  </tr>
</table>
    
    
    </form>
 </td>
  </tr>
</table>
        
</body></html>