package session13;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session13/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);


        Session session = null;
        session = factory.openSession();

        try {
            session.beginTransaction();

            Employer employer1 = new Employer(11);
            Employer employer2 = new Employer(21);
            Employer employer3 = new Employer(31);
            Employer employer4 = new Employer(41);
            Employer employer5 = new Employer(51);
            Employer employer6 = new Employer(61);
            Employer employer7 = new Employer(71);
            Employer employer8 = new Employer(81);
            Employer employer9 = new Employer(91);
            Employer employer10 = new Employer(101);

            Company company1 = new Company("GlobalLogic", 4000000);
            Company company2 = new Company("Luxsoft", 1000000);

            company1.setEmployers(employer1);
            company1.setEmployers(employer2);
            company1.setEmployers(employer3);

            employer1.setCompany(company1);
            employer2.setCompany(company1);
            employer3.setCompany(company1);


            company2.setEmployers(employer4);
            company2.setEmployers(employer5);
            company2.setEmployers(employer6);

            employer4.setCompany(company2);
            employer5.setCompany(company2);
            employer6.setCompany(company2);

            session.save(company1);
            session.save(company2);
//            session.save(employer1);
//            session.save(employer2);
//            session.save(employer3);
//            session.save(employer4);
//            session.save(employer5);
//            session.save(employer6);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
}
