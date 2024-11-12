package com.coforge.bionetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Setup Hibernate session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create User and Address
        User user = new User();
        user.setFirstName("Monika");
        user.setLastName("Sharma");

        Address address = new Address();
        address.setStreet("Sarita Vihar");
        address.setCity("New Delhi");
        address.setZipCode("110076");

        // Link User and Address
        user.setAddress(address);
        address.setUser(user);

        // Persist User (Address will be persisted because of CascadeType.ALL)
        session.persist(user);

        session.getTransaction().commit();

        // Fetch User with Address
        session.beginTransaction();
        User fetchedUser = session.get(User.class, user.getId());
        System.out.println("User: " + fetchedUser.getFirstName() + " " + fetchedUser.getLastName());
        System.out.println("Address: " + fetchedUser.getAddress().getStreet());

        session.close();
        sessionFactory.close();
    }
}
