<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cqupt.jiajiao.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="head.jsp" flush="true" />
</head>

<body>
<div class="content_wraper">
<!-- 以下为主体 -->
  
<% Teacher teacherinfo = (Teacher)request.getAttribute("teacherinfo"); 
%>


        <div class="bk left" id="mainContentbox">
            <div class="bktop">
                <div class="bktopzb">
                </div>
                <div class="bktopyb">
                </div>
                <div class="clearThis">
                </div>
            </div>
            <div class="bknr">
                <div class="mainContent">
                    <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">教员详细信息</a></div>
                    <div class="cate_title">
                        <h1>【<%=teacherinfo.getTeachername() %>】详细信息 </h1>
                    </div>       
                    <div class="content_list">
                    
                    <table cellpadding="1" cellspacing="1"  border="1"class="mberTab">
	                <tbody>
	                 <tr>
	                  <td align="center"><strong><img src="<%=teacherinfo.getPhoto() %>" width="100" height="120" /></strong></td>
	                </tr>
	              </tbody>
	              </table>
              
                   <table cellpadding="1" cellspacing="1"  border="1"class="mberTab">
                <tbody><tr>
                  <th colspan="4"><%=teacherinfo.getId() %> 号教员基本信息</th>
                </tr>
              
                <tr>
                  <td align="right"><strong>教员编号：</strong></td>
                  <td class="green"><%=teacherinfo.getId() %></td>
                  <td align="right"><strong>姓名：</strong></td>
                  <td class="blue"><%=teacherinfo.getTeachername() %></td>
                </tr>
                <tr>
                  <td align="right"><strong>性别：</strong></td>
                  <td><%=teacherinfo.getGender() %></td>
                  <td align="right"><strong>学历:</strong></td>
                  <td><%=teacherinfo.getDegree() %></td>
                </tr>
                <tr>
                  <td align="right"><strong>出生年月：</strong></td>
                  <td class="yel"><%=teacherinfo.getBirthday() %></td>
                  <td align="right"><strong>高校：</strong></td>
                  <td><%=teacherinfo.getSchool() %></td>
                </tr>
                <tr>
                  <td align="right"><strong>专业：</strong></td>
                  <td><%=teacherinfo.getSpecialty() %></td>
                  <td align="right"><strong>住址：</strong></td>
                  <td><%=teacherinfo.getAddress() %></td>
                </tr>
                
                <tr>
                  <td align="right"><strong>认证情况：</strong></td>
                  <td class="yel"><%=teacherinfo.getAuthentication() %></td>
                  <td align="right"><strong>其它信息：</strong></td>
                  <td><%=teacherinfo.getNotes() %></td>
                </tr>
              </tbody></table>
              
              <table cellpadding="1" cellspacing="1" border="1" class="mberTab">
                <tbody><tr>
                  <th colspan="4">家教信息 </th>
                </tr>
                <tr>
                  <td width="17%" align="right"><strong>教授科目：</strong></td>
                  <td colspan="3" class="nonutd"><%=teacherinfo.getSubject() %></td>
     			 </tr> 
     			 <tr>
                  <td width="17%" align="right"><strong>教授年级：</strong></td>
                  <td colspan="3" class="nonutd"><%=teacherinfo.getGrade() %></td>
     			 </tr> 
     			            
                 <tr>
                  <td align="right"><strong>授课区域：</strong></td>
                  <td colspan="3"><%=teacherinfo.getServicearea() %></td>
                </tr>
                <tr>
                  <td align="right"><strong>辅导方式：</strong></td>
                  <td colspan="3"><%=teacherinfo.getServicetype() %></td>
                </tr>
               <tr>
                  <td align="right"><strong>所获证书：</strong></td>
                  <td colspan="3"><%=teacherinfo.getCertificate() %></td>
                </tr>
                
                <tr>
                  <td align="right"><strong>薪水要求：</strong></td>
                  <td colspan="3" class="red">
                  							<% if(teacherinfo.getSalary() == 39)
											{	
												out.print("40元以下/时"); 
											%>
											<%
											 }else if(teacherinfo.getSalary() == 101) 
											{	
												out.print("100元以上/时");  %>
											<%
											} 
											else if(teacherinfo.getSalary() == 0)
											{	out.print("面议");} 											
											else 
											{
												out.println(teacherinfo.getSalary() + "元/时");
											} %>	
				 </td>
      			</tr>
               
                <tr>
                  <td align="right"><strong>自我描述：</strong></td>
                  <td colspan="3"><%=teacherinfo.getDescription() %></td>
      			</tr>
                  <tr>
                  <td align="right"><strong>补充信息：</strong></td>
                  <td colspan="3"><%=teacherinfo.getNotes() %></td>
                </tr>
      			</tbody>
                </table>
                
                <table cellpadding="1" cellspacing="1"  border="1"class="mberTab">
		                <tbody>
		              <tr>
		                  <th colspan="4">&nbsp;</th>
		                </tr>
		                <tr>
		                 <%
		                  Member m = (Member)session.getAttribute("member");
		                 cn.edu.cqupt.jiajiao.service.MemberTypeService ms = new  cn.edu.cqupt.jiajiao.service.MemberTypeService();
		                int mpt = ms.findMemberType(m.getType()).getMoneypt();
		                  
		                  
		                  String key = m.getId()+"@"+teacherinfo.getId();
						  String show = (String)session.getAttribute(key);
		                 if(show == null )
		                 {
		                 %>
		                  <td align="right"><a href="lookPhone.do?tid=<%=teacherinfo.getId() %>&&flag=t&&mpt=<%=mpt %>"
		                   onclick='return confirm("您是【<%= m.getType()%>】，本次查看消耗【<%=mpt %>个】金币，确定要查看吗?")'><img src="images/lookphone.png" width="100" height="30" /></a>
		                   </td>
		                   <%}
		                   else
		                   { %>
		                    <td align="right"> 联系电话：【<font style="font-size:20px; color:#ff0000"><%=teacherinfo.getMobilephone() %></font>】</td>

		                   <%} %>
		                   <td align="left"><a href="collection.do?flag=1&&tid=<%=teacherinfo.getId() %>"><img src="images/shoucang.png" width="100" height="30" /></a></td>
		                </tr>
		         		</tbody>
		         </table>
		              
		           
      
                    <div class="cate_title">
                  <h1>&nbsp;</h1>
                    </div>
                    <table cellpadding="1" cellspacing="1" border="1" class="mberTab">
                <tbody><tr>
                  <th colspan="4">来自学员的评价</th>
                </tr>
                <tr align="center">
                  <td ><strong>总体评价</strong></td>
                  <td ><strong>评价内容</strong></td>
                  <td ><strong>评价时间</strong></td>
                  <td ><strong>评价者</strong></td>
                  <td ><strong>教员回复</strong></td>
     			 </tr>            
                   
