package com.coforge.handson.manytoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Create customers
        Customer customer1 = new Customer("Anil");
        Customer customer2 = new Customer("Anjali");

        // Create orders
        Order order1 = new Order(LocalDate.now(), 150000.0);
        Order order2 = new Order(LocalDate.now(), 200000.0);
        Order order3 = new Order(LocalDate.now(), 30000.0);

        // Assign orders to customers
        customer1.addOrder(order1);
        customer1.addOrder(order2);
        customer2.addOrder(order3);

        // Persist customers (cascade will persist orders as well)
        session.persist(customer1);
        session.persist(customer2);

        tx.commit();

        // Retrieve and display orders for each customer
        displayCustomerOrders(session);

        // Fetch customer details from an order instance
        displayOrderCustomer(session, order1.getId());

        session.close();
        sessionFactory.close();
    }

    private static void displayCustomerOrders(Session session) {
        System.out.println("\nOrders for each customer:");
        for (Customer customer : session.createQuery("FROM Customer", Customer.class).list()) {
            System.out.println(customer.getName() + " has placed the following orders:");
            for (Order order : customer.getOrders()) {
                System.out.println(" - Order ID: " + order.getId() + ", Amount: " + order.getAmount());
            }
        }
    }

    private static void displayOrderCustomer(Session session, Long orderId) {
        Order order = session.find(Order.class, orderId);
        if (order != null) {
            Customer customer = order.getCustomer();
            System.out.println("\nCustomer details for Order ID " + orderId + ":");
            System.out.println("Customer Name: " + customer.getName());
        } else {
            System.out.println("Order not found!");
        }
    }
}
