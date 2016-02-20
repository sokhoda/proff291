package hw6.notes.main;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Pavel on 10.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(sessionFactory);
        List<Notebook> allNotebooks = notebookDao.findAll();
        System.out.println(allNotebooks);
    }


    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}
