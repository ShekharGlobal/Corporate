package com.coforge.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static void main(String[] args) {
        
        // Load the application context from the configuration class
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Employee e1 = (Employee) ctx.getBean(Employee.class);
        e1.setCity("Coimbatore");
        e1.display();
        
        Employee e2 = (Employee) ctx.getBean(Employee.class);
        //e2.setCity("Kolkata");
        e2.display();
    }
}
