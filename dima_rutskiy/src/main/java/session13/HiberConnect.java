package session13;

import Session11_1.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session13/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();

            Company IBM=new Company(100,"IBM");
            Company ASUS=new Company(100,"ASUS");
            Employee emp1=new Employee();
            Employee emp2=new Employee();
            Employee emp3=new Employee();
            Employee emp4=new Employee();
            Employee emp5=new Employee();
            Employee emp6=new Employee();

            emp1.addCompany(IBM);
            emp2.addCompany(IBM);
            emp3.addCompany(IBM);
            emp4.addCompany(IBM);
            emp5.addCompany(ASUS);
            emp6.addCompany(ASUS);

            IBM.addEmplToComp(emp1);
            IBM.addEmplToComp(emp2);
            IBM.addEmplToComp(emp3);
            IBM.addEmplToComp(emp4);

            ASUS.addEmplToComp(emp5);
            ASUS.addEmplToComp(emp6);

            session.save(IBM);
            session.save(ASUS);
            session.save(emp1);
            session.save(emp2);
            session.save(emp2);
            session.save(emp3);
            session.save(emp4);
            session.save(emp5);
            session.save(emp6);


            session.getTransaction().commit();

            log.info("Connection established");
            log.info(session);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if(session!=null) {
                session.getTransaction().rollback();

            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11_1/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}

