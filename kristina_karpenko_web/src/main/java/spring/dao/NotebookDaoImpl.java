package spring.dao;

import spring.domain.Notebook;
import spring.domain.Store;
import spring.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("notebookDao")
public class NotebookDaoImpl implements NotebookDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl() {
    }

    public NotebookDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Notebook ntb) {
        return (Long) getSession().save(ntb);
    }

    @Override
    public Notebook read(Long id) {
        return (Notebook) getSession().get(Notebook.class, id);
    }


    @Override
    public boolean update(Notebook ntb) {
        getSession().update(ntb);
        return true;
    }

    @Override
    public boolean delete(Notebook ntb) {
        getSession().delete(ntb);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Notebook>) getSession().createQuery("select n from Notebook n").list();
    }

    public List findAll(int page, int size) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Notebook n");
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return (List<Notebook>) query.list();
    }


    @Override
    public Notebook findNotebookByParam(String vendor, String model, String modelCPU, String vendMemory, String sizeMemory) {
        return (Notebook) getSession().createQuery("from Notebook n where n.vendor.name = :name and n.model = :model " +
                "and n.cpu.model = :modelCPU and n.memory.vendor.name = :vendMemory and n.memory.size = :sizeMemory ")
                .setString("name", vendor)
                .setString("model", model)
                .setString("modelCPU", modelCPU)
                .setString("vendMemory", vendMemory)
                .setString("sizeMemory", sizeMemory);

    }

    @Override
    public List findNotebooksGtAmount(int amount) {
        return (List<Notebook>) getSession().createQuery("select n from Store s join s.notebook n where s.amount > :amount ")
                .setParameter("amount", amount).list();
    }

    @Override
    public List findNotebooksByCpuVendor(Vendor cpuVendor) {
        return (List<Notebook>) getSession().createQuery("from Notebook n join n.cpu c where c.vendor = :cpuVendor ")
                .setParameter("cpuVendor", cpuVendor).list();
    }

    @Override
    public List getNotebooksFromStore() {
        return (List<Notebook>) getSession().createQuery("from Store s join s.notebook n order by n.vendor  ").list();
    }

    @Override
    public Store receive(Long noteId, int amount, double price) {
        return (Store) getSession().createQuery("select s from Store s join s.notebook n where n.id= :noteId and s.amount= :amount and s.price = :price ")
                .setParameter("noteId", noteId).setParameter("amount", amount).setParameter("price", price);
    }


}
