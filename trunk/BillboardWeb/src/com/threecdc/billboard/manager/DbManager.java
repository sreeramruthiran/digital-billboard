package com.threecdc.billboard.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	
	//Methods Start
	public static Connection getConnection() {
	    Connection conn = null;
	    String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "billboard";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root"; 
	    String password = "supp0rt";
	    try {
	      Class.forName(driver).newInstance();
	      conn = DriverManager.getConnection(url+dbName,userName,password);
	      System.out.println("Connected to the database");
	     
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return conn;
	}
	public static void releaseConnection(Connection releaseConn) {
		if (releaseConn == null)
			return;
		
		 try {
			releaseConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     System.out.println("Disconnected from database");
	}
	
}
