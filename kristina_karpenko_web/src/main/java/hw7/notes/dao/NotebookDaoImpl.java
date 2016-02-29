package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
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
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
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
    public List findAll() {
        List<Object> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List<Object[]> result  = session.createQuery("select n from Notebook n").list();

            if (result != null) {
                for (Object n : result) {
                    list.add(n);
                }
            }

            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List findAll(int size, int from) {
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Notebook");
            List<Object[]> list = query.list();
            //System.out.println(Arrays.toString(list.get(0)));
            //System.out.println(Arrays.toString(list.get(1)));
            List count;
            for (int i = from; (count = query.list()).size() != 0; i = +size) {
                query.setFirstResult(i);
                query.setMaxResults(size);
                System.out.println(count);
            }

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        log.info(session);
        return query.list();
    }


    @Override
    public Notebook findNotebookByParam(String vendor, String model, String modelCPU, String vendMemory, String sizeMemory) {
        Session session = factory.openSession();
        Notebook notebook = null;
        try {
            List<Notebook> notes = session.createQuery("from Notebook n where n.vendor.name = :name and n.model = :model " +
                    "and n.cpu.model = :modelCPU and n.memory.vendor.name = :vendMemory and n.memory.size = :sizeMemory ")
                    .setString("name", vendor)
                    .setString("model", model)
                    .setString("modelCPU", modelCPU)
                    .setString("vendMemory", vendMemory)
                    .setString("sizeMemory", sizeMemory).list();


            for (Notebook note : notes) {
                notebook = note;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public List findNotebooksGtAmount(int amount) {
        List<Object> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List<Object[]> result  = session.createQuery("from Store s join s.notebook n where s.amount > :amount ")
                 .setParameter("amount", amount).list();

            if (result != null) {
                for (Object n : result) {
                    list.add(n);
                }
            }

            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List findNotebooksByCpuVendor(Vendor cpuVendor) {
        List<Object> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List<Object[]> result  = session.createQuery("from Notebook n join n.cpu c where c.vendor = :cpuVendor ")
                    .setParameter("cpuVendor", cpuVendor).list();

            if (result != null) {
                for (Object n : result) {
                    list.add(n);
                }
            }

            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List getNotebooksFromStore() {
        List<Object> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List<Object[]> result  = session.createQuery("from Store s join s.notebook n order by n.vendor  ").list();

            if (result != null) {
                for (Object n : result) {
                    list.add(n);
                }
            }

            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


}
