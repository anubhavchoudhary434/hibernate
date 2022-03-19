package com.logic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pwd = "hbstudent";

		try {
			System.out.println("Connecting to DB: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pwd);
			
			System.out.println("Connection successful!!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
