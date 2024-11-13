package com.coforge.bimanytoone;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Set up Hibernate SessionFactory
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session and begin transaction
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a Department
        Department department = new Department("Engineering");

        // Create Employees
        Employee employee1 = new Employee("Ajay");
        Employee employee2 = new Employee("Rajesh K");

        // Establish bidirectional relationship
        employee1.setDepartment(department);
        employee2.setDepartment(department);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);
        department.setEmployees(employees);

        // Persist data
        session.persist(department);

        // Commit the transaction
        transaction.commit();

        // Fetch department and display employee details
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
