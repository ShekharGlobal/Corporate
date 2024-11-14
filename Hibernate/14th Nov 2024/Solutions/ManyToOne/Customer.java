package com.coforge.handson.manytoone;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
/**
 * In JPA/Hibernate, the orphanRemoval = true attribute
 *  is used in one-to-many and one-to-one relationships
 *   to automatically remove orphaned entities. 
 *   An "orphan" in this context is an entity that is no
 *   longer referenced by its parent entity.
    When you set orphanRemoval = true in a @OneToMany 
    or @OneToOne relationship, if you remove a child 
    entity from the parent entity's collection, 
    the child entity will be deleted from the database automatically.
    It effectively works as a delete-orphan operation.
 * 
 */
    
    /**
     * When we set orphanRemoval = true on the 
     * @OneToMany side (Customer class), 
     * it means that if an Order is removed 
     * from the Customer's list of orders, 
     * Hibernate will automatically delete that
     *  Order record from the database.
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<Order>();

    public Customer() {}
    public Customer(String name) {
        this.name = name;
    }

    // Getters and Setters
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

    public Set<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }
}
