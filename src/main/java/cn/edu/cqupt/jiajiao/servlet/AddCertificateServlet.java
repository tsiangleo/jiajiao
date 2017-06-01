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

import cn.edu.cqupt.jiajiao.domain.Certificate;
import cn.edu.cqupt.jiajiao.domain.Member;
import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.service.CertificateService;
import cn.edu.cqupt.jiajiao.service.MemberService;
import cn.edu.cqupt.jiajiao.service.TeacherService;

public class AddCertificateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCertificateServlet() {
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
		  
		//先判断用户是否认证过，没有认证才需认证
		
		//获得该教员对应的账户ID
		HttpSession session = request.getSession(false);
		Member member = null;
		Long memeberid = null;
		if(session != null)
		{
			member = (Member)session.getAttribute("member");
			memeberid = member.getId();
		}
		
		TeacherService mb = new TeacherService();
		Teacher t = null;
		try {
			t = mb.findTeacherByMemid(memeberid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		CertificateService ss = new CertificateService();
		Certificate resut = null;
		try {
			resut = ss.findCertificateByTeacherId(t.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(resut != null)
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您已经提交过认证信息了，不能重复提交！');parent.location.href='memberCenter.jsp';</script>");
			return;
		}
		
		if(t.getAuthentication().equals("已认证"))
		{
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('您已经认证【通过了】，不能重复认证！');parent.location.href='memberCenter.jsp';</script>");

		}
		else
		{
			Certificate certificate = new Certificate();
			certificate.setTeacherid(t.getId());
			
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
			
			// 遍历所有的表单项
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);
				// 如果是文件域，且用户选择了上传文件
				if (!item.isFormField() &&  !item.getName().equals("")) {
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
					servFilePath = request.getRealPath("/") + "certificate\\" + System.currentTimeMillis()
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
					servFilePath = "../certificate" +servFilePath;

					if(fieldName.equals("cct"))
						certificate.setCct(servFilePath);
					if(fieldName.equals("cet4"))
						certificate.setCet4(servFilePath);
					if(fieldName.equals("cet6"))
						certificate.setCet6(servFilePath);
					if(fieldName.equals("graduate"))
						certificate.setGraduate(servFilePath);
					if(fieldName.equals("idcard"))
						certificate.setIdcard(servFilePath);
					if(fieldName.equals("ielts"))
						certificate.setIelts(servFilePath);
					if(fieldName.equals("stucard"))
						certificate.setStucard(servFilePath);
					if(fieldName.equals("tem8"))
						certificate.setTem8(servFilePath);
					if(fieldName.equals("toefl"))
						certificate.setToefl(servFilePath);
					if(fieldName.equals("undergraduate"))
						certificate.setUndergraduate(servFilePath);
					
				}
			}
			
			//保存certificate
			CertificateService cs = new CertificateService();
			int result = 0;
			try {
				result = cs.sava(certificate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result == 1)
			{
				TeacherService ts = new TeacherService();
				//更新Teacher表的HasCertificate字段
				try {
					ts.updateHasCertificate(t.getId(),"是");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('您认证信息提交成功！我们会尽快认证！');parent.location.href='memberCenter.jsp';</script>");

			}
			else
			{
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.println("<script>alert('认证信息提交失败，稍后再试！');parent.location.href='memberCenter.jsp';</script>");

			}
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
