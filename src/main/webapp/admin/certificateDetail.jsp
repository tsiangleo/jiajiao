<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
<%
Certificate certificate = (Certificate) request.getAttribute("certificate");


HashMap<String, String> hashmap = new HashMap<String, String>();
if(certificate.getCct() != null)
	hashmap.put("计算机等级考试证书",certificate.getCct());
if(certificate.getCet4() != null)
	hashmap.put("大学英语四级考试证书",certificate.getCet4());
if(certificate.getCet6() != null)
	hashmap.put("大学英语六级考试证书",certificate.getCet6());
if(certificate.getGraduate() != null)
	hashmap.put("研究生毕业证",certificate.getGraduate());
if(certificate.getIdcard() != null)
	hashmap.put("身份证",certificate.getIdcard());
if(certificate.getIelts() != null)
	hashmap.put("雅思证书",certificate.getIelts());
if(certificate.getStucard() != null)
	hashmap.put("学生证",certificate.getStucard());
if(certificate.getTem8() != null)
	hashmap.put("专业英语八级证书",certificate.getTem8());
if(certificate.getToefl() != null)
	hashmap.put("托福证书",certificate.getToefl());
if(certificate.getUndergraduate() != null)
	hashmap.put("本科毕业证",certificate.getUndergraduate());


 Iterator<String> itor = hashmap.keySet().iterator();  
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
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">新闻管理</div></td>
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
            <td class="left_txt">当前位置：教员认证</td>
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
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;证件详情</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <%
               while(itor.hasNext())  
			 {  
			  		String key = (String)itor.next();  
			  		String value = (String)hashmap.get(key);  
			  

               %>  
                <tr>
                  <td width="21%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><strong><%=key %></strong></td>
                
              </tr>
              <tr>
               <td width="21%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2"><img name="" src="<%=value %>" width="580" height="500" alt=""></td>
                
  			</tr>
            <tr>
               <td width="21%" height="30" align="center" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
                
  			</tr>

			<% }  %>
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
 