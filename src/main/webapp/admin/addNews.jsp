<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
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

<script language="javascript" >
  function check() {  
    var editor_data = CKEDITOR.instances.content.getData();  
    if(editor_data==null || editor_data==""){  
        alert("请填写新闻内容！");  
        return false;  
    }  
    
  function save(){
       //editor1.updateElement(); //非常重要的一句代码
        //前台验证工作
        //提交到后台
        
        //在后台java代码中就可以用request.getParameter('content');获取值
    }
}  
  </script>
  
<body>
<%
ArrayList<String> newstypeList = (ArrayList<String>) request.getAttribute("newstypeList");
 %>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">发布新闻</div></td>
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
            <td class="left_txt">当前位置：发布新闻</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;发布新闻</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="addNewsForm" method="POST" action="addNews.do" onsubmit="return check()">
              <tr>
                <td width="16%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">新闻标题：</td>
                <td width="4%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="80%" height="30" bgcolor="#f2f2f2"><input name="title" type="text" id="title" size="50" /></td>
                
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">新闻来源：</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="source" size="50" id="source" /></td>
                
              </tr>
              
              <tr>
                <td height="30" align="right" class="left_txt2">新闻类型：</td>
                <td>&nbsp;</td>
                <td height="30">
                <select name="type" >
                <% for(int i = 0;i<newstypeList.size();i++)
                {
                %>
                <option value="<%=newstypeList.get(i) %>"><%=newstypeList.get(i) %></option>
                <%} %>
              </select>
                </td>
                
              </tr>
              
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">新闻内容：</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><textarea name="content" cols="120" rows="50" id="content"></textarea></td>
               
              </tr>
           
            <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2">&nbsp;</td>
               
              </tr>
              
               <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="submit" value="提交" name="B1" />&nbsp;&nbsp;&nbsp;
                	<input type="reset" value="取消" name="B12" />
                </td>
               
              </tr>
            
              <tr>
                <td height="30" colspan="4" align="right" class="left_txt2"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                  
                </table>
                </td>
              </tr>

            </table></td>
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

		<ckeditor:replace replace="content" basePath="/jiajiao/ckeditor/" />
		<!-- 参数‘content’是textarea元素的name属性值，而非id属性值 -->
		
		<!-- 创建 ckeditor实例 -->
		<!--  <ckeditor:editor basePath="/ckeditor/jiajiao/" editor="editor1" value="" /> -->

		
</body>
