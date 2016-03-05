package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by i.gonchar on 2/10/2016.
 */
public class NotebookDaoImpl implements NotebookDao{
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory;

    public NotebookDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    public void closeSessionAndFactory(SessionFactory factory, Session session){
        if (session != null) {
            session.close();
        }
        factory.close();
        log.info("Closing factory");
    }


    @Override
    public Long create(Notebook ntb) {
        return null;
    }

    @Override
    public Notebook read(Long id) {
        return null;
    }

    @Override
    public boolean update(Notebook ntb) {
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        return false;
    }
}