<%  List<Evaluation> evaluationlist = ( List<Evaluation>)request.getAttribute("evaluationlist"); 
if(evaluationlist != null)
{
	for(int i = 0;i<evaluationlist.size();i++)
	{
	%>
                
                <tr>
                 <td ><%=evaluationlist.get(i).getTotalevaluation() %></td>
                  <td ><%=evaluationlist.get(i).getContent() %></td>
                   <td ><%=evaluationlist.get(i).getTime() %></td>
                    <td ><%=evaluationlist.get(i).getAuthor() %></td>
                     <td ><%=evaluationlist.get(i).getReply() %></td>
      			</tr>
    <%}
} %>       
      			</tbody>
                </table><br>

                    <form action="evaluation.do?flag=1" method="post">
                        <table align="center" width="490" border="0" class="mberTab">
                        <input name="teacherid" type="hidden" value="<%=teacherinfo.getId() %>" />
                          <tr>
                            <td style="font-size:20px;color:#FF6600;font-weight:bold;">我要评价</td>
                          </tr>
                          <tr>
                            <td>总体评价：
                             
                                  <input type="radio" name="totalevaluation" value="好评" id="totalevaluation_0" />
                                  好评
                              
                                  <input type="radio" name="totalevaluation" value="中评" id="totalevaluation_1" />
                                中评
                               
                              
                                  <input type="radio" name="totalevaluation" value="差评" id="totalevaluation_2" />
差评 </td>
                          </tr>
                          <tr>
                            <td>评价内容：</td>
                          </tr>
                          <tr>
                            <td><label for="content"></label>
                            <textarea name="content" id="content" cols="45" rows="5"></textarea></td>
                          </tr>
                          <tr>
                            <td><input name="imageField" type="image" src="./images/tijiao.png" width="60" height="30" border="0"></td>
                          </tr>
                        </table>
                    </form>

                    
                    
                    
      
                    </div>
                   
                </div> 
                
                <div class="bktopxb">
                    <div class="bktopzx"></div>
                    <div class="bktopyx"></div>
           		</div>
            </div>
           
        </div>
        
        
   <div id="slider_list" class="right">
    <div class="bk recommend_list">
      <div class="bktop">
        <h3>推荐教员</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<Teacher> VIPteachers = (ArrayList<Teacher>)session.getAttribute("VIPteachers");
         int technum  = VIPteachers.size() > 5 ? 5 : VIPteachers.size();
        for(int i = 0;i< technum ;i++)
        {
         %>
                 <li><a href="queryTeacherDetail.do?flag=1&&id=<%=VIPteachers.get(i).getId() %>">
                            <%=VIPteachers.get(i).getTeachername() %>&nbsp;&nbsp;
                            <%=VIPteachers.get(i).getSubject() %>&nbsp;&nbsp;
                            <%=VIPteachers.get(i).getDegree() %>
                    </a>
                </li>                  
       <%} %>              
        </ul>
        
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
     <div class="bk recommend_list" id="hotnews">
      <div class="bktop"><h3>热点新闻</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<News> hotNews = (ArrayList<News>)session.getAttribute("HotNews");
         int newsnum  = hotNews.size() > 5 ? 5 : hotNews.size();
        for(int i = 0;i< newsnum ;i++)
        {
         %>
          <li><a href="queryNewsDetail.do?id=<%=hotNews.get(i).getId() %>"><%=(hotNews.get(i).getTitle().length()>15 ? hotNews.get(i).getTitle().substring(0,15)+"..." : hotNews.get(i).getTitle()) %></a></li>
       <%} %>
        </ul>
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
    <div class="bk recommend_list" id="hot_shipin">
      <div class="bktop"><h3>系统公告</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
     <% ArrayList<Notice> noticeList = (ArrayList<Notice>)session.getAttribute("noticeList");
        for(int i = 0;i<noticeList.size();i++)
        {
         %>
          <li><a href="queryNoticeDetail.do?id=<%=noticeList.get(i).getId() %>"><%=noticeList.get(i).getTitle() %></a></li>
       <%} %>
                
        </ul>
      </div>
      <div class="bktopxb">
        <div class="bktopzx"></div>
        <div class="bktopyx"></div>
      </div>
      <div class="clearThis"></div>
    </div>
  </div>

        <div class="clearThis">
        </div>

  
</div>
<jsp:include page="foot.jsp" flush="true" />
</body>
</html>