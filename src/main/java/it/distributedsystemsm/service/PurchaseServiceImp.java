package it.distributedsystemsm.service;

import it.distributedsystemsm.dao.PurchaseDAO;
import it.distributedsystemsm.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImp implements PurchaseService {

   @Autowired
   private PurchaseDAO purchaseDAO;

   @Transactional
   public void save(Purchase purchase) {
      purchaseDAO.save(purchase);
   }

   @Transactional
   public void delete(int purchase) {

      for(Purchase u : list()){
         if (u.getId()==purchase){
            purchaseDAO.delete(u);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<Purchase> list() {
      return purchaseDAO.list();
   }

}
