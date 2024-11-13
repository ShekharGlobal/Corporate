package com.coforge.unimamytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Create SessionFactory from hibernate.cfg.xml
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a new Department
        Department department = new Department("Engineering");
        session.persist(department);

        // Create a new Employee and associate it with the Department
        Employee employee1 = new Employee("Ajay", department);
        Employee employee2 = new Employee("Rajesh K", department);

        session.persist(employee1);
        session.persist(employee2);

        transaction.commit();

        // Fetch and display employee details
        Employee foundEmployee = session.get(Employee.class, employee1.getId());
        System.out.println("Employee Name: " + foundEmployee.getName());
        System.out.println("Department: " + foundEmployee.getDepartment().getName());

        // Clean up
        session.close();
        sessionFactory.close();
    }
}
