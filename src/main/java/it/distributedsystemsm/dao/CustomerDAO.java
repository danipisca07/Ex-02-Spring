package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Customer;

import java.util.List;

public interface CustomerDAO {

    public void save(Customer customer);

    public void delete(Customer customer);

    public void delete(String name);

    public void delete(int id);

    public Customer find(String name);

    public Customer find(int id);

    public List<Customer> list();
}
