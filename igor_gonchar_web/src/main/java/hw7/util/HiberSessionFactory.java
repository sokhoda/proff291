package hw7.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

/**
 * Created by i.gonchar on 2/16/2016.
 */
public class HiberSessionFactory {

    public static SessionFactory getSessionFactory() {
        //Locale.setDefault(Locale.ENGLISH);
        // Without Spring
        /*Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry); */

        return null;

    }
}