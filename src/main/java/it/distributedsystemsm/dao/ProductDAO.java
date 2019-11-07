package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Product;

import java.util.List;

public interface ProductDAO {

    public void save(Product product);

    public void delete(Product product);

    public void delete(String name);

    public void delete(int id);

    public Product find(String name);

    public Product find(int id);

    public List<Product> list();
}
