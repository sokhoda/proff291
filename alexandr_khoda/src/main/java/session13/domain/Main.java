package session13.domain;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by s_okhoda on 13.02.2016.
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    public static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg =
                new Configuration().configure("session13/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }


    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();


        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Company comp1 = new Company("Siemens", 1E6);
            Company comp2 = new Company("Oracle", 2E6);
//            session.save(comp1);
//            session.save(comp2);
//            session.getTransaction().commit();
//
//            session.beginTransaction();
            for (int i = 0; i < 3; i++) {
                employees.add(new Employee(comp1));
                comp1.getEmployee().add(employees.get(i));
                session.save(employees.get(i));
            }
            for (int i = 3; i < 6; i++) {
                employees.add(new Employee(comp2));
                comp2.getEmployee().add(employees.get(i));
                session.save(employees.get(i));
            }
            session.save(comp1);
            session.save(comp2);
            session.getTransaction().commit();

            System.out.println("\nCompanies:");
            System.out.println(comp1.toString());
            System.out.println(comp2.toString());

            System.out.print("\nEmployees:");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i).toString1());
            }



        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();

        } finally {
            session.close();
        }


    }
}