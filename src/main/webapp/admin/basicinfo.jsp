<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <td height="31"><div class="titlebt">网站设置</div></td>
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
            <td class="left_txt">当前位置：基本设置</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;系统参数设置</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" enctype="multipart/form-data" action="addSysinfo.do">
              <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">设定网站名称：</td>
              <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
              <td width="32%" height="30" bgcolor="#f2f2f2"><input name="sitename" type="text" id="sitename" size="30" /></td>
              <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt">网站名称</td>
            </tr>
            <tr>
              <td height="30" align="right" class="left_txt2">网站访问地址：</td>
              <td>&nbsp;</td>
              <td height="30"><input type="text" name="siteurl" size="30" id="siteurl" /></td>
              <td height="30" class="left_txt">网站的网址</td>
            </tr>
            <tr>
              <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">网站备案证号：</td>
              <td bgcolor="#f2f2f2">&nbsp;</td>
              <td height="30" bgcolor="#f2f2f2"><input type="text" name="ICP" size="30" id="ICP" /></td>
              <td height="30" bgcolor="#f2f2f2" class="left_txt">信息产业部备案号</td>
            </tr>
            <tr>
              <td height="30" align="right" class="left_txt2">网站logo： </td>
              <td>&nbsp;</td>
              <td height="30"><label for="sitelogo"></label>
                <input type="file" name="sitelogo" id="sitelogo"></td>
              <td height="30" class="left_txt">设置网站的LOGO</td>
            </tr>
            <tr>
              <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">网站客服QQ：</td>
              <td bgcolor="#f2f2f2">&nbsp;</td>
              <td height="30" bgcolor="#f2f2f2"><input type="text" name="serviceqq" size="30" id="serviceqq" /></td>
              <td height="30" bgcolor="#f2f2f2" class="left_txt">设置网站客服QQ号</td>
            </tr>
            <tr>
              <td height="30" align="right" bgcolor="#F2F2F2" class="left_txt2">管理员邮箱：</td>
              <td bgcolor="#F2F2F2">&nbsp;</td>
              <td height="30" bgcolor="#F2F2F2"><input name="adminemail" type="text" id="adminemail" size="30" /></td>
              <td height="30" bgcolor="#F2F2F2"><span class="left_txt">设置网站客服Email</span></td>
            </tr>
            <tr>
              <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">关键词设置为： </td>
              <td bgcolor="#f2f2f2">&nbsp;</td>
              <td height="30" bgcolor="#f2f2f2"><input type="text" name="keywords" size="30" id="keywords" /></td>
              <td height="30" bgcolor="#f2f2f2"><span class="left_txt">设置网站的关键词，更容易被搜索引挚找到。</span></td>
            </tr>
            <tr>
              <td height="30" align="right" class="left_txt2">网站描述：</td>
              <td>&nbsp;</td>
              <td height="30"><input type="text" name="description" size="30" id="description" /></td>
              <td height="30" class="left_txt">设置网站的描述信息 </td>
            </tr>
            <tr>
              <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">版权信息：</td>
              <td bgcolor="#f2f2f2">&nbsp;</td>
              <td height="30" bgcolor="#f2f2f2"><input type="text" name="copyright" size="24" id="copyright" /></td>
              <td height="30" bgcolor="#f2f2f2" class="left_txt">设置网站的版权信息</td>
                
              </tr>
              
               <tr>
              <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">&nbsp;</td>
              <td bgcolor="#f2f2f2">&nbsp;</td>
              <td height="30" bgcolor="#f2f2f2"><input type="submit" name="button" id="button" value="提交">
                &nbsp;
                <input type="reset" name="button2" id="button2" value="重置"></td>
              <td height="30" bgcolor="#f2f2f2" class="left_txt">&nbsp;</td>
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

</body>
 