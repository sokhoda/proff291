package session12.dentist.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session12.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 18.05.13
 */
public class ClientHibernateDaoImpl implements ClientDao {
    private static Logger log = Logger.getLogger(ClientHibernateDaoImpl.class);
    private SessionFactory factory;

    public ClientHibernateDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Client user) {
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
    public Client read(Long id) {
        Session session = factory.openSession();
        try {
            return (Client)session.get(Client.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Client");
        return query.list();
    }

    @Override
    public List<Client> findMonyGT(long amount) {
        return null;
    }
}
