package com.coforge.bionetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Create Hibernate SessionFactory
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open session and begin transaction
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a new Department
        Department department = new Department("Engineering");

        // Create new Employees
        Employee employee1 = new Employee("Ajay");
        Employee employee2 = new Employee("Rajesh");

        // Add Employees to Department
        department.addEmployee(employee1);
        department.addEmployee(employee2);

        // Persist the Department (cascades to Employees)
        session.persist(department);

        // Commit transaction
        transaction.commit();

        // Fetch and display Department and Employees
        Department foundDepartment = session.get(Department.class, department.getId());
        System.out.println("Department: " + foundDepartment.getName());
        for (Employee employee : foundDepartment.getEmployees()) {
            System.out.println("Employee: " + employee.getName());
        }

        // Close session and factory
        session.close();
        sessionFactory.close();
    }
}
