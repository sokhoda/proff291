package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 02.03.2016.
 */

@Repository
public class ClientDapImpl implements ClientDao {

    @Autowired
    private SessionFactory factory;

    public ClientDapImpl() {

    }

    @Override
    public Long create(Client client) {
        return (Long)factory.getCurrentSession().save(client);
    }
    @Override
    public Client read(Long id) {
        return (Client)factory.getCurrentSession().get(Client.class,id);
    }

    @Override
    public boolean update(Client client) {
        factory.getCurrentSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        factory.getCurrentSession().delete(client);
        return true;
    }

    @Override
    public List findAll() {
        return (List) factory.getCurrentSession().createQuery("from Client").list();
    }
}
