package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   final static Logger logger = Logger.getLogger(UserDaoImp.class);

   private static final String TABLE_NAME = "User";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void delete(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }

   @Override
   public void delete(String name) {
      sessionFactory.getCurrentSession().delete(name);
   }

   @Override
   public void delete(int userId) {

      Session session = sessionFactory.openSession();

      Query query = session.createQuery("delete " + TABLE_NAME + " where id = :userId");
      query.setParameter("id", userId);

      //int result = query.executeUpdate(); //TODO HANDLE THIS!

      logger.info("User " + userId + " was removed");

      session.disconnect();
   }

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

   @Override
   public List<User> list() {

      Session session = sessionFactory.openSession();

      Query q = session.createQuery("From " + TABLE_NAME);


      List<User> resultList = (List<User>) q.list(); //todo: check the types!
      System.out.println("[DEBUG] num of users:" + resultList.size());

      for (User next : resultList) {
         System.out.println("[DEBUG] next user: " + next.toString());
      }

      session.disconnect();

      return resultList;
   }

}
