package it.distributedsystemsm.dao;

import it.distributedsystemsm.controller.HomeController;
import it.distributedsystemsm.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImp implements CustomerDAO {

   final static Logger logger = Logger.getLogger(CustomerDAOImp.class);

   private static final String TABLE_NAME = "Customer";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Customer customer) {
      sessionFactory.getCurrentSession().save(customer);
   }

   @Override
   public void delete(String customerName) { sessionFactory.getCurrentSession().delete(customerName);   }

   @Override
   public void delete(int customerId) {

      Session session = sessionFactory.openSession();

      Query query = session.createQuery("delete " + TABLE_NAME + " where id = :customerId");
      query.setParameter("id", customerId);

      //int result = query.executeUpdate(); //TODO HANDLE THIS!

      logger.info("Customer " + customerId + " was removed");

      session.disconnect();
   }

   @Override
   public Customer find(String name) {
      return null;
   } //TODO

   @Override
   public Customer find(int id) {
      return null;
   } //TODO

   @Override
   public void delete(Customer customer) {
      sessionFactory.getCurrentSession().delete(customer);
   }

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

   @Override
   public List<Customer> list() {

      Session session = sessionFactory.openSession();

      Query q = session.createQuery("From " + TABLE_NAME);

      List<Customer> resultList = q.list();
      logger.debug("num of " + TABLE_NAME + ":" + resultList.size());

      for (Customer next : resultList) {
         logger.debug("next num of " + TABLE_NAME + ":" + next);
      }

      session.disconnect();

      return q.getResultList();
   }
}
