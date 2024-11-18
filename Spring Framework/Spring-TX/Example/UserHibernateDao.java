package com.coforge.springtx;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserHibernateDao {

    private final SessionFactory sessionFactory;

    public UserHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Save user with transactional behavior
    @Transactional(
        propagation = Propagation.REQUIRED, 
        isolation = Isolation.READ_COMMITTED, 
        readOnly = false, 
        timeout = 10, 
        rollbackFor = {CustomException.class})
    public void saveUser(Usertx user) {
        sessionFactory.getCurrentSession().save(user);

        // Simulating a rollback scenario (if username is "error")
        if (user.getUsername().equals("error")) {
            throw new RuntimeException("Simulated Error: Rollback transaction");
        }
    }
}
