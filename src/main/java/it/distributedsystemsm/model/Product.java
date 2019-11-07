package it.distributedsystemsm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Product implements Serializable {

    private static final long serialVersionUID = 7879128649212648629L;

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private int productNumber;
    private String name;
    private int price;
//    @ManyToOne(
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY
//    )
//    private Purchase purchase;
//    @ManyToOne(
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY
//    )
//    private Producer producer;

    public Product() {
//        this.producer=new Producer();
//        this.purchase=new Purchase();
    }

    public Product(String name) { this.name = name; }

    public Product(String name, int price) { this.name = name; this.price = price; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductNumber() { return productNumber; }

    public void setProductNumber(int productNumber) { this.productNumber = productNumber; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


//    public Purchase getPurchase() {
//        return this.purchase;
//    }
//
//    public void setPurchase(Purchase purchase) {
//        this.purchase = purchase;
//    }


//    public Producer getProducer() {
//        return producer;
//    }

//    public void setProducer(Producer producer) {
//        this.producer = producer;
//    }

    public String getProductName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductId: " + id + " - ProductNumber: " + productNumber + " - ProductName: " + name + " - Price: " + price;
//        + " - " +  producer.getId() + " - " + purchase.getId();
    }
}
