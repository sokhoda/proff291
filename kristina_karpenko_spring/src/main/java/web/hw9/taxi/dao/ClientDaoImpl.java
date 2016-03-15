package web.hw9.taxi.dao;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import scala.unchecked;
import web.hw9.taxi.domain.Client;

import java.util.Date;
import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {

    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(UserDaoImpl.class);

    public ClientDaoImpl() {
    }

    public ClientDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    protected Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Client client) {
        return (Long) getSession().save(client);
    }

    @Override
    public Client read(Long id) {
        return (Client) getSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        getSession().update(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        getSession().delete(client);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Client>) getSession().createQuery("from Client c");
    }

    @Override
    public boolean isPresent(String name, String surName) {
        if (getSession().createQuery("from Client c where c.name= :name and c.surName= :surName")
                .setParameter("name", name).setParameter("surName", surName).uniqueResult() == null) {
            return true;//если с таким логином нет в базе
        }
        return false;
    }

    @Override
    public List showClientsByPortion(int page, int portionSize) {
        return (List<Client>) getSession().createQuery("from Client c")
                .setFirstResult(page*portionSize-portionSize)
                .setMaxResults(portionSize).list();
    }

    @Override
    public List showClientsGtSum(double sum) {
        return (List<Client>) getSession().createQuery("from Client c where c.sum >= :sum").setParameter("sum", sum).list();
    }


    @Override
    public List showClientsLastMonth() {
        String sql = "select * from CLIENTS c where c.LAST_ORDER_DATE between trunc(sysdate, 'mm') and SYSDATE";
        return (List<Client>) getSession().createSQLQuery(sql).addEntity(Client.class).list();
    }

    @Override
    public Client findClientByPhone(String phone) {
        return (Client) getSession().createQuery("from Client c where c.phone = :phone")
                .setParameter("phone",phone).uniqueResult();

    }


}
