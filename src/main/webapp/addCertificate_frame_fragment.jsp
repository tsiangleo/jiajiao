<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<script language="javascript">
function user_formcheck() {
if (user_form.idcard.value=='' && user_form.stucard.value=='' && user_form.undergraduate.value=='' && user_form.graduate.value==''
&& user_form.cet4.value=='' && user_form.cet6.value=='' && user_form.tem8.value=='' && user_form.cct.value==''
&& user_form.toefl.value=='' && user_form.ielts.value=='') 
{ alert('至少应该上传一件证书!'); return false; }

}
</script>

<body>

<form id="user_form" name="user_form" method="post" enctype="multipart/form-data" action="addCertificate.do"   onsubmit="return user_formcheck()" >
  <p id="certificateForm">&nbsp;</p>
  <table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
    <div class="content_list">
                    <br>
               <table cellpadding="1" cellspacing="1"  border="0"class="mberTab">
                <tbody><tr>
                  <th  colspan="4"><strong>您可以上传以下证书</strong></th>
                </tr>
              
                <tr>
                  <td width="50%"  align="right"><strong>身份证：</strong></td>
                  <td width="50%" class="green"><label for="idcard"></label>
                  <input type="file" name="idcard" id="idcard" /></td>
                </tr>
                
                 <tr>
                  <td width="50%" align="right"><strong>学生证：</strong></td>
                  <td width="50%" class="green"><input type="file" name="stucard" id="stucard" /></td>
                </tr>
                 
                <tr>
                  <td width="50%" align="right"><strong>本科毕业证：</strong></td>
                  <td width="50%" class="green"><input type="file" name="undergraduate" id="undergraduate" /></td>
                </tr>
                
                <tr>
                  <td align="right"><strong>研究生毕业证：</strong></td>
                  <td class="green"><input type="file" name="graduate" id="graduate" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>英语四级证书：</strong></td>
                  <td class="green"><input type="file" name="cet4" id="cet4" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>英语六级证书：</strong></td>
                  <td class="green"><input type="file" name="cet6" id="cet6" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>专业英语八级证书：</strong></td>
                  <td class="green"><input type="file" name="tem8" id="tem8" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>计算机等级证书：</strong></td>
                  <td class="green"><input type="file" name="cct" id="cct" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>托福证书：</strong></td>
                  <td class="green"><input type="file" name="toefl" id="toefl" /></td>
                </tr>
                <tr>
                  <td align="right"><strong>雅思证书：</strong></td>
                  <td class="green"><input type="file" name="ielts" id="ielts" /></td>
                </tr>
                <tr>
                  <td align="right">&nbsp;</td>
                  <td class="green"><input type="submit" name="button" id="button" value="提交" />
                  <input type="reset" name="button2" id="button2" value="重置" /></td>
                </tr>
              </tbody>
              </table>
              
          
    </div>
    
    </td>
  </tr>
</table>
</form>

        
</body></html>