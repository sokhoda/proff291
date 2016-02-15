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
import java.util.Scanner;

/**
 * Created by s_okhoda on 13.02.2016.
 */
public class Task2 {

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
            Query query = session.createQuery("from Company");

            List clist = query.list();
            if (clist == null){
                System.out.println("Company list is null. Exiting application" +
                        ".");
                return;
            }
            System.out.println("\nCompanies:");
            for (int i = 0; i < clist.size(); i++) {
                System.out.println(clist.get(i).toString());
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter company id:");
            Long cid = scan.nextLong();

            Company comp1 = (Company)session.get(Company.class, cid);
            session.close();

            System.out.println(comp1.getId());
            System.out.println(comp1.getName());
            System.out.println(comp1.getBalance());
            System.out.println("Company Employees:\n" + comp1.getEmployee());
//                System.out.println(employees.get(i).toString1());
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
//            session.getTransaction().rollback();

        } finally {
//            session.close();
            factory.close();
        }


    }
}
