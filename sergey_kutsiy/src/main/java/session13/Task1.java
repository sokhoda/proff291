package session13;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.HiberConnect;
import session12.User;

import java.util.List;
import java.util.Locale;

/**
 * Created by Сергей on 13.02.2016.
 */

public class Task1 {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    public static void main(String[] args) {

        SessionFactory factory = getSessionFactory();
        Session session = null;
        try {
            session = factory.openSession();

            Company comp1 = new Company("MyComp", 10);
            Company comp2 = new Company("MyComp", 20);

            Employee emp1 = new Employee(comp1, "Andrey", "Ivanov");
            Employee emp2 = new Employee(comp1, "Sergey", "Ivanov");
            Employee emp3 = new Employee(comp1, "Ivan", "Ivanov");
            Employee emp4 = new Employee(comp2, "Andrey", "Ivanov");
            Employee emp5 = new Employee(comp2, "Andrey", "Ivanov");
            Employee emp6 = new Employee(comp2, "Andrey", "Ivanov");

            comp1.addEmployee(emp1);
            comp1.addEmployee(emp2);
            comp1.addEmployee(emp3);

            comp2.addEmployee(emp4);
            comp2.addEmployee(emp5);
            comp2.addEmployee(emp6);

            session.beginTransaction();
            log.info("Transaction  start");
            session.save(comp1);
            session.save(comp2);

            session.save(emp1);
            session.save(emp2);
            session.save(emp3);
            session.save(emp4);
            session.save(emp5);
            session.save(emp6);

            log.info("Transaction  save");
            session.getTransaction().commit();
            log.info("Transaction  test");

        } catch (HibernateException e) {
            if (session!=null) {
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
        Configuration cfg = new Configuration().configure("session13/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }

}
