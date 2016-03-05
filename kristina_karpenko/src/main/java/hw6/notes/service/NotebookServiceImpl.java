package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookServiceImpl() {
        notebookDao = new NotebookDaoImpl(HibernateUtil.getSessionFactory());
    }

    @Override
    public Long add(Notebook notebook) {
        notebookDao.create(notebook);
        return notebook.getId();
    }

    @Override
    public List findAll() {
        return notebookDao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {

    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {

    }

    @Override
    public boolean delete(Long id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.id = :id ");
            session.delete(query);
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteByModel(String model) {
        return false;
    }

    @Override
    public List findByVendor(String vendor) {
        return null;
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return null;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
