package it.distributedsystemsm.service;

import it.distributedsystemsm.model.Producer;

import java.util.List;

public interface ProducerService {

   void save(Producer producer);

   void delete(int producer);

   void delete(String producer);

//   void edit(User user);

   List<Producer> list();
}
