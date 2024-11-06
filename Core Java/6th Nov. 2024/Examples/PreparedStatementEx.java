package com.mphasis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementEx {

    private static Connection con = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        try {
            // Load and connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

            do {
                // Display menu options
                System.out.println("Select an operation:");
                System.out.println("1. Insert Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Select Employees");
                System.out.println("5. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        // Insert Employee
                        insertEmployee(scanner);
                        break;
                    case 2:
                        // Update Employee
                        updateEmployee(scanner);
                        break;
                    case 3:
                        // Delete Employee
                        deleteEmployee(scanner);
                        break;
                    case 4:
                        // Select Employees
                        selectEmployees();
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
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static void insertEmployee(Scanner scanner) throws SQLException {
        String query = "INSERT INTO emp (id, fname, lname) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();

        stmt.setInt(1, id);
        stmt.setString(2, fname);
        stmt.setString(3, lname);

        int result = stmt.executeUpdate();
        System.out.println(result + " Record Inserted");
    }

    private static void updateEmployee(Scanner scanner) throws SQLException {
        String query = "UPDATE emp SET fname = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);

        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter new First Name: ");
        String fname = scanner.nextLine();

        stmt.setString(1, fname);
        stmt.setInt(2, id);

        int result = stmt.executeUpdate();
        System.out.println(result + " Record Updated");
    }

    private static void deleteEmployee(Scanner scanner) throws SQLException {
        String query = "DELETE FROM emp WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(query);

        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        stmt.setInt(1, id);

        int result = stmt.executeUpdate();
        System.out.println(result + " Record Deleted");
    }

    private static void selectEmployees() throws SQLException {
        String query = "SELECT * FROM emp";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Employee's ID: " + rs.getInt(1));
            System.out.println("Employee's First Name: " + rs.getString(2));
            System.out.println("Employee's Last Name: " + rs.getString(3));
            System.out.println("==========================================");
        }
    }
}
