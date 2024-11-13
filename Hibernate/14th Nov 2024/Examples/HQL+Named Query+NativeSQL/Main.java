package com.coforge.query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create and persist new Users
        User user1 = new User();
        user1.setFirstName("Gopal");
        user1.setLastName("Kumar");

        User user2 = new User();
        user2.setFirstName("Amit");
        user2.setLastName("Sharma");

        session.save(user1);
        session.save(user2);

        session.getTransaction().commit();

        // Begin new transaction for querying
        session.beginTransaction();

        // 1. HQL Query Example
        System.out.println("\n=== HQL Query ===");
        String hql = "FROM User u WHERE u.firstName = :firstName";
        Query<User> hqlQuery = session.createQuery(hql, User.class);
        hqlQuery.setParameter("firstName", "Gopal");
        List<User> hqlResult = hqlQuery.getResultList();
        for (User user : hqlResult) {
            System.out.println("HQL Result: " + user.getFullName());
        }

        // 2. Named Query Example
        System.out.println("\n=== Named Query ===");
        Query<User> namedQuery = session.createNamedQuery("User.findByLastName", User.class);
        namedQuery.setParameter("lastName", "Sharma");
        List<User> namedResult = namedQuery.getResultList();
        for (User user : namedResult) {
            System.out.println("Named Query Result: " + user.getFullName());
        }

        // 3. Native SQL Query Example
        System.out.println("\n=== Native SQL Query ===");
        String sql = "SELECT * FROM User WHERE first_name = :firstName";
        Query<User> nativeQuery = session.createNativeQuery(sql, User.class);
        nativeQuery.setParameter("firstName", "Amit");
        List<User> nativeResult = nativeQuery.getResultList();
        for (User user : nativeResult) {
            System.out.println("Native SQL Query Result: " + user.getFullName());
        }

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
