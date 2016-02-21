package session13;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Вадим on 13.02.2016.
 */
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            Company apple = new Company("Apple", 100000.0);
            Employee employee1 = new Employee(apple);
            Employee employee2 = new Employee(apple);
            Employee employee3 = new Employee(apple);
            Set<Employee> set = new HashSet<>();
            set.add(employee1);
            set.add(employee2);
            set.add(employee3);
            apple.setEmployee(set);

            Company sony = new Company("Sony", 10000.0);
            Employee employee4 = new Employee(sony);
            Employee employee5 = new Employee(sony);
            Employee employee6 = new Employee(sony);
            Set<Employee> set2 = new HashSet<>();
            set2.add(employee4);
            set2.add(employee5);
            set2.add(employee6);
            sony.setEmployee(set2);

            session.save(apple);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.save(sony);
            session.save(employee4);
            session.save(employee5);
            session.save(employee6);

            Company company = (Company)session.get(Company.class, 1L);
            System.out.println(company.getEmployee());

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }



    }
}
