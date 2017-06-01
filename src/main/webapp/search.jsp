<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
  <body>
  
<!------------------------------条件搜索开始---------------------------------------->
  <div class="bk" id="free_video_box">
    <div class="bktop" style="height:60px"><img src="style/freeshipin_tit.png" width="1006" height="60"> </div>
    <div class="bknr">
   
<form name="teacher_form" method="post" action="queryTeacher.do?flag=2"  > 
 <table align="center">
  <tbody><tr>
   <td ><font style="font-family:黑体; font-size:16px;">搜教员</font>&nbsp;&nbsp;&nbsp;</td>
  <td >家教科目</td>
   <td>
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
   </td>
    <td>&nbsp;&nbsp;&nbsp;院校</td>
   <td>
       <select name="school" id="school" style="width:100px;">
				<option value="不限">不限</option>
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

   </td>
    <td>&nbsp;&nbsp;&nbsp;家教区域</td>
   <td>
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
   </td>
    <td>&nbsp;&nbsp;&nbsp;教员性别</td>
   <td >
       <select name="gender" id="gender">
	<option value="不限">不限</option>
	<option value="男">男</option>
	<option value="女">女</option>
	

</select>
   </td>
   <td>&nbsp;</td>
   <td class="sch_bton">
       <input type="image" name="zztop1$ImageButton1" id="zztop1_ImageButton1" src="images/sp.gif" style="border-width:0px;">
   </td> 
  </tr>

  </tbody></table>
 
  </form>
  




<form name="student_form" method="post" action="queryRequirement.do?flag=2"  > 
 
 <table align="center">
  <tbody>
  <tr>
  <td ><font style="font-family:黑体; font-size:16px;">搜学员</font>&nbsp;&nbsp;&nbsp;</td>
  <td >辅导科目</td>
   <td>
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
   </td>
    <td>&nbsp;&nbsp;&nbsp;年级</td>
   <td>
       <select name="grade" id="grade" style="width:100px;">
	<option value="不限">不限</option>
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
   </td>
    <td>&nbsp;&nbsp;&nbsp;家教区域</td>
   <td>
       <select name="area" id="area" style="width:100px;">
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
   </td>
    <td>&nbsp;&nbsp;&nbsp;学员性别</td>
   <td>
       <select name="stugender" id="stugender">
	<option value="不限">不限</option>
	<option value="男">男</option>
	<option value="女">女</option>
	

</select>
   </td>
   <td>&nbsp;</td>
   <td class="sch_bton">
       <input type="image" name="zztop1$ImageButton2" id="zztop1_ImageButton2" src="images/sp.gif" style="border-width:0px;"></td>
  </tr>
  </tbody></table>
 
  </form>
    </div>
    <div class="bktopxb">
      <div class="bktopzx"></div>
      <div class="bktopyx"></div>
    </div>
    <div class="clearThis"></div>
  </div>
  <!------------------------------条件搜索结束----------------------------------------->
   



  </body>
</html>

