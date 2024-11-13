package com.coforge.unimamytoone;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Fetch Type: By default, @ManyToOne fetches the association eagerly. 
     * If you want to fetch it lazily, you can use 
     * @ManyToOne(fetch = FetchType.LAZY).
     * 
     * Cascade Operations: If you want to propagate operations like 
     * PERSIST or REMOVE from Employee to Department, 
     * you can add cascade = CascadeType.ALL in the 
     * @ManyToOne annotation, but this is rarely needed 
     * in a ManyToOne scenario.
     */
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

 

    public Employee() {}

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
