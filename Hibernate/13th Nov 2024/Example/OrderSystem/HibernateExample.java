package com.coforge.ordersystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateExample {
    public static void main(String[] args) {
        // Configure and build the SessionFactory
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session and start a transaction
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create a Customer
        Customer customer = new Customer("Abhishek");

        // Create Orders
        Order order1 = new Order();
        order1.setAmount(15000.00);
        Order order2 = new Order();
        order2.setAmount(25000.00);

        // Establish relationships
        customer.addOrder(order1);
        customer.addOrder(order2);

        // Persist the Customer (Orders will be persisted due to CascadeType.ALL)
        session.persist(customer);

        // Commit the transaction
        transaction.commit();

        // Fetch and display details
        Customer foundCustomer = session.get(Customer.class, customer.getId());
        System.out.println("Customer: " + foundCustomer.getName());
        for (Order order : foundCustomer.getOrders()) {
            System.out.println("Order ID: " + order.getId() + ", Amount: " + order.getAmount());
        }

        // Close session and factory
        session.close();
        sessionFactory.close();
    }
}
