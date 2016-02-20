package session12;

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
    public static void main(String[] args) {

        SessionFactory sessionFactory =getSessionFactory();
        ClientDao clientDao = new ClientDaoImpl( sessionFactory );
//        clientDao.findAll("Kris","www");
        clientDao.findAllUsersByPortion((long)2);
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
