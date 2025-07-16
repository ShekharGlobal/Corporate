package com.example.uni.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		
		Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory =cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Address address = new Address();
		address.setStreet("120, India Gate");
		address.setCity("New Delhi");
		
		
		Person person = new Person();
		
		person.setName("Abhishek");
		person.setAddress(address);
		
		session.save(person);
		
		tx.commit();
		
		
		
		

	}

}
