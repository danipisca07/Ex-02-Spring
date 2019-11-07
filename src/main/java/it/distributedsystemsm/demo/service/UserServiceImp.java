package it.distributedsystemsm.demo.service;

import it.distributedsystemsm.demo.dao.UserDao;
import it.distributedsystemsm.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   public void save(User user) {
      userDao.save(user);
   }

   @Transactional
   public void delete(String name) {

      for(User u : list()){
         if (u.getName().equals(name)){
            userDao.delete(u);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<User> list() {
      return userDao.list();
   }

}
