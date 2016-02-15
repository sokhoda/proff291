package hw7;

import hw6.notes.dao.NotebookDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Home on 14.02.2016.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        log.info("Session opened");
        if (session != null) {
            session.close();
        }
        sessionFactory.close();
        log.info("Closing factory");

      /*  ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        Menu menu = new Menu(clientService);
        menu.main();*/
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}
