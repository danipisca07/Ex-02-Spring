package it.distributedsystemsm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Producer implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;
//    @OneToMany(
//            cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch= FetchType.LAZY,
//            mappedBy = "producer"
//    )
//    private Set<Product> products;

    public Producer() {}

    public Producer(String name) { this.name = name; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerName() {
        return name;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }


    @Override
    public String toString() {
        return "CustomerId: " + id + " - CustomerName: " +name;
    }
}
