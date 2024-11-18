package com.coforge.springtx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateMain {

    public static void main(String[] args) {
        // Set up Spring context from HibernateConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
            // Get the UserHibernateDao bean
            UserHibernateDao userDao = context.getBean(UserHibernateDao.class);

            try {
                // Create and save a valid user
                Usertx user1 = new Usertx();
                user1.setUsername("Monika");
                user1.setEmail("monika@gmail.com");
                userDao.saveUser(user1);

                // Simulate error (will cause rollback)
                Usertx user2 = new Usertx();
                user2.setUsername("error"); // Will trigger rollback
                user2.setEmail("error@gmail.com");
                userDao.saveUser(user2);

            } catch (Exception e) {
                System.out.println("Transaction Rolled Back: " + e.getMessage());
            }
        }
    }

