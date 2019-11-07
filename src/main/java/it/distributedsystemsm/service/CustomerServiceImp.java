package it.distributedsystemsm.service;

import it.distributedsystemsm.dao.CustomerDAO;
import it.distributedsystemsm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

   @Autowired
   private CustomerDAO customerDAO;

   @Transactional
   public void save(Customer customer) {
      System.out.println("Saving: " + customer.toString());
      customerDAO.save(customer);
   }

   @Transactional
   public void delete(int customer) {
      for(Customer c : list()){
         if (c.getId()==customer){
            customerDAO.delete(c);
         }
      }
   }

   @Transactional
   public void delete(String customer) {

      for(Customer c : list()){
         if (c.getName().equals(customer)){
            customerDAO.delete(c);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<Customer> list() {
      return customerDAO.list();
   }

}
