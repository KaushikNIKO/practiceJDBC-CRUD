package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection conn;
	
	public static Connection createC() {
		//load the driver..
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection..
			String username = "root";
			String password = "admin";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
