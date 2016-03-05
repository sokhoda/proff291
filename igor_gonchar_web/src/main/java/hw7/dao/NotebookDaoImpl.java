package hw7.dao;

import hw7.domain.CPU;
import hw7.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@Repository("NotebookDao")
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(notebook);
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Notebook) session.get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = mySessionFactory.getCurrentSession();
        boolean isUpdated = false;
        session.update(notebook);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(Notebook notebook) {
        boolean isDeleted = false;
        Session session = mySessionFactory.getCurrentSession();
        session.delete(notebook);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.Notebook n");
        return query.list();
    }
}
