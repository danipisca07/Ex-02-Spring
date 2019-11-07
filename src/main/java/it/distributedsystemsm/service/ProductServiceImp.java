package it.distributedsystemsm.service;

import it.distributedsystemsm.dao.ProductDAO;
import it.distributedsystemsm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

   @Autowired
   private ProductDAO productDao;

   @Transactional
   public void save(Product product) {
      productDao.save(product);
   }

   @Transactional
   public void delete(int product) {

      for(Product p : list()){
         if (p.getId()==product){
            productDao.delete(p);
         }
      }
   }

   @Transactional
   public void delete(String product) {

      for(Product p : list()){
         if (p.getName().equals(product)){
            productDao.delete(p);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<Product> list() {
      return productDao.list();
   }

}
