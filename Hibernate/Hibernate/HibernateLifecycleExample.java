package com.example.lifecycle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateLifecycleExample {
    public static void main(String[] args) {
        // Step 1: Transient State
        Employee employee = new Employee();  // Transient
        employee.setId(1);
        employee.setName("Ajay Kumar");
        employee.setDepartment("IT");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Step 2: Persistent State
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);  // Persistent
        session.getTransaction().commit();
        
        // Step 3: Detached State
        session.close();  // Detached
        employee.setName("Vijay Kumar");  // Changes not synced
       
        // Reattach to a new session
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        session2.update(employee);  // Persistent again
        session2.getTransaction().commit();
        
       
        // Step 4: Removed State
        Session removeSession = sessionFactory.openSession();
        removeSession.beginTransaction();
        removeSession.delete(employee);  // Removed
        removeSession.getTransaction().commit();
        removeSession.close();
       
    }
}
