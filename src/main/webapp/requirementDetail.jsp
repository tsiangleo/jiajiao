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
  <% Requirement requirementinfo = (Requirement)request.getAttribute("requirementinfo"); 
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
                    <div id="Position1_PositionDiv" class="position">当前位置：<a href="#">首页</a> > <a href="#">学员详细信息</a></div>
                    <div class="cate_title">
                        <h1>
                           【<%=requirementinfo.getStudentname() %>】详细信息</h1>
                    </div>
                    <div class="content_list">      
               <table cellpadding="1" cellspacing="1"  border="1"class="mberTab">
                <tbody><tr>
                  <th colspan="4"><%=requirementinfo.getId() %>号学员基本信息</th>
                </tr>
              
                <tr>
                  <td align="right"><strong>姓名：</strong></td>
                  <td class="green"><%=requirementinfo.getStudentname() %></td>
                  <td align="right"><strong>出生日期：</strong></td>
                  <td class="blue"><span class="yel"><%=requirementinfo.getBirthday() %></span></td>
                </tr>
                <tr>
                  <td align="right"><strong>性别：</strong></td>
                  <td><%=requirementinfo.getStugender() %></td>
                  <td align="right"><strong>所在年级：</strong></td>
                  <td><%=requirementinfo.getGrade() %></td>
                </tr>
              </tbody></table>
              
              <table cellpadding="1" cellspacing="1" border="1" class="mberTab">
                <tbody><tr>
                  <th colspan="4">家教辅导信息 </th>
                </tr>
                <tr>
                  <td width="17%" align="right"><strong>学员编号：</strong></td>
                  <td colspan="3" class="nonutd"><span class="green"><%=requirementinfo.getId() %></span></td>
     			 </tr> 
                  <tr>
                  <td align="right"><strong>学员情况：</strong></td>
                  <td colspan="3"><span class="blue"><%=requirementinfo.getDescription() %></span></td>
                </tr>
                           
                 <tr>
                  <td align="right"><strong>联系人：</strong></td>
                  <td colspan="3"><span class="blue"><%=requirementinfo.getContacts() %></span></td>
                </tr>
                <tr>
                  <td align="right"><strong>求教科目：</strong></td>
                  <td colspan="3"><%=requirementinfo.getSubject() %></td>
                </tr>
               <tr>
                  <td align="right"><strong>授课区域：</strong></td>
                  <td colspan="3"><%=requirementinfo.getArea() %></td>
                </tr>
                
                <tr>
                  <td align="right"><strong>报酬：</strong></td>
                  <td colspan="3" class="red">
						<% if(requirementinfo.getSalary() == 39)
							{	out.print("40元以下/时"); %>
							<%
							}else if(requirementinfo.getSalary() == 101) 
							{	out.print("100元以上/时");  %>
							<%} else if(requirementinfo.getSalary() == 0)
							{out.print("面议");} 											
							else 
							{out.println(requirementinfo.getSalary() + "元/时");} %>	
					</td>				
      			</tr>
                
                <tr>
                  <td align="right"><strong>学历要求：</strong></td>
                  <td colspan="3"><%=requirementinfo.getDegree() %></td>
      			</tr>
                <tr>
                  <td align="right"><strong>性别要求：</strong></td>
                  <td colspan="3"><%=requirementinfo.getGender() %></td>
      			</tr>
                <tr>
                  <td align="right"><strong>学校要求：</strong></td>
                  <td colspan="3"><%=requirementinfo.getSchool() %></td>
      			</tr>
                <tr>
                  <td align="right"><strong>可授课时间：</strong></td>
                  <td colspan="3"><%=requirementinfo.getClasstime() %></td>
      			</tr>
                <tr>
                  <td align="right"><strong>发布时间：</strong></td>
                  <td colspan="3"><%=requirementinfo.getIssuetime() %></td>
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
		                  
		                  
		                  String key = m.getId()+"@"+requirementinfo.getId();
						  String show = (String)session.getAttribute(key);
		                 if(show == null )
		                 {
		                 %>
		                  <td align="center"><a href="lookPhone.do?rid=<%=requirementinfo.getId() %>&&flag=r&&mpt=<%=mpt %>"
		                   onclick='return confirm("您是【<%= m.getType()%>】，本次查看消耗【<%=mpt %>个】金币，确定要查看吗?")'><img src="images/lookphone.png" width="100" height="30" /></a>
		                   </td>
		                   <%}
		                   else
		                   { %>
		                    <td  bgcolor="#9bcf00"  background="images/lqtdbg.png" align="center">
		                  	  联系电话：【<font style="font-size:20px; color:#ff0000"><%=requirementinfo.getPhone() %></font>】</td>

		                   <%} %>
		                 </tr>
		         		</tbody>
		         </table>
		     
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
        <h3>推荐学员</h3><span class="more"><a href="#">more</a></span></div>
      <div class="bknr">
        <ul>
         <% ArrayList<Requirement> VIPRequirement = (ArrayList<Requirement>)session.getAttribute("VIPRequirement");
         int reqnum  = VIPRequirement.size() > 5 ? 5 : VIPRequirement.size();
        for(int i = 0;i< reqnum ;i++)
        {
         %>
                 <li><a href="queryRequirementDetail.do?flag=1&&id=<%=VIPRequirement.get(i).getId() %>">
                            <%=VIPRequirement.get(i).getContacts() %>&nbsp;&nbsp;
                            <%=VIPRequirement.get(i).getSubject() %>&nbsp;&nbsp;
                            <%=VIPRequirement.get(i).getArea() %>
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
      <div class="bktop">
        <h3>系统公告</h3><span class="more"><a href="#">more</a></span></div>
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