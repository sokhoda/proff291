package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Solyk on 02.03.2016.
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ClientDaoImpl(){}

    @Override
    public Long create(Client client) {
        try {
            return (Long)sessionFactory.getCurrentSession().save(client);
        } catch (HibernateException e){
            return null;
        }

    }

    @Override
    public Client read(Long id) {
        return (Client)sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        try{
            sessionFactory.getCurrentSession().update(client);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Client client) {
        try{
            sessionFactory.getCurrentSession().delete(client);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw9.taxi.domain.Client");
        return query.list();
    }
}
