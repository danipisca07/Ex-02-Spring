package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Customer;
import it.distributedsystemsm.model.Purchase;
import it.distributedsystemsm.model.Product;

import java.util.List;

public interface PurchaseDAO {

    public void save(Purchase purchase);

    //public void removePurchaseByNumber(int purchaseNumber);

    public void delete(int id);

    public void delete(Purchase purchase);

    public Purchase findPurchaseByNumber(int purchaseNumber);

    public Purchase find(int id);

    public List<Purchase> list();

    public List<Purchase> find(Customer customer);

    public List<Purchase> find(Product product);
}
