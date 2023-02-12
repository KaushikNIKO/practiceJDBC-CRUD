package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {
	
	public static boolean insertStudentToDB(Student st)
	{
		boolean flag = false;
		try {
			
			//Jdbc code for addition of student
			Connection conn = CP.createC();
			String query= "insert into students(sname,sphone,scity) values(?,?,?)";
			//Prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			//set value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		
		boolean flag = false;
		try {
			
			//Jdbc code for deletion of student..
			Connection conn = CP.createC();
			String query= "delete from students where sid=?";
			//Prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			//set value of parameter
			pstmt.setInt(1, userId);
			
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	public static void displayAllStudent() {
		
		try {
			
			//Jdbc code for deletion of student..
			Connection conn = CP.createC();
			String query= "select * from students;";
			//statement..
			Statement stmt = conn.createStatement();
			
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next())
			{
			
				int sid = set.getInt("sid");
				String sname = set.getString("sname");
				String sphone = set.getString("sphone");
				String scity = set.getString("scity");
				
				System.out.println("ID: "+sid);
				System.out.println("Name: "+sname);
				System.out.println("Phone: "+sphone);
				System.out.println("City: "+scity);
				System.out.println("____________________________________");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
public static void displayStudentById(String sID) {
		
		try {
			
			//Jdbc code for deletion of student..
			Connection conn = CP.createC();
			String query= "select * from students where sid=?;";
			//statement..
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sID);
			
			ResultSet set = pstmt.executeQuery();
			
			if(set.next())
			{
			
				int sid = set.getInt("sid");
				String sname = set.getString("sname");
				String sphone = set.getString("sphone");
				String scity = set.getString("scity");
				
				System.out.println("ID: "+sid);
				System.out.println("Name: "+sname);
				System.out.println("Phone: "+sphone);
				System.out.println("City: "+scity);
				System.out.println("____________________________________");
			}
			else 
			{
			System.out.println("Student for ID: "+sID+" Not Found!");
			System.out.println("____________________________________");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public static boolean updateStudentName(int userId, String userName) {
		boolean flag = false;
		try {
			
			//Jdbc code to update a student name..
			Connection conn = CP.createC();
			String query= "update students set sname=? where sid=?";
			//Prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			//set value of parameter
			pstmt.setString(1, userName);
			pstmt.setInt(2, userId);
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean updateStudentPhone(int userId, String userPhone) {
		boolean flag = false;
		try {
			
			//Jdbc code to update a student phone..
			Connection conn = CP.createC();
			String query= "update students set sphone=? where sid=?";
			//Prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			//set value of parameter
			pstmt.setString(1, userPhone);
			pstmt.setInt(2, userId);
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean updateStudentCity(int userId, String userCity) {
		boolean flag = false;
		try {
			
			//Jdbc code to update a student city..
			Connection conn = CP.createC();
			String query= "update students set scity=? where sid=?";
			
			//Prepared statement
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//set value of parameter
			pstmt.setString(1, userCity);
			pstmt.setInt(2, userId);
			
			//execute..
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}

}
