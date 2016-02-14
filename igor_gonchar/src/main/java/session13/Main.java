package session13;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.Region;
import session11.HiberConnect;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 13.02.2016.
 */
public class Main {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure("session13/hibernate.cfg.xml");

        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        Session session = null;
        try {
            session = factory.openSession();
            log.info("Connection established");

            Company company1 = new Company("Luxoft", 999999);
            Company company2 = new Company("Cogniance", 888888);

            Employee employee1 = new Employee("Igor");
            Employee employee2 = new Employee("Oleg");
            Employee employee3 = new Employee("Sam");
            Employee employee4 = new Employee("Bob");
            Employee employee5 = new Employee("Anna");
            Employee employee6 = new Employee("Olga");

            session.beginTransaction();

            company1.addEmployee(employee1);
            company1.addEmployee(employee2);
            company1.addEmployee(employee3);
            company2.addEmployee(employee4);
            company2.addEmployee(employee5);
            company2.addEmployee(employee6);
            employee1.addCompany(company1);
            employee2.addCompany(company1);
            employee3.addCompany(company1);
            employee4.addCompany(company2);
            employee5.addCompany(company2);
            employee6.addCompany(company2);

            session.save(company1);
            session.save(company2);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            session.save(employee4);
            session.save(employee5);
            session.save(employee6);

            session.getTransaction().commit();

            session.beginTransaction();
            Company company = (Company) session.createQuery("FROM Company c WHERE c.id =" + 1).uniqueResult();//get 1 element
            System.out.println(company.getEmployees());

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //Rollback DB
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
                log.info("Session closed");
            }
            factory.close();
        }
    }
}
