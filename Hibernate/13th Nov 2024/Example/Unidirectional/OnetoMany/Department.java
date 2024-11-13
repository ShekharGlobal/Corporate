package com.coforge.unimamytoone;
import jakarta.persistence.*;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

  //Unidirectional: The Department entity does
    //not know about Employee.

    public Department() {}
    
    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
