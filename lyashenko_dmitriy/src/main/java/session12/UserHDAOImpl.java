package session12;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Solyk on 07.02.2016.
 */
public class UserHDAOImpl implements IUserDAO {

//    private static Logger log = Logger.getLogger(String.valueOf(UserHDAOImpl.class));

    private static SessionFactory getSessionFactory() {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session12/UserHDAOHiber.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    @Override
    public List findAllWithout(String login, String password) {
        SessionFactory factory = getSessionFactory();
//        log.info("Reference to SessionFactory " + factory);
        List<UserHDAO> list = null;
        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from UserHDAO u where u.login not like '" +  login  + "'"
                  +  " and  u.password not like '" + password + "'");
            list = query.list();
//            log.info(String.valueOf(list));

//            query = session.createQuery("select r.id, r.name from USERS r where r.id > 2");
//            List<Object[]> list2 = query.list();
//            System.out.println(Arrays.toString(list2.get(0)));
//            System.out.println(Arrays.toString(list2.get(1)));
//            log.info(list);


            Query query2 = session.createQuery("select count(*) from UserHDAO u");
            long count = (Long)query2.uniqueResult();
            System.out.print(count);

            String name = "%S";
            Query query3 = session.createQuery("select count(*) from UserHDAO u where u.login like :login");
            query3.setParameter("login", name );

            query3.setFirstResult(0);
            query3.setMaxResults(2);
            long count2 = (Long)query3.uniqueResult();
            System.out.print(count2);

            query3.setFirstResult(2);
            query3.setMaxResults(2);
            count2 = (Long)query3.uniqueResult();
            System.out.print(count2);

        } catch (HibernateException e) {
//            log.error("Open session failed", e);
            System.out.println("Fuck No");
//            if (session != null) {
//                session.getTransaction().rollback();
//            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
//        log.info(String.valueOf(session));


        return list;
    }

    @Override
    public List findAll() {
        return null;
    }

    public static void main(String[] args) {
        List<UserHDAO> op = new UserHDAOImpl().findAllWithout("Solyk", "dert");

        for(int i = 0; i < op.size(); i++){
            System.out.println(op.get(i).toString());
        }

//        new UserHDAOImpl().findAllWithout("Solyk", "dert");

    }
}
