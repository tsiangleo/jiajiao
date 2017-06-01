<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  <script language="javascript" >
  function test() {  
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


		<form action="fcktest.jsp" method="post" onsubmit="return test()">
			<p>
				<label for="editor1">Editor 1:</label>
				<textarea cols="80" id="content" name="content" rows="10"></textarea>
			</p>
			<p>
				<input type="submit" value="Submit" onclick="save()" />
			</p>
		</form>
		<ckeditor:replace replace="content" basePath="/jiajiao/ckeditor/" />
		<!-- 参数‘content’是textarea元素的name属性值，而非id属性值 -->
		
		<!-- 创建 ckeditor实例 -->
		<!--  <ckeditor:editor basePath="/ckeditor/jiajiao/" editor="editor1" value="" /> -->
		
		
		
		<% request.setCharacterEncoding("UTF-8");
			String content = request.getParameter("content");
			out.print(content);
		
		%>
  </body>
</html>
