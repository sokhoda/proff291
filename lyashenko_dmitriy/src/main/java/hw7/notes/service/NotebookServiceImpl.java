package hw7.notes.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Admin on 17.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    public NotebookServiceImpl(){}

    public static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("resources.hw7.hw7.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        ssrb.applySettings(cfg.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        return cfg.buildSessionFactory(ssr);
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
    }
}
