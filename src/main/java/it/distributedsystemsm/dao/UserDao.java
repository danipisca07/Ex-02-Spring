package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.User;

import java.util.List;

public interface UserDao {
   void save(User user);

   void delete(User user);

   void delete(String user);

   void delete(int user);

   //void edit(User user);

   List<User> list();
}
