package cn.edu.cqupt.jiajiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	/**
	 * 获取连接
	 * getConnection
	 * @param name
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");// proxool驱动 类
			Connection conn = DriverManager.getConnection("proxool.jiajiaoProxool");	
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	 /**        
     * 释放连接        
     * freeConnection        
     * @param conn        
     */          
    public static void freeConnection(Connection conn){           
        if(conn!=null){           
            try {           
                conn.close();           
            } catch (SQLException e) {                         
                e.printStackTrace();           
            }           
        }           
    }                  
    
}
