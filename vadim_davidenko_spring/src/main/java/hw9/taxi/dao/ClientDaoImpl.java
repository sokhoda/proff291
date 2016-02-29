package hw9.taxi.dao;

import hw9.taxi.domain.Client;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 28.02.2016.
 */

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public ClientDaoImpl() {}

    public Long create(Client client) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(client);
    }

    public boolean update(Client client) {
        Session session = factory.getCurrentSession();
        session.update(client);
        return true;
    }

    public Client read(Long id) {
        Session session = factory.getCurrentSession();
        return (Client)session.get(Client.class, id);
    }

    public boolean delete(Client client) {
        Session session = factory.getCurrentSession();
        session.delete(client);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Client>)session.createQuery("from hw9.taxi.domain.Client").list();
    }

    @SuppressWarnings("unchecked")
    public List<Client> findByPortion(int page, int size) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from hw9.taxi.domain.Client");
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return (List<Client>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Client> findGtSum(int sum) {
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(
                "select * from CLIENTS c\n" +
                        "where :sum < (\n" +
                        "select sum(o.AMOUNT) from ORDERS o " +
                        "where o.CLIENT_ID = c.ID\n" +
                        ")"
        );
        query.addEntity(Client.class);
        query.setParameter("sum", sum);
        return (List<Client>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Client> findLastMonth() {

        return null;
    }
}
