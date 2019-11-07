package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {

   final static Logger logger = Logger.getLogger(ProductDAOImp.class);

   private static final String TABLE_NAME = "Product";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Product product) {
      sessionFactory.getCurrentSession().save(product);
   }

   @Override
   public void delete(String product) { sessionFactory.getCurrentSession().delete(product);   }

   @Override
   public void delete(int productId) {

      Session session = sessionFactory.openSession();

      Query query = session.createQuery("delete " + TABLE_NAME + " where id = :productId");
      query.setParameter("id", productId);

      //int result = query.executeUpdate(); //TODO HANDLE THIS!

      logger.info("Product " + productId + " was removed");

      session.disconnect();

   }

   @Override
   public Product find(String name) {
      return null;
   } //TODO

   @Override
   public Product find(int id) {
      return null;
   } //TODO

   @Override
   public void delete(Product product) {
      sessionFactory.getCurrentSession().delete(product);
   }

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

   @Override
   public List<Product> list() {

      Session session = sessionFactory.openSession();

      Query q = session.createQuery("From " + TABLE_NAME);

      List<Product> resultList = q.list();
      System.out.println("[DEBUG] num of " + TABLE_NAME + ":" + resultList.size());

      for (Product next : resultList) {
         System.out.println("[DEBUG] next num of " + TABLE_NAME + ":" + next);
      }

      session.disconnect();

      return q.getResultList();
   }
}
