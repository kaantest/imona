package imona.service;

import imona.dao.CustomerDao;
import imona.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService {

    @Autowired
    private static CustomerDao customerDao;

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = conf.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("name");
        customer.setSurname("surname");

        session.persist(customer);
        session.getTransaction().commit();

        session.close();
    }

}
