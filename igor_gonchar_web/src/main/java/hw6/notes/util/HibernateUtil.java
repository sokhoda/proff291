package hw6.notes.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public class HibernateUtil {

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    public SessionFactory getSessionFactory(){
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw6HomeTask/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        return factory;
    }
    public void closeSessionAndFactory(SessionFactory factory, Session session){
        if (session != null) {
            session.close();
        }
        factory.close();
        log.info("Closing factory");
    }


    public static Logger getLog() {
        return log;
    }
}
