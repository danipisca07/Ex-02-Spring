package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Producer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducerDAOImp implements ProducerDAO {

   final static Logger logger = Logger.getLogger(ProducerDAOImp.class);

   private static final String TABLE_NAME = "Producer";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Producer producer) {
      sessionFactory.getCurrentSession().save(producer);
   }

   @Override
   public void delete(String producer) { sessionFactory.getCurrentSession().delete(producer);    }

   @Override
   public void delete(int producerId) {

      Session session = sessionFactory.openSession();

      Query query = session.createQuery("delete " + TABLE_NAME + " where id = :producerId");
      query.setParameter("id", producerId);

      //int result = query.executeUpdate(); //TODO HANDLE THIS!

      logger.info("Producer " + producerId + " was removed");

      session.disconnect();

   }

   @Override
   public Producer find(String name) {
      return null;
   } //TODO

   @Override
   public Producer find(int id) {
      return null;
   } //TODO

   @Override
   public void delete(Producer producer) {
      sessionFactory.getCurrentSession().delete(producer);
   }

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

   @Override
   public List<Producer> list() {

      Session session = sessionFactory.openSession();

      Query q = session.createQuery("From " + TABLE_NAME);

      List<Producer> resultList = q.list();
      System.out.println("[DEBUG] num of " + TABLE_NAME + ":" + resultList.size());

      for (Producer next : resultList) {
         System.out.println("[DEBUG] next num of " + TABLE_NAME + ":" + next);
      }

      session.disconnect();

      return q.getResultList();
   }
}
