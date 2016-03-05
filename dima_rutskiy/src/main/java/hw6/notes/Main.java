package hw6.notes;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.view.Menu;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
        NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
        NotebookService noteService = new NotebookServiceImpl(noteDao);

        Menu menu = new Menu(noteService);
        menu.main();
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw6/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}
