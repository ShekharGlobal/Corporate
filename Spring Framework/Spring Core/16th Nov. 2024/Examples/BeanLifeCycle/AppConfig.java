package com.coforge.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.coforge.beanlifecycles")
public class AppConfig {

    @Bean
    public Country country() {
        Country country = new Country();
        country.setCountryName("India");
        return country;
    }
}
