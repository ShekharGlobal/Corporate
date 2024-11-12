package com.coforge.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LifeCycle {

    public static void main(String[] args) {
        
        // Step 1: Configure and build session factory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // 1. Transient State
        Employee e1 = new Employee();
        e1.setId(146);
        e1.setFirstName("Ak2");
        e1.setLastName("Reddy");

        // Open a session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // 2. Persistent State: Saving the object (this moves the object to persistent state)
        session.save(e1);
        transaction.commit(); // Commit the transaction to persist the object
        System.out.println("Employee saved and in Persistent state: " + e1);

        // Detach State: Closing the session will detach the entity
        session.close();
        System.out.println("Employee in Detached state: " + e1);

        // 3. If you want to delete the entity (Detached State), you need to reattach it to a new session
        Session newSession = factory.openSession();
        Transaction newTransaction = newSession.beginTransaction();

        // Reattach the entity (Detached -> Persistent) using update() or merge()
        newSession.update(e1); // Reattaching the entity

        // 4. Now, you can safely delete it (Removed state)
        newSession.delete(e1); // Mark for deletion
        System.out.println("Employee marked for deletion (Removed state): " + e1);

        // Commit the transaction to delete the entity from the database
        newTransaction.commit();
        newSession.close();

        // Close the session factory
        factory.close();
    }
}
