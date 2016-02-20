package session13.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session13.domain.Company;
import session13.domain.Person;

import java.util.Locale;
import java.util.Set;

/**
 * Created by Pavel on 13.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Company company1 = new Company("Avada Kedavra", 1823843.04);
        Company company2 = new Company("Vulfrik burger", 10912313.98);

        Person person100001 = new Person("100001");
        Person person100002 = new Person("100002");
        Person person100003 = new Person("100003");
        Person person100004 = new Person("100004");
        Person person100005 = new Person("100005");
        Person person100006 = new Person("100006");

        company1.addPerson(person100003);
        person100003.setCompany(company1);
        company1.addPerson(person100005);
        person100005.setCompany(company1);
        company1.addPerson(person100006);
        person100006.setCompany(company1);

        company2.addPerson(person100001);
        person100001.setCompany(company2);
        company2.addPerson(person100002);
        person100002.setCompany(company2);
        company2.addPerson(person100004);
        person100004.setCompany(company2);

        long id = 1;
        Company result;
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(company1);
            session.save(company2);
            session.getTransaction().commit();
            result = (Company) session.createQuery("FROM Company WHERE id = " + id).uniqueResult();
            Set<Person> persons = result.getPersons();
            for(Person p:persons){
                System.out.println(p);
            }
        } catch (HibernateException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static Session getSession() {
        SessionFactory sessionFactory;
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        return sessionFactory.openSession();
    }
}
