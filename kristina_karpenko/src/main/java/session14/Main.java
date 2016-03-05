package session14;


import hw7.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    private static SessionFactory factory;
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Company companyDisney = new Company("Disney",200000L);
            Company companyMac = new Company( "MAC",1000000L  );
            Person person = new Person(companyDisney);
            Person person2 = new Person(companyDisney);
            Person person3 = new Person(companyDisney);

            Person person4 = new Person(companyMac);
            Person person5 = new Person(companyMac);
            Person person6 = new Person(companyMac);

            companyDisney.setPers(person);
            companyDisney.setPers(person2);
            companyDisney.setPers(person3);

            companyMac.setPers(person4);
            companyMac.setPers(person5);
            companyMac.setPers(person6);


            session.beginTransaction();


            session.save(person);
            session.save(person2);
            session.save(person3);
            session.save(person4);
            session.save(person5);
            session.save(person6);
            session.save(companyDisney);
            session.save(companyMac);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        sessionFactory.close();

    }
}
