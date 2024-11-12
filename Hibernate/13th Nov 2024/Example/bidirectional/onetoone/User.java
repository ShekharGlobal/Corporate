package com.coforge.bionetoone;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
/**
 * @OneToOne(mappedBy = "user", cascade = CascadeType.ALL) 
 * indicates that this is the inverse (non-owning) side of
 * the relationship.
 * 
 * mappedBy = "user" specifies that the user field in the
 *  Address entity owns the relationship.
 * 
 */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setUser(this); // Ensure bidirectional link
    }
}
