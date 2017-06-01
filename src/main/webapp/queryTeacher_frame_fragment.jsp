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
Teacher teacherinfo = (Teacher)request.getAttribute("teacherinfo"); 
 %>
<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
	<form name="user_form" method="post" action="teacher.do?flag=1" enctype="multipart/form-data">
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
                                 <td width="267" align="left">&nbsp;</td>
                                 <td width="423">您的个人信息如下：</td>
                               </tr>
                             </tbody>
                           </table></th>
                         </tr>
                         <tr>
                           <td width="50%"  align="right">&nbsp;</td>
                           <td width="50%" class="green">&nbsp;</td>
                         </tr>
                         <tr>
                           <td width="50%"  align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>真实姓名：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getTeachername() %>"  readonly="readonly" name="mobilephone11" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone11" />
                           </span></td>
                         </tr>
                         <tr>
                           <td width="50%" align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>移动电话：</span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getMobilephone() %>"  readonly="readonly" name="mobilephone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone" />
                           </span></td>
                         </tr>
                         <tr>
                           <td width="50%" align="right"><span style="font-size:12px;"><font color="#FF0000">*</font><span style="font-size:12px;line-height:160%;">学　　历：</span></span></td>
                           <td width="50%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getDegree() %>"  readonly="readonly" name="mobilephone2" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone2" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 性　　别：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getGender() %>"  readonly="readonly" name="mobilephone3" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone3" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>所在学校：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getSchool() %>"  readonly="readonly" name="mobilephone4" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone4" />
                           </span></td>
                         </tr>
                         <tr>
                           <td height="29" align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000"> </font> 专　　业：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getSpecialty() %>"  readonly="readonly" name="mobilephone12" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone12" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">住　　址：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getAddress() %>"  readonly="readonly" name="mobilephone13" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone13" />
                           </span></td>
                         </tr>
                         
                         <tr>
              <td height="40" align="right" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font>出生日期：</td>
              <td><span style="font-size:12px;line-height:160%;">
                <input type="text" value="<%=teacherinfo.getBirthday() %>"  readonly="readonly" name="mobilephone5" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone5" />
              </span></td>    
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
            
            
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">　<font color="#FF0000">*</font>辅导年级：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getGrade() %>"  readonly="readonly" name="mobilephone6" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone6" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>辅导科目：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getSubject() %>"  readonly="readonly" name="mobilephone7" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone7" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>授课区域：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getServicearea() %>"  readonly="readonly" name="mobilephone8" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone8" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>辅导方式：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getServicetype() %>"  readonly="readonly" name="mobilephone9" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone9" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 薪水要求：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value=
                             "<% if(teacherinfo.getSalary() == 0)
                             		out.println("面议");
                             	else if(teacherinfo.getSalary() == 39)
                             		out.println("40元以下/时");
                             	else if (teacherinfo.getSalary() == 101)
                             		out.println("100元以上/时");
                             	else
                             		out.println(teacherinfo.getSalary() + "元/时");
                             
                              %>"  readonly="readonly" name="mobilephone10" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone10" />
                           </span></td>
                         </tr>
                         
                         
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp;</font> 所获证书：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getCertificate() %>"  readonly="readonly" name="mobilephone14" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone14" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">自我描述：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getDescription() %>"  readonly="readonly" name="mobilephone15" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone15" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp; </font>补充信息：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getNotes() %>"  readonly="readonly" name="mobilephone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone16" />
                           </span></td>
                         </tr>
                         
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp; </font>认证状态：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" value="<%=teacherinfo.getAuthentication() %>"  readonly="readonly" name="mobilephone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone16" />
                           </span></td>
                         </tr>

                         
                       </tbody>
                     </table></td>
                   </tr>
                 </tbody>
              </table>
		<br>
    </div>
    </td>
  </tr>
</table>
    
    
    </form>
 </td>
  </tr>
</table>
        
</body></html>