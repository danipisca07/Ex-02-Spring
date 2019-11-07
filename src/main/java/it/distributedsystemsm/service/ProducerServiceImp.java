package it.distributedsystemsm.service;

import it.distributedsystemsm.dao.ProducerDAO;
import it.distributedsystemsm.model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProducerServiceImp implements ProducerService {

   @Autowired
   private ProducerDAO producerDAO;

   @Transactional
   public void save(Producer producer) {
      producerDAO.save(producer);
   }

   @Transactional
   public void delete(int producer) {
      for(Producer p : list()){
         if (p.getId()==producer){
            producerDAO.delete(p);
         }
      }
   }

   @Transactional
   public void delete(String producer) {

      for(Producer p : list()){
         if (p.getName().equals(producer)){
            producerDAO.delete(p);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<Producer> list() {
      return producerDAO.list();
   }

}
