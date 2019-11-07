package it.distributedsystemsm.demo.dao;

import it.distributedsystemsm.demo.model.User;

import java.util.List;

public interface UserDao {
   void save(User user);
   void delete(User user);
   //void edit(User user);
   List<User> list();
}
