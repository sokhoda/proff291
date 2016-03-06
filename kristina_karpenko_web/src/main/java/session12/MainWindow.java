package session12;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Администратор on 07.02.2016.
 */
public class MainWindow {
    private static SessionFactory factory;
    public static void main(String[] args) {

        SessionFactory sessionFactory =getSessionFactory();
        ClientDao clientDao = new ClientDaoImpl( sessionFactory );
//        clientDao.findAll("Kris","www");
      //  clientDao.findAllUsersByPortion((long)2);
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
        //    id = (Long) session.save();
            session.getTransaction().commit();

        } catch (HibernateException e) {

            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    private static SessionFactory getSessionFactory() {
    Locale.setDefault(Locale.ENGLISH);
    Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
    StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
    sb.applySettings(cfg.getProperties());
    StandardServiceRegistry standardServiceRegistry = sb.build();

    return cfg.buildSessionFactory(standardServiceRegistry);
}
}
