package it.distributedsystemsm.demo.dao;

import it.distributedsystemsm.demo.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

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

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

   @Override
   public List<User> list() {
      @SuppressWarnings("unchecked")
//      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//      return query.getResultList();

      Session session = sessionFactory.openSession();

//      for(String key : session.getProperties().keySet() ){
//         System.out.println("[DEBUG] key: " + key + " - property : " + session.getProperties().get(key));
//      }
//          System.out.println(session.getProperties());

//      session.beginTransaction();
//
//      Department department = new Department("java");
//      session.save(department);
//
//      session.save(new Employee("Jakab Gipsz",department));
//      session.save(new Employee("Captain Nemo",department));
//
//      session.getTransaction().commit();

          Query q = session.createQuery("From User");

      List<User> resultList = q.list();
      System.out.println("[DEBUG] num of employees:" + resultList.size());

      for (User next : resultList) {
         System.out.println("[DEBUG] next employee: " + next);
      }

      return q.getResultList();
   }

}
