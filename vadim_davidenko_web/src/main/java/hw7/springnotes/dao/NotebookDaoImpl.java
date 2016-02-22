package hw7.springnotes.dao;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("notebookDao")
public class NotebookDaoImpl implements NotebookDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public NotebookDaoImpl() {}

    public Long create(Notebook notebook) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(notebook);
    }

    public Notebook read(Long id) {
        Session session = factory.getCurrentSession();
        return (Notebook)session.get(Notebook.class, id);
    }

    public boolean update(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.update(notebook);
        return true;
    }

    public boolean delete(Notebook notebook) {
        Session session = factory.getCurrentSession();
        session.delete(notebook);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Notebook>)session.createQuery("from hw7.springnotes.domain.Notebook").list();
    }

    ////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public List<Notebook> findByPortion(int page, int size) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from hw7.springnotes.domain.Notebook");
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return (List<Notebook>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> findByCpuVendor(Vendor cpuVendor) {
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(
                "select * from NOTEBOOK n, CPU c, VENDOR v " +
                        "where n.CPU_ID = c.CPU_ID " +
                        "and c.VENDOR_ID = v.VENDOR_ID " +
                        "and v.NAME like :vendorName"
        );
        query.addEntity(Notebook.class);
        query.setParameter("vendorName", cpuVendor.getName());
        return query.list();
    }

    public List<Notebook> findAllOnStore() {
        return findAll();
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> findGtAmount(int amount) {
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(
                "select * from NOTEBOOK n\n" +
                        "where :amount < (\n" +
                        "select sum(s.AMOUNT) from STORE s " +
                        "where s.NOTEBOOK_ID = n.NOTEBOOK_ID\n" +
                        ")"
        );
        query.addEntity(Notebook.class);
        query.setParameter("amount", amount);
        return query.list();
    }

}
