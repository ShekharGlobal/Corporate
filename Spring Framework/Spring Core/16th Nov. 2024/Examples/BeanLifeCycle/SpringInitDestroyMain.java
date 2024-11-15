package com.coforge.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringInitDestroyMain {

    public static void main(String[] args) {
        
        // Load the application context from the configuration class
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Country countryObj = appContext.getBean(Country.class);
        
        System.out.println("Country Name: " + countryObj.getCountryName());
        
        // Register shutdown hook to invoke @PreDestroy methods
        appContext.registerShutdownHook();
    }
}
