package it.distributedsystemsm.service;

import it.distributedsystemsm.model.Product;

import java.util.List;

public interface ProductService {

   void save(Product product);

   void delete(int product);

   void delete(String product);

//   void edit(User user);

   List<Product> list();
}
