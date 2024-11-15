package com.coforge.beanlifecycle;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Country {

    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @PostConstruct
    public void init() {
        System.out.println("In init block of country");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In destroy block of country");
    }
}
