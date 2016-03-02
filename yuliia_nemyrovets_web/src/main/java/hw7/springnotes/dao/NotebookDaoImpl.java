package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {

    @Autowired
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        return (Long) factory.getCurrentSession().save(notebook);
    }

    @Override
    public Notebook read(Long id) {
        return (Notebook) factory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {
        factory.getCurrentSession().update(notebook);
        return true;
    }

    @Override
    public boolean delete(Notebook notebook) {
        factory.getCurrentSession().delete(notebook);
        return true;
    }

    @Override
    public List findAll() {
        return (List) factory.getCurrentSession().createQuery("from Notebook").list();
    }
}
