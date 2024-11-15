package com.coforge.constructor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("cons.xml");

        // Fetching beans
        Employee emp1 = (Employee) context.getBean("obj");
        Employee emp2 = (Employee) context.getBean("obj2");

        // Displaying employee details
        emp1.display();
        emp2.display();
    }
}
