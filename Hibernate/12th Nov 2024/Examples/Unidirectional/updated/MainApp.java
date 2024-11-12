package com.coforge.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {
        // Load Hibernate Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Open session
        Session session = factory.openSession(); 
            Transaction tx = session.beginTransaction();

            // Create Address object
            Address address = new Address();
            address.setStreet("120, India Gate");
            address.setCity("New Delhi");

            // Create Person object and associate with Address
            Person person = new Person();
            person.setName("Abhishek");
            person.setAddress(address);

            // Save the person object (which will also save the address due to cascade)
            session.save(person);

            tx.commit();

            // Fetch the person back to verify the save
            Person savedPerson = session.get(Person.class, person.getId());
            System.out.println("Retrieved Person: " + savedPerson);

         
        }
        
    }

