package com.coforge.annotation;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Transient
    private String fullName;

    // Getter for fullName
    public String getFullName() {
        // Optional: If fullName is null, derive it
        if (fullName == null) {
            return firstName + " " + lastName;
        }
        return fullName;
    }

    // Setter for fullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getters and Setters for other fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Optional: Update fullName whenever firstName or lastName is set
    @PrePersist
    @PreUpdate
    private void updateFullName() {
        this.fullName = firstName + " " + lastName;
    }
}
