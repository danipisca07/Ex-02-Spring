package it.distributedsystemsm.service;

import it.distributedsystemsm.model.Purchase;

import java.util.List;

public interface PurchaseService {
   void save(Purchase purchase);
   void delete(int purchaseName);
//   void edit(User user);
   List<Purchase> list();
}
