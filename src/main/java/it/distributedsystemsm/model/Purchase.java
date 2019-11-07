package it.distributedsystemsm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Purchase implements Serializable {

    private static final long serialVersionUID = 4612874195612951296L;

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private int purchaseNumber;

//    @ManyToOne(
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY
//    )
//    private Customer customer;

//    @OneToMany(
//            cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch= FetchType.LAZY,
//            mappedBy = "purchase"
//    )
//    private Set<Product> products;

    public Purchase() {
//        this.customer=new Customer();
    }

    public Purchase(int purchaseNumber) { this.purchaseNumber = purchaseNumber; }

    public Purchase(int purchaseNumber, Customer customer) {
        this.purchaseNumber = purchaseNumber;
//        this.customer = customer;
    }

    public Purchase(int purchaseNumber, Customer customer, Set<Product> products) {
        this.purchaseNumber = purchaseNumber;
//        this.customer = customer;
//        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseNumber() { return id; }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

//    public Customer getCustomer() { return customer; }
//
//    public void setCustomer(Customer customer) { this.customer = customer; }

//    public Set<Product> getProducts() { return products; }
//
//    public void setProducts(Set<Product> products) { this.products = products; }


    @Override
    public String toString() {
        return "PurchaseID: " + id + "- PurchaseNumber: " + purchaseNumber;// + " - CustomerID: " + customer.getId();
    }
}