package session12.dentist;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session12.dentist.dao.ClientDao;
import session12.dentist.dao.ClientHibernateDaoImpl;
import session12.dentist.service.ClientService;
import session12.dentist.service.ClientServiceImpl;
import session12.dentist.view.Menu;

import java.util.Locale;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        // !! IMPORTANT !! this is only example of structure
        SessionFactory sessionFactory = getSessionFactory();
        ClientDao clientDao = new ClientHibernateDaoImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        Menu menu = new Menu(clientService);
        menu.main();
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
