package hw6.notes.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Pavel on 10.02.2016.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        }
        return sessionFactory;
    }
}
