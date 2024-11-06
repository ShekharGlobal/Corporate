package com.coforge.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperations {

	public static Connection con = null;

	public Connection createDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "root");
	}

	public static void insertEmployee() throws SQLException {
		Statement st = con.createStatement();
		String s = "insert into Emp(id,fname,lname) values(1,'Naveen','R')";
		int i = st.executeUpdate(s);
		if (i > 0) {
			System.out.println("--Employee is inserted successfully--");
		}
	}

	public void updateEmployee() throws SQLException {
		Statement st = con.createStatement();
		String s = "update Emp set fname='Nakul' where id=3";
		int i = st.executeUpdate(s);
		if (i > 0) {
			System.out.println("--Employee is updated successfully--");
		}
	}

	public void selectEmployee() throws SQLException {
		Statement st = con.createStatement();
		String s = "select * from Emp";
		ResultSet rs = st.executeQuery(s);
		while (rs.next()) {
			System.out.println("Employee ID : " + rs.getInt(1));
			System.out.println("Employee First Name : " + rs.getString(2));
			System.out.println("Employee Last Name : " + rs.getString(3));
			System.out.println("================================");
		}
	}

	public void deleteEmployee() throws SQLException {
        Statement st = con.createStatement();
        String s = "delete from Emp where id=1";
        int i = st.executeUpdate(s);
        if (i > 0) {
            System.out.println("--Employee is deleted successfully--");
        }
	}

	public static void main(String[] args) {
		CRUDOperations co = new CRUDOperations();
		Scanner scanner = new Scanner(System.in);
		int choice;

		try {
			con = co.createDBConnection();

			do {
				System.out.println("Select an operation:");
				System.out.println("1. Insert Employee");
				System.out.println("2. Update Employee");
				System.out.println("3. Delete Employee");
				System.out.println("4. Select Employees");
				System.out.println("5. Exit");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					// Insert Employee
					insertEmployee();
					break;
				case 2:
					// Update Employee
					co.updateEmployee();
					break;
				case 3:
					// Delete Employee
					co.deleteEmployee();
					break;
				case 4:
					// Select Employees
					co.selectEmployee();
					break;
				case 5:
					// Exit
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}

			} while (choice != 5); // Continue until the user selects Exit

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		scanner.close();
	}

}
