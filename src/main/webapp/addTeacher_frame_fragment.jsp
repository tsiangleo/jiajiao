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
function onfocus_check(id) { id.style.border='2px #FF0000 solid'; }
function onblur_check(id) { id.style.border='1px #6CB5FF solid'; }

function teacherformcheck() {
if (teacherform.teachername.value=='') { alert('请输入您的真实姓名!'); teacherform.teachername.focus(); return false; }
if (teacherform.mobilephone.value=='') { alert('请输入移动电话!'); teacherform.mobilephone.focus(); return false; }
if (isNaN(teacherform.mobilephone.value)) { alert('移动电话必须为数字!'); teacherform.mobilephone.focus(); return false; }
if (teacherform.mobilephone.value.length<11 || teacherform.mobilephone.value.length>11) { alert('请输入正确的移动电话号码!'); teacherform.mobilephone.focus(); return false; }
if (teacherform.year.value=='' || teacherform.month.value=='' || teacherform.day.value=='' ) { alert('请选择出生日期!');  return false; }
}
</script>

 
<body>

<table width="700" border="0" align="center" cellpadding="1" cellspacing="1">
  <tr>
    <td>
     <form name="teacherform" method="post" action="addTeacher.do" enctype="multipart/form-data"  onsubmit="return teacherformcheck()" >
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
                                 <td width="850">请填写您的真实有效的信息。（温馨提示：带 <font color="#FF0000" style="font-size:16px">*</font> 号的为必填项）</td>
                               </tr>
                             </tbody>
                           </table></th>
                         </tr>
                         
                         <tr>
                           <td width="40%"  align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>真实姓名：</span></td>
                           <td width="60%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="teachername" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjchenghu);" onblur="javascript:onblur_check(jjchenghu);" id="teachername" />
                           </span></td>
                         </tr>
                         <tr>
                           <td width="40%" align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>移动电话：</span></td>
                           <td width="60%" class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="mobilephone" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="mobilephone" />
                           </span></td>
                         </tr>
                         <tr>
                           <td width="40%" align="right"><span style="font-size:12px;"><font color="#FF0000">*</font><span style="font-size:12px;line-height:160%;">学　　历：</span></span></td>
                           <td width="60%" class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="degree" id="degree" onchange="javascript:sort_list(this.value);">
                               <option value="大学本科 ">大学本科 </option>
                               <option value="大学专科">大学专科</option>
                               <option value="硕士研究生">硕士研究生</option>
                               <option value="博士研究生">博士研究生</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 性　　别：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input name="gender" type="radio" checked="checked" value="男" />
                             男　
                             <input type="radio" name="gender" value="女" />
                           女</span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>所在学校：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="school" id="school" style="width:100px;">
                              <option value="重庆大学">重庆大学</option>
                <option value="西南大学">西南大学</option>
                <option value="重庆师大">重庆师大</option>
                <option value="西南政法">西南政法</option>
                <option value="重庆交大">重庆交大</option>
                <option value="重庆邮电大学">重庆邮电大学</option>
                <option value="重庆医大">重庆医大</option>
                <option value="重庆工商">重庆工商</option>
                <option value="重庆科技学院">重庆科技学院</option>
                <option value="重庆理工大学">重庆理工大学</option>
                <option value="长江师范学院">长江师范学院</option>
                <option value="四川外国语">四川外国语</option>
                <option value="四川美院">四川美院</option>
                <option value="重庆三峡学院">重庆三峡学院</option>
                <option value="重庆文理">重庆文理</option>
                <option value="重庆化工职业学院">重庆化工职业学院</option>
                <option value="后勤工程学院">后勤工程学院</option>
                <option value="重庆能源职业学院">重庆能源职业学院</option>
                <option value="重庆商务职业学院">重庆商务职业学院</option>
                <option value="重庆旅游职业学院">重庆旅游职业学院</option>
                <option value="重庆房地产职业学院">重庆房地产职业学院</option>
                <option value="重庆城市职业学院">重庆城市职业学院</option>
                <option value="重庆电力高等专科学校">重庆电力高等专科学校</option>
                <option value="重庆电子工程职业学院">重庆电子工程职业学院</option>
                <option value="重庆航天职业技术学院">重庆航天职业技术学院</option>
                <option value="重庆工程职业技术学院">重庆工程职业技术学院</option>
                <option value="重庆工商职业学院">重庆工商职业学院</option>
                <option value="重庆工业职业技术学院">重庆工业职业技术学院</option>
                <option value="重庆机电职业技术学院">重庆机电职业技术学院</option>
                <option value="重庆三峡医药高等专科学校">重庆三峡医药高等专科学校</option>
                <option value="重庆信息技术职业学院">重庆信息技术职业学院</option>
                <option value="重启职业技术学院">重启职业技术学院</option>
                <option value="重庆大学城市科技学院">重庆大学城市科技学院</option>
                <option value="重庆师范大学涉外商贸学院">重庆师范大学涉外商贸学院</option>
                <option value="重庆邮电大学移通学院">重庆邮电大学移通学院</option>
                <option value="重庆城市管理职业学院">重庆城市管理职业学院</option>
                <option value="重庆传媒职业学院">重庆传媒职业学院</option>
                <option value="重庆警官职业学院">重庆警官职业学院</option>
                <option value="重庆三峡职业学院">重庆三峡职业学院</option>
                <option value="重庆医药高等专科学校">重庆医药高等专科学校</option>
                <option value="重庆教育学院">重庆教育学院</option>
                <option value="西南大学育才学院">西南大学育才学院</option>
                <option value="重庆工商大学融智学院">重庆工商大学融智学院</option>
                <option value="重庆工贸职业技术学院">重庆工贸职业技术学院</option>
                <option value="重庆财经职业学院">重庆财经职业学院</option>
                <option value="重庆海联职业技术学院">重庆海联职业技术学院</option>
                <option value="重庆民生职业技术学院">重庆民生职业技术学院</option>
                <option value="重庆水利电力职业技术学院">重庆水利电力职业技术学院</option>
                <option value="重庆正大软件职业技术学院">重庆正大软件职业技术学院</option>
                <option value="重庆应用外国语专修学院">重庆应用外国语专修学院</option>
                <option value="四川外语学院重庆南方翻译学院">四川外语学院重庆南方翻译学院</option>
                <option value="重庆工商大学派斯学院">重庆工商大学派斯学院</option>
                <option value="重庆青年职业技术学院">重庆青年职业技术学院</option>
                <option value="重庆科创职业学院">重庆科创职业学院</option>
                <option value="重庆建筑工程职业学院">重庆建筑工程职业学院</option>
                <option value="重庆通信学院">重庆通信学院</option>
                <option value="重庆电讯职业学院">重庆电讯职业学院</option>
                <option value="重庆五一技师学院">重庆五一技师学院</option>
                <option value="西南大学应用技术学院">西南大学应用技术学院</option>
                <option value="重庆科创职业技术学院">重庆科创职业技术学院</option>
                <option value="重庆交通职业学院">重庆交通职业学院</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td height="29" align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000"> </font> 专　　业：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="specialty" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="specialty" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">住　　址：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="address" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="address" />
                           </span></td>
                         </tr>
                         
                         <tr>
              <td height="40" align="right" style="font-size:12px;line-height:160%;">　　　　　　　　　　　　　　　　　<font color="#FF0000">*</font>出生日期：</td>
              <td>  
              <select id="year" onchange="changeday()" name="year"> <option value="">年</option> </select>  
              <select id="month" name="month"  onchange="changeday()"><option value="">月</option> </select>
              <select id="day" name="day" ><option value="">日</option> </select>     
              <script type="text/javascript" language="javascript">
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
              </td>    
              <td height="40" align="left" style="font-size:12px;line-height:160%;">&nbsp;</td>
            </tr>
            
            
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">　<font color="#FF0000">*</font>辅导年级：</span></td>
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
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>辅导科目：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="subject" id="subject" style="width:100px;">
                               <option value="不限">不限</option>
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
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>授课区域：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="servicearea" id="servicearea" style="width:100px;">
                               <option value="不限">不限</option>
				<option value="渝中">渝中</option>
				<option value="万州">万州</option>
				<option value="涪陵">涪陵</option>
                <option value="大渡口">大渡口</option>
                <option value="江北">江北</option>
                <option value="沙坪坝">沙坪坝</option>
                <option value="九龙坡">九龙坡</option>
                <option value="南岸">南岸</option>
                <option value="北碚">北碚</option>
                <option value="万盛">万盛</option>
                <option value="双桥">双桥</option>
                <option value="渝北">渝北</option>
                <option value="巴南">巴南</option>
                <option value="黔江">黔江</option>
                <option value="长寿">长寿</option>
                <option value="江津">江津</option>
                <option value="合川">合川</option>
                <option value="永川">永川</option>
                <option value="南川">南川</option>
                <option value="綦江">綦江</option>
                <option value="潼南">潼南</option>
                <option value="铜梁">铜梁</option>
                <option value="开县">开县</option>
                <option value="大足">大足</option>
                <option value="荣昌">荣昌</option>
                <option value="璧山">璧山</option>
                <option value="梁平">梁平</option>
                <option value="城口">城口</option>
                <option value="丰都">丰都</option>
                <option value="垫江">垫江</option>
                <option value="武隆">武隆</option>
                <option value="忠县">忠县</option>
                <option value="云阳">云阳</option>
                <option value="奉节">奉节</option>
                <option value="巫山">巫山</option>
                <option value="巫溪">巫溪</option>
                <option value="石柱">石柱</option>
                <option value="秀山">秀山</option>
                <option value="酉阳">酉阳</option>
                <option value="彭水">彭水</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font>辅导方式：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="servicetype" id="servicetype" onchange="javascript:sort_list(this.value);">
                               <option value="本人上门">本人上门</option>
                               <option value="学生上门">学生上门</option>
                             </select>
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">*</font> 薪水要求：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <select name="salary" id="salary" onchange="javascript:sort_list(this.value);">
                               <option value="0">面议</option>
                               <option value="39">40元以下/时</option>
                               <option value="40">40元/小时</option>
                               <option value="50">50元/小时</option>
                               <option value="60">60元/小时</option>
                               <option value="70">70元/小时</option>
                               <option value="80">80元/小时</option>
                               <option value="90">90元/小时</option>
                               <option value="100">100元/小时</option>
                               <option value="101">100元以上/时</option>
                             </select>
                           </span></td>
                         </tr>
                 
			             <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp;</font> 个人照片：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="file" name="photo" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="certificate" />
                           </span></td>
                         </tr>
                         
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp;</font> 所获证书：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="certificate" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="certificate" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;">自我描述：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="description" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="description" />
                           </span></td>
                         </tr>
                         <tr>
                           <td align="right"><span style="font-size:12px;line-height:160%;"><font color="#FF0000">&nbsp; </font>补充信息：</span></td>
                           <td class="green"><span style="font-size:12px;line-height:160%;">
                             <input type="text" name="notes" style="width:200px;height:20px;line-height:20px;border:1px #6CB5FF solid;" onfocus="javascript:onfocus_check(jjrealname);" onblur="javascript:onblur_check(jjrealname);" id="notes" />
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
    </form>
 </td>
  </tr>
</table>
        
</body></html>