package cn.edu.cqupt.jiajiao.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.cqupt.jiajiao.domain.Sysinfo;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.CertificateService;
import cn.edu.cqupt.jiajiao.service.SysinfoService;

public class AddSysinfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddSysinfoServlet() {
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
		
		//用于存放文件在服务器的绝对目录
		String  servFilePath = null;
		
		//封装成Sysinfo对象
		Sysinfo sysinfo = new Sysinfo();
		
		// 遍历所有的表单项
		for (int i = 0; i < items.size(); i++) {
			FileItem item = (FileItem) items.get(i);
			// 如果这个表单是普通表单域
			if (item.isFormField()) {
				// 取得表单名
				String name = item.getFieldName();
				// 取得表单的value值
				String value = item.getString("UTF-8");
				if(name.equals("adminemail"))
					sysinfo.setAdminemail(value);
				if(name.equals("copyright"))
					sysinfo.setCopyright(value);
				if(name.equals("description"))
					sysinfo.setDescription(value);
				if(name.equals("ICP"))
					sysinfo.setICP(value);
				if(name.equals("keywords"))
					sysinfo.setKeywords(value);
				if(name.equals("serviceqq"))
					sysinfo.setServiceqq(value);
				if(name.equals("sitename"))
					sysinfo.setSitename(value);
				if(name.equals("siteurl"))
					sysinfo.setSiteurl(value);
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
				
				//文件存放的绝对目录
				servFilePath = request.getRealPath("/") + "images\\" + "sitelogo"
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
				servFilePath = "images" +servFilePath;
				//持久化
				sysinfo.setSitelogo(servFilePath);
				
			}
		}
		
		SysinfoService ss = new SysinfoService();
		int result = 0;
		try {
			result = ss.update(sysinfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1)
		{	//取得Application对象 
	        ServletContext application=this.getServletContext(); 
            application.setAttribute("sysinfo", sysinfo);	//将参数信息存在application中
            
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('操作成功！');parent.location.href='javascript:history.go(-2);self.location=document.referrer;';</script>");
			
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('操作失败！稍后再试！');parent.location.href='javascript:history.go(-1);';</script>");
			
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
