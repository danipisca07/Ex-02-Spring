package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Customer;
import it.distributedsystemsm.model.Product;
import it.distributedsystemsm.model.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseDAOImp implements PurchaseDAO {

    final static Logger logger = Logger.getLogger(ProducerDAOImp.class);

    private static final String TABLE_NAME = "Purchase";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Purchase purchase) {
        sessionFactory.getCurrentSession().save(purchase);
    }

//   public void add(Product product) { //TODO: handle better this!
//      sessionFactory.getCurrentSession().save(product);
//   }

    @Override
    public void delete(int purchaseId) {

        Session session = sessionFactory.openSession();

        Query query = session.createQuery("delete " + TABLE_NAME + " where id = :purchaseId");
        query.setParameter("id", purchaseId);

        //int result = query.executeUpdate(); //TODO HANDLE THIS!

        logger.info("Purchase " + purchaseId + " was removed");

        session.disconnect();
    }


    @Override
    public void delete(Purchase purchase) {
        sessionFactory.getCurrentSession().delete(purchase);
    }

    @Override
    public Purchase findPurchaseByNumber(int purchaseNumber) {
        return null;
    } //TODO

    @Override
    public Purchase find(int id) {
        return null;
    } //TODO

//   @Override
//   public void edit(User user) {       sessionFactory.getCurrentSession().edit(user);    }

    @Override
    public List<Purchase> list() {

        Session session = sessionFactory.openSession();

        Query q = session.createQuery("From " + TABLE_NAME);

        List<Product> resultList = q.list();
        System.out.println("[DEBUG] num of " + TABLE_NAME + ":" + resultList.size());

        for (Product next : resultList) {
            System.out.println("[DEBUG] next num of " + TABLE_NAME + ":" + next);
        }

        session.disconnect();

        return q.getResultList();
    }

    @Override
    public List<Purchase> find(Customer customer) {
        return null;
    }

    @Override
    public List<Purchase> find(Product product) {
        return null;
    }
}
