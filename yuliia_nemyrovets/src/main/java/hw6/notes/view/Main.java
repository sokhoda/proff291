package hw6.notes.view;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Юлия on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        NotebookService notebookService = new NotebookServiceImpl(notebookDao);

        Menu menu = new Menu(notebookService);

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