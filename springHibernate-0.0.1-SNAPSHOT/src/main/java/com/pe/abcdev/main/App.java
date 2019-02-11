package com.pe.abcdev.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successful !!!");
		} catch (Exception e) {
			System.out.println("Connection unsuccessful !!!");
			e.printStackTrace();
		}
	}
}
