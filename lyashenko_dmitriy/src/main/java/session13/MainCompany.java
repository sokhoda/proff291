package session13;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created by Solyk on 13.02.2016.
 */
public class MainCompany {

    private static String getString(List<Object[]> list) {
        String res = "size: " + list.size() + "\n";
        for (Object[] array : list) {
            for (Object el : array) {
                res += el + ", ";
            }
            res += "\n-----------\n";
        }
        return res;
    }

    public static void main(String[] args) {

        Company first = new Company("Aser2",456789.8);
        Company second = new Company("Lenovo", 234567890.6);

        Employee firstEm = new Employee();
        Employee secondEm = new Employee();
        Employee thirdEm = new Employee();

        Employee forthEm = new Employee();
        Employee fifthEm = new Employee();
        Employee sixthEm = new Employee();

        first.getEmployees().add(firstEm);
        first.getEmployees().add(secondEm);
        first.getEmployees().add(thirdEm);

//        firstEm.setCompany(first);
//        secondEm.setCompany(first);
//        thirdEm.setCompany(first);
//
//        second.getEmployees().add(forthEm);
//        second.getEmployees().add(fifthEm);
//        second.getEmployees().add(sixthEm);
//
//        forthEm.setCompany(second);
//        fifthEm.setCompany(second);
//        fifthEm.setCompany(second);


//
//        Locale.setDefault(Locale.ENGLISH);
//        Configuration cfg = new Configuration().configure("session13/NotebookCon.cfg.xml");
//        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//        sb.applySettings(cfg.getProperties());
//        StandardServiceRegistry standardServiceRegistry = sb.build();
//        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
//        Session session = null;
//
//
//        try{
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            session.save(first);
//            session.save(firstEm);
//            session.save(secondEm);
//            session.save(thirdEm);
//            session.getTransaction().commit();
//        } catch (HibernateException e){
//
//            session.getTransaction().rollback();
//
//        } finally {
//
//            session.close();
//            sessionFactory.close();
//        }
//
//        Locale.setDefault(Locale.ENGLISH);
//        Configuration cfg2 = new Configuration().configure("session13/NotebookCon.cfg.xml");
//        StandardServiceRegistryBuilder sb2 = new StandardServiceRegistryBuilder();
//        sb2.applySettings(cfg2.getProperties());
//        StandardServiceRegistry standardServiceRegistry2 = sb2.build();
//        SessionFactory sessionFactory2 = cfg2.buildSessionFactory(standardServiceRegistry2);
//        Session session2 = null;
//
//
//        try{
//            session2 = sessionFactory2.openSession();
//            session2.beginTransaction();
//            session2.save(second);
//            session2.save(forthEm);
//            session2.save(fifthEm);
//            session2.save(sixthEm);
//            session2.getTransaction().commit();
//        } catch (HibernateException e){
//
//            session2.getTransaction().rollback();
//
//        } finally {
//
//            session2.close();
//            sessionFactory2.close();
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        String tmp = scanner.nextLine();

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg3 = new Configuration().configure("session13/NotebookCon.cfg.xml");
        StandardServiceRegistryBuilder sb3 = new StandardServiceRegistryBuilder();
        sb3.applySettings(cfg3.getProperties());
        StandardServiceRegistry standardServiceRegistry3 = sb3.build();
        SessionFactory sessionFactory3 = cfg3.buildSessionFactory(standardServiceRegistry3);
        Session session3 = null;


//        try {
//            session3 = sessionFactory3.openSession();
//            Query query = session3.createQuery("select balance from  Company c where c.name like 'Aser2'");
//            Double v = (Double) query.uniqueResult();
//            session3.beginTransaction();
//            session3.save(first);
////            session3.save(firstEm);
////            session3.save(firstEm);
////            session3.save(firstEm);
//            session3.getTransaction().commit();
//            System.out.println(v + 1000.8);

//        } catch (HibernateException e){
//            System.out.print("NONONONONONONONONONONON");
//
//        }finally {
//
//            session3.close();
//            sessionFactory3.close();
//        }

        try {
            session3 = sessionFactory3.openSession();
           //  List <Object[]> listw = session3.createQuery("from Company c join c.employees where c.name like 'Aser2'");

           // String res = getString(listw);
//            session3.beginTransaction();
//            session3.save(first);
////            session3.save(firstEm);
////            session3.save(firstEm);
////            session3.save(firstEm);
//            session3.getTransaction().commit();
//            System.out.println(v + 1000.8);

              //  System.out.println(res);

        } catch (HibernateException e){
            System.out.print("NONONONONONONONONONONON");

        }finally {

            session3.close();
            sessionFactory3.close();
        }
    }
}
