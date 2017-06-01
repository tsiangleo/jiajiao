package cn.edu.cqupt.jiajiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * 数据库连接类
 * @author liuqiang
 *
 */
public class DBConnection2 {
	public static Connection getConnection()
	{
		 Connection conn = null;
		//从连接池中获得数据库连接对象
		try {
			conn = DriverManager.getConnection("proxool.jiajiaoProxool");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}	
}