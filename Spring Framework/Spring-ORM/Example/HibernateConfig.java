package com.coforge.springhb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.coforge.springhb") 
public class HibernateConfig {

    // DataSource Bean for MySQL
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/coforge"); // Replace with your MySQL URL
        dataSource.setUsername("root"); // Replace with your MySQL username
        dataSource.setPassword("root"); // Replace with your MySQL password
        return dataSource;
    }

    // SessionFactory Bean with MySQL dialect
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.coforge.springhb"); // Scan your entity package
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // MySQL dialect
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update"); // Automatically update schema (for development)
        hibernateProperties.put("hibernate.show_sql", "true"); // Show SQL in logs (optional)
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    // Transaction Manager
    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}
