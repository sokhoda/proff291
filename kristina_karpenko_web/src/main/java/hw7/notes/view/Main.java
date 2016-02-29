package hw7.notes.view;

import hw7.notes.util.HibernateUtil;
import hw7.notes.domain.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Администратор on 17.02.2016.
 */
public class Main {
    private static SessionFactory factory;

    public static void main(String[] args) {
        Notebook notebook;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Long id = null;

        try {
//            Vendor intel = new Vendor("Intelid");
//            Vendor westernHDD = new Vendor("WesternDigital Elements");
//            CPU coreI5 = new CPU(intel, "Core i6", "3100");
//            Memory hdd1500 = new Memory(westernHDD,"1400");
//            Store store1 = new Store(29, 7890D);
//
//
//            notebook = new Notebook("Asss",intel,coreI5,hdd1500,store1,new Date());
            session.beginTransaction();

//            session.save(intel);
//            session.save(westernHDD);
//            session.save(coreI5);
//            session.save(hdd1500);
//            session.save(store1);
//            session.save(notebook);

            session.getTransaction().commit();

        } catch (HibernateException e) {

            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
