package it.distributedsystemsm.demo.service;

import it.distributedsystemsm.demo.model.User;

import java.util.List;

public interface UserService {
   void save(User user);
   void delete(String user);
//   void edit(User user);
   List<User> list();
}
