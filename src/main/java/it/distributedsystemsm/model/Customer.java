package it.distributedsystemsm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Customer implements Serializable {

    private static final long serialVersionUID = 318274891481L;


    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String name;
//    @OneToMany(
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY,
//            mappedBy = "customer"
//    )
//    private Set<Purchase> purchases;

    public Customer() {}

    public Customer(String name) { this.name = name; }

    public Customer(String name, Set<Purchase> purchases) {
        this.name = name;
//        this.purchases = purchases;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


//    public Set<Purchase> getPurchases() { return purchases; }
//
//    public void setPurchases(Set<Purchase> purchases) { this.purchases = purchases; }


    @Override
    public String toString() {
        return "CustomerID: " + id + " - CustomerName: " + name;
    }
}