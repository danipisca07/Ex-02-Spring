package it.distributedsystemsm.service;

import it.distributedsystemsm.model.Customer;

import java.util.List;

public interface CustomerService {
   void save(Customer customer);
   void delete(String customer);
   void delete(int customer);
//   void edit(User user);
   List<Customer> list();
}
