package session12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import session11.Region;
import session11.Users;

import java.util.Arrays;
import java.util.List;


public class ClientDaoImpl implements ClientDao {

    private static Logger log = Logger.getLogger(ClientDaoImpl.class);
    private SessionFactory factory;
 //   Configuration.cfg

    public ClientDaoImpl(SessionFactory factory) {
       this.factory = factory;
    }

    @Override
    public Long create(Users user) {
        return null;
    }

    @Override
    public Users read(Long id) {
        return null;
    }

    @Override
    public void update(Users client) {

    }

    @Override
    public void delete(Users client) {

    }

    @Override
    public List<Users> findAll(String login, String pass) {


        Query query1 = null;
        Session session = factory.openSession();

        try {

            Query query = session.createQuery("from Users u where u.name = 'login' and u.password = 'pass'");
            if(login.equals(query.list().get(0))&&pass.equals(query.list().get(1))) {
           query1 = session.createQuery("select u.name, u.password from Users u where u.name != 'login' and u.password != 'pass'");
                List<Object[]> list = query1.list();
                System.out.println(Arrays.toString(list.get(0)));
                System.out.println(Arrays.toString(list.get(1)));
            }
            else
            {
               query1 = session.createQuery("select u.name, u.password from Users u ");
                List<Object[]> list = query1.list();
                System.out.println(Arrays.toString(list.get(0)));
                System.out.println(Arrays.toString(list.get(1)));
            }

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        log.info(session);
        return query1.list();
    }

    @Override
    public List<Users> findAllUsersByPortion(Long id) {
        Session session = factory.openSession();
        Query query = null;
        try {

             query = session.createQuery("select u.name from Users u where u.id >= id");
            List count;
            for(int i = 0 ; (count = query.list()).size() != 0; i=+2){
                query.setFirstResult(i);
                query.setMaxResults(2);
                System.out.println(count);
            }

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        log.info(session);
        return query.list();

    }
}

