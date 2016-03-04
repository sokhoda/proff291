package hw9.dao;

import hw9.domain.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public ClientDaoImpl() {
    }

    @Override
    public long create(Client client) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(client);
        return id;
    }

    @Override
    public boolean update(Client client) {
        Session session = mySessionFactory.getCurrentSession();
        session.update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        Session session = mySessionFactory.getCurrentSession();
        session.delete(client);
        return true;
    }

    @Override
    public Client read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Client) session.get(Client.class, id);
    }

    @Override
    public Client findByNameAndPhone(String name, String telephone) {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw9.domain.Client c WHERE c.name =:name AND c.telephone =:telephone");
        query.setString ("name", name);
        query.setString ("telephone", telephone);
        return (Client) query.uniqueResult();
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw9.domain.Client c");
        return query.list();
    }
}
