package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Юлия on 19.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);

    private NotebookDao notebookDao;
    private CPUDao cpuDao;
    private VendorDao vendorDao;
    private SalesDao salesDao;
    private StoreDao storeDao;
    private MemoryDao memoryDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(CPUDao cpuDao, VendorDao vendorDao, SalesDao salesDao, StoreDao storeDao, MemoryDao memoryDao, NotebookDao notebookDao) {
        this.cpuDao = cpuDao;
        this.vendorDao = vendorDao;
        this.salesDao = salesDao;
        this.storeDao = storeDao;
        this.memoryDao = memoryDao;
        this.notebookDao = notebookDao;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        return storeDao.create(new Store(notebookDao.read(noteId), amount, price));
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store stores = storeDao.read(storeId);
        int account = stores.getAmount();
        if (account > 0) {
            stores.setAmount(account - amount);
            storeDao.update(stores);
        }
        return null;
    }

    @Override
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        int account = store.getAmount();
        if (account > amount) {
            store.setAmount(account - amount);
            storeDao.update(store);
        }
        return false;
    }

    @Override
    public List getNotebooksByPortion(int size) {
        List<Notebook> notebooks = new ArrayList<>();
        SessionFactory factory = getSessionFactory();
        Session session = null;
       try {
           session = factory.openSession();

           String name = "%";
           Query query = session.createQuery("from NOTEBOOKS n where n.name like:name");
           query.setParameter("name", name);
           for (int i = 0; (notebooks = query.list()).size() != 0; i += size) {
               query.setFirstResult(i);
               query.setMaxResults(size);
               return notebooks;
           }
       } catch (HibernateException e) {
               log.error("Open session failed", e);
               if (session != null) {
                   session.getTransaction().rollback();
                   return null;
               }
           } finally {
               if (session != null) {
                   session.close();
               }
               factory.close();
           }
           log.info(session);
        return null;

        }

        @Override
        public List getNotebooksGtAmount ( int amount){
            return null;
        }

        @Override
        public List getNotebooksByCpuVendor (Vendor cpuVendor){
            return null;
        }

        @Override
        public List getNotebooksFromStore () {
            return null;
        }

        @Override
        public List getNotebooksStorePresent () {
            return null;
        }

        @Override
        public Map getSalesByDays () {
            return null;
        }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}
