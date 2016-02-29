package hw7.springnotes.dao;



import hw7.springnotes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
@Repository
public class NotebookDaoImpl implements NotebookDao {

    public NotebookDaoImpl(){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Notebook notebook) {
        Long id = null;
            id = (Long)sessionFactory.getCurrentSession().save(notebook);
            return id;

    }

    @Override
    public Notebook read(Long id) {
            return (Notebook) sessionFactory.getCurrentSession().get(Notebook.class, id);
    }

    @Override
    public boolean update(Notebook notebook) {

        try {
            sessionFactory.getCurrentSession().update(notebook);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean delete(Notebook notebook) {

        try {
            sessionFactory.getCurrentSession().delete(notebook);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public List findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.Notebook");

        return query.list();
    }

}
