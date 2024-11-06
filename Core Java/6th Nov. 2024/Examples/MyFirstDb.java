package com.coforge.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstDb {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Step 2 - Register the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 3 - Establish connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

			// Step 4 - Creating statement
			stmt = con.createStatement();

			// Step 5 - Execute query
			rs = stmt.executeQuery("select * from emp");

			// Process results
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First Name: " + rs.getString(2));
				System.out.println("==============================");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			//e.printStackTrace();  // Print stack trace for debugging
		} finally {
			// Close resources only if they were initialized
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("Exception while closing resources: " + e.getMessage());
			}
		}
	}
}
