package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction is failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;

        try {
            notebook = (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction is failed");
        } finally {
            session.close();
        }

        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            isUpdate = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isUpdate;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            isDelete = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            log.error(e);
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isDelete;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        List<Notebook> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List result = session.createQuery("from hw7.notes.domain.Notebook").list();
            if ( result != null ) {
                for ( Object object : result ) {
//                    if ( object instanceof Notebook ) {
                        list.add((Notebook) object);
//                    }
                }
            }
            session.getTransaction().commit();

            return list;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return null;

    }
}
