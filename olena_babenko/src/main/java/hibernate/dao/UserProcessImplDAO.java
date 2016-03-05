package hibernate.dao;

import java.util.List;
import hibernate.domain.UserProcess;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by lenchi on 07.02.16.
 */
public class UserProcessImplDAO implements UserProcessDAO {
    private static Logger log = Logger.getLogger(UserProcessImplDAO.class);
    private SessionFactory factory;

    public UserProcessImplDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(UserProcess user) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public UserProcess read(Long id) {
        Session session = factory.openSession();
        try {
            return (UserProcess) session.get(UserProcess.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<UserProcess> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from UserProcess");
        return query.list();
    }

    @Override
    public void update(UserProcess user) {

    }

    @Override
    public void delete(UserProcess user) {

    }
}

