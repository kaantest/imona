package imona.dao;

import imona.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void persist(Customer customer) {
        getCurrentSession().persist(customer);
    }

    private Session getCurrentSession() {
        return getSessionFactory().getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
