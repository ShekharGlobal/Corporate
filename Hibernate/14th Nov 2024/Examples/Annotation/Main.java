package com.coforge.annotation;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Creating and saving an Event
        Event event = new Event();
        event.setName("Hibernate Workshop");
        event.setEventDate(new Date());
        event.setEventTimestamp(new Date());
        session.save(event);

        // Creating and saving a User
        User user = new User();
        user.setFirstName("Gopal");
        user.setLastName("Kumar");
        session.save(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("Event and User records saved successfully.");
    }
}
