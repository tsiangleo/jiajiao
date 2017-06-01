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
<script language="javascript">

function onfocus_check(id) { id.style.border='2px #FF0000 solid'; }
function onblur_check(id) { id.style.border='1px #6CB5FF solid'; }

function user_formcheck() {
if (user_form.studentname.value=='') { alert('请输入学员称呼!'); user_form.studentname.focus(); return false; }
if (user_form.year.value=='' || user_form.month.value=='' || user_form.day.value=='' ) { alert('请选择出生日期!');  return false; }
}
</script>
</head>
<body>

<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
	<form name="user_form" method="post" action="addStudent.do" onsubmit="return user_formcheck()" >
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
                                 <td width="120" align="left">添加信息</td>
                                 <td width="850">添加常联系学员信息。（温馨提示：带 <font color="#FF0000" style="font-size:16px">*</font> 号的为必填项）</td>
                               </tr>
                             </tbody>
                           </table></th>
                         </tr>
                        
                         <tr>
                           <td align="center"><span style="font-size:12px;line-height:160%;">　<font color="#FF0000" style="font-size:16px">学员基本情况</font></span></td>
                           <td class="green">&nbsp;</td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>学员称呼：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input name="studentname" type="text" id="studentname" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(mobile);" onblur="javascript:onblur_check(mobile);" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>出生年月：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select id="year" onchange="changeday()" name="year">
                               <option value="">年</option>
                             </select>
                             <select id="month" name="month"  onchange="changeday()">
                               <option value="">月</option>
                             </select>
                             <select id="day" name="day" >
                               <option value="">日</option>
                             </select>
                           <script type="text/javascript" language="JavaScript">
				var curdate = new Date();
				var year = document.getElementById("year");
				var month = document.getElementById("month");
				var day = document.getElementById("day");
				//绑定年份月分的默认
				function add() {
					var curyear = curdate.getFullYear();
					var minyear = curyear - 60;
					var maxyear = curyear - 0;
					for (maxyear; maxyear >= minyear; maxyear = maxyear - 1) {
						year.options.add(new Option(maxyear, maxyear));
					}
					for ( var mindex = 1; mindex <= 12; mindex++) {
						month.options.add(new Option(mindex, mindex));
					}
				}
				
				//判断是否是闰年
				function leapyear(intyear) {
					var result = false;
					if (((intyear % 400 == 0) && (intyear % 100 != 0)) || (intyear % 4 == 0)) {
						result = true;
					} else {
						result = false;
					}
					return result;
				}
				//绑定天数
				function addday(maxday) {
					day.options.length = 1;
					for ( var dindex = 1; dindex <= maxday; dindex++) {
						day.options.add(new Option(dindex, dindex));
					}
				}
				function changeday() {
					if (year.value == null || year.value == "") {
						alert("请先选择年份！");
						return false;
					} else {
						if (month.value == 1 || month.value == 3 || month.value == 5
								|| month.value == 7 || month.value == 8 || month.value == 10
								|| month.value == 12) {
							addday(31);
						} else {
							if (month.value == 4 || month.value == 6 || month.value == 9
									|| month.value == 11) {
								addday(30);
							} else {
								if (leapyear(year.value)) {
									addday(29);
								} else {
									addday(28);
								}
							}
						}
					}
				}
				window.onload = add;
				     </script>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 性&nbsp;&nbsp;&nbsp;&nbsp;别</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input name="stugender" type="radio" checked="checked" value="男" />
男　
<input type="radio" name="stugender" value="女" />
女</span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>所在年级：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="grade" id="grade" style="width:100px;">
                              <option value="幼儿教育">幼儿教育</option>
                <option value="小学一年级">小学一年级</option>
                <option value="小学二年级">小学二年级</option>
                <option value="小学三年级">小学三年级</option>
                <option value="小学四年级">小学四年级</option>
                <option value="小学五年级">小学五年级</option>
                <option value="小学六年级">小学六年级</option>
                <option value="初中一年级">初中一年级</option>
                <option value="初中二年级">初中二年级</option>
                <option value="初中三年级">初中三年级</option>
                <option value="高中一年级">高中一年级</option>
                <option value="高中二年级">高中二年级</option>
                <option value="高中三年级">高中三年级</option>
                <option value="大学一年级">大学一年级</option>
                <option value="大学二年级">大学二年级</option>
                <option value="大学三年级">大学三年级</option>
                <option value="大学四年级">大学四年级</option>
                <option value="在读研究生">在读研究生</option>
                <option value="在职员工">在职员工</option>
                <option value="退休老人">退休老人</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>求教科目：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="subject" id="subject" style="width:100px;">
                              <option value="学龄前课程">学龄前课程</option>
                <option value="小学全科">小学全科</option>
                <option value="小学数学">小学数学</option>
                <option value="小学英语">小学英语</option>
                <option value="小学语文">小学语文</option>
                <option value="小学奥数">小学奥数</option>
                <option value="初中全科">初中全科</option>
                <option value="初中数理化">初中数理化</option>
                <option value="初中数学">初中数学</option>
                <option value="初中物理">初中物理</option>
                <option value="初中化学">初中化学</option>
                <option value="初中英语">初中英语</option>
                <option value="初中语文">初中语文</option>
                <option value="初中奥数">初中奥数</option>
                <option value="高中文综">高中文综</option>
                <option value="高中理综">高中理综</option>
                <option value="高中全科">高中全科</option>
                <option value="高中数理化">高中数理化</option>
                <option value="高中数学">高中数学</option>
                <option value="高中物理">高中物理</option>
                <option value="高中化学">高中化学</option>
                <option value="高中英语">高中英语</option>
                <option value="高中语文">高中语文</option>
                <option value="高中生物">高中生物</option>
                <option value="高中地理">高中地理</option>
                <option value="高中历史">高中历史</option>
                <option value="大学英语六级">大学英语六级</option>
                <option value="新概念英语">新概念英语</option>
                <option value="剑桥英语">剑桥英语</option>
                <option value="雅思">雅思</option>
                <option value="音乐启蒙">音乐启蒙</option>
                <option value="表演舞蹈">表演舞蹈</option>
                <option value="书法">书法</option>
                <option value="美术">美术</option>
                <option value="吉他">吉他</option>
                <option value="手风琴">手风琴</option>
                <option value="电子琴">电子琴</option>
                <option value="古筝">古筝</option>
                <option value="中国武术">中国武术</option>
                <option value="拳击柔道跆拳道">拳击柔道跆拳道</option>
                <option value="其他">其他</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">学员情况：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input name="description" type="text" id="description" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(mobile);" onblur="javascript:onblur_check(mobile);" />
                           </span></td>
                         </tr>
                         
                         <tr>
                           <td align="right">&nbsp;</td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input name="imageField" type="image" src="./images/tijiao.png" width="80" height="30" border="0" />
                           </span></td>
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