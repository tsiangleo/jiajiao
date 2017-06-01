package cn.edu.cqupt.jiajiao.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.CertificateService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class UpdateTeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateTeacherServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader("Expires",0);
		  
		String flagstr = request.getParameter("flag");
		Integer flag = Integer.parseInt(flagstr);
		
		switch(flag)
		{
		case 1:
			//修改教员信息
			
			String yearstr = null;
			String monthstr = null;
			String daystr = null;
			Integer year = null,month = null,day = null;

			//获得照片
			// 创建一个文件上传的工厂实例
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置文件缓存地址和缓存大小
			factory.setRepository(new File(request.getRealPath("/")));
			factory.setSizeThreshold(1024 * 1024 * 20);
			// 用上工厂实例创建一个上传文件对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 处理页面传过来的表单项
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//用于存放文件在服务器的目录地址
			String  servFilePath = null;
			
			//封装成Teacher对象
			Teacher teacher = new Teacher();
			
			// 遍历所有的表单项
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);
				// 如果这个表单是普通表单域
				if (item.isFormField()) {
					// 取得表单名
					String name = item.getFieldName();
					// 取得表单的value值
					String value = item.getString("UTF-8");
					if(name.equals("address"))
						teacher.setAddress(value);
					if(name.equals("certificate"))
							teacher.setCertificate(value);
					if(name.equals("degree"))
						teacher.setDegree(value);
					if(name.equals("description"))
						teacher.setDescription(value);
					if(name.equals("gender"))
						teacher.setGender(value);
					if(name.equals("grade"))
						teacher.setGrade(value);
					if(name.equals("mobilephone"))
						teacher.setMobilephone(value);
					if(name.equals("notes"))
						teacher.setNotes(value);
					if(name.equals("salary"))
						teacher.setSalary(Integer.parseInt(value));
					if(name.equals("school"))
						teacher.setSchool(value);
					if(name.equals("servicearea"))
						teacher.setServicearea(value);
					if(name.equals("servicetype"))
						teacher.setServicetype(value);
					if(name.equals("specialty"))
						teacher.setSpecialty(value);
					if(name.equals("subject"))
						teacher.setSubject(value);
					if(name.equals("teachername"))
						teacher.setTeachername(value);
					if(name.equals("year"))
					{	
						yearstr = value;
						year = Integer.parseInt(yearstr);
					}
					if(name.equals("month"))
					{	
						monthstr = value;
						month = Integer.parseInt(monthstr);
					}
					if(name.equals("day"))
					{	
						daystr = value;
						day = Integer.parseInt(daystr);
					}
				}
				// 如果是文件域，且用户选择了上传文件
				else if(!item.getName().equals("")) {

					// 取得文件域的表单域名
					String fieldName = item.getFieldName();
					// 取得文件名
					String fileName = item.getName();
					// 取得文件类型
					String contentType = item.getContentType();
					
					if(!contentType.equals("image/bmp") && !contentType.equals("image/tiff")
							&& !contentType.equals("image/png") && !contentType.equals("image/jpeg")
							&& !contentType.equals("image/gif") && !contentType.equals("image/bmp"))

					{
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter();
						out.println("<script>alert('文件类型只能是图片文件，请选择图片文件！');this.location.href='javascript:history.go(-1);';</script>");
						return;
					}
					
					servFilePath = request.getRealPath("/") + "upLoadFile\\" + System.currentTimeMillis()
					+ fileName.substring(fileName.lastIndexOf("."),fileName.length());
				
					// 对于上传文件的存放地址来建立一个输出流
					FileOutputStream fos = new FileOutputStream(servFilePath);
					// 判断上传文件是否在缓存中
					// 得到上传文件输入流
					InputStream is = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len;
					// 将上传文件写入服务器文件中
					while ((len = is.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					is.close();
					fos.close();
					
					//文件上传时获取的是绝对路径，存储到数据库是只存储相对路径
					servFilePath = servFilePath.replace('\\', '/');
					servFilePath = servFilePath.substring(servFilePath.lastIndexOf('/'));
					servFilePath = "upLoadFile" +servFilePath;
					//持久化
					teacher.setPhoto(servFilePath);
					
				}
			}
			
			String birthday = year + "-" + ((month > 9)? month:"0" + month) + "-" + ((day > 9)? day:"0" + day);			
	        teacher.setBirthday(birthday);

	        Member member = null;
	        Long memberid7 = null;
	    	HttpSession session7 = request.getSession(false);
	    	if(session7 != null)
	    	{
		    	member = (Member)session7.getAttribute("member");
				memberid7 = member.getId();
		    }
	        teacher.setMemberid(memberid7);

	        TeacherService ms7  = new TeacherService();
			int result7 = 0;
			try {
				result7 = ms7.upadte(teacher);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(result7 == 1)	//保存成功
			{
				//更新头像信息
				if(teacher.getPhoto() != null)
					session7.setAttribute("photo", teacher.getPhoto());
				
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('信息更新成功！');parent.location.href='memberCenter.jsp';</script>");
		
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('信息更新失败，稍后再试！');parent.location.href='memberCenter.jsp';</script>");
			
				
			}
			break;
		case 2://后台修改教员的认证状态
			String idstr = request.getParameter("id");
			Long id = Long.parseLong(idstr);
			String authentication = request.getParameter("authentication");
			
			TeacherService ts = new TeacherService();
			int result = 0;
			try {
				result = ts.updateAuthentication(id, authentication);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == 1)
			{
				//删除certificate表中该用户上传的记录
				CertificateService cs = new CertificateService();
				try {
					cs.deleteCertificate(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作成功！');window.location.href='queryTeacher.do?flag=3';</script>");
				
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
				
			}
			break;
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
