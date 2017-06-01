package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.cqupt.jiajiao.domain.Teacher;
import cn.edu.cqupt.jiajiao.util.ConnectionManager;

public class test {


	static Teacher test(Long teacherid) throws SQLException
	{
		String sql = "SELECT * FROM t_teacher WHERE id=?";

		Connection connection = ConnectionManager.getConnection();
		PreparedStatement prestmt = null;
		try {
			prestmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prestmt.setLong(1, teacherid);

		ResultSet rs = prestmt.executeQuery();

		if(rs.next())
		{
			System.out.println("if");
			// 将一项纪录封装成一个Teacher对象
			Teacher t = new Teacher();
			System.out.println(t);
			t.setAddress(rs.getString("address"));
			t.setAuthentication(rs.getString("authentication"));
			t.setBirthday(rs.getString("birthday"));
			t.setCertificate(rs.getString("certificate"));
			t.setDegree(rs.getString("degree"));
			t.setDescription(rs.getString("description"));
			t.setGender(rs.getString("gender"));
			t.setGrade(rs.getString("grade"));
			t.setId(rs.getLong("id"));
			t.setMobilephone(rs.getString("mobilephone"));
			t.setNotes(rs.getString("notes"));
			t.setSalary(rs.getInt("salary"));
			t.setSchool(rs.getString("school"));
			t.setServicearea(rs.getString("servicearea"));
			t.setServicetype(rs.getString("servicetype"));
			t.setSpecialty(rs.getString("specialty"));
			t.setSubject(rs.getString("subject"));
			t.setTeachername(rs.getString("teachername"));
			t.setPhoto(rs.getString("photo"));
			
			rs.close();
			prestmt.close();
			connection.close();
			return t;
		}
		else
		{
			System.out.println("ELSE");
			rs.close();
			prestmt.close();
			ConnectionManager.freeConnection(connection);
			return null;
		}
	}
	
	//模拟Tomcat容器的处理流程
	public static void main(String[] args) throws Exception {
		
		// 1.Tomcat启动，初始化web.xml的所有Servlet
		
		//循环从web.xml文件中读取配置参数并生成相应的对象缓存起来
		while(hasUninitialObectInWebxml()){
			
			//从web.xml文件中读取初始化参数并生成ServletContext对象
			javax.servlet.ServletContext servletContext = getServletContextInstance();
			//将ServletContext缓存到系统中
			cache(servletContext);
			
			//从web.xml文件中读取初始化参数并生成ServletConfig对象
			javax.servlet.ServletConfig servletConfig = getServletConfigInstance();
			//将ServletConfig缓存到系统中
			cache(servletConfig);
			
			//生成一个Servlet对象，此时只是一个普通的对象
			javax.servlet.http.HttpServlet servletInstance = getServletInstance;
			//调用Servlet的init方法，此时该Servlet对象就是一个真正的Servlet了。拥有了作为Servlet的特权。
			servletInstance.init(servletConfig);
			//将Servlet缓存到系统中
			cache(servletInstance);
		}

		
		//2.Tomcat循环处理客户端的请求
		while(true){
			//解析请求对应的Servlet，并从系统中获取对应的Servlet实例。
			javax.servlet.http.HttpServlet servlet  = getServletFromCacheByRequestName();
			//获取由容器实现的HttpServletRequest对象和HttpServletResponse对象
			javax.servlet.http.HttpServletRequest httpServletRequest = getHttpServletRequestInstaceFromContainer();
			javax.servlet.http.HttpServletResponse httpServletResponse = getHttpServletResponseInstaceFromContainer();
			
			httpServletResponse.addHeader("key", "value");
			httpServletResponse.setHeader("key", "value");
			httpServletResponse.sendRedirect("http://www.google.com");
			javax.servlet.ServletContextListener ss = null;
			//开一个新的线程处理对应的请求
			new Thread().start(new RequestTask(servlet,httpServletRequest,httpServletResponse));
			
		}
		//释放系统中的资源
		release();
		
	}
	
	public static void main1(String[] args)
	{
		Teacher t = null;
		try {
			t = test.test(40L);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t);
		
	}
	public static void main2(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Properties info = new Properties();
		info.setProperty("proxool.maximum-connection-count", "20");
		info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
		info.setProperty("user", "root");
		info.setProperty("password", "lq123");
		
		String url = "jdbc:mysql://localhost:3306/db_jiajiao";
		Connection conn = DriverManager.getConnection(url, info);
		
		//Connection conn = new ConnectionManager().getConnection();
		
		String sql = "INSERT INTO t_member(username,password,email,phone,role) values(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt.setString(1,"liuqiang");
		stmt.setString(2,"123123");
		stmt.setString(3,"424321913@qq.com");
		stmt.setString(4,"181716319437");
		stmt.setString(5,"教员");
		//stmt.setDate(6, (Date) new java.util.Date());
		
		stmt.executeUpdate();
	}

}

