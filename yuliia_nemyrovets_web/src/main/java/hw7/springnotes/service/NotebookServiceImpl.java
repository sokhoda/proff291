package hw7.springnotes.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Юлия on 19.02.2016.
 */
@Service("serviceImpl")
public class NotebookServiceImpl implements NotebookService {

    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);
    @Autowired(required = true)
    private NotebookDao notebookDao;

    @Autowired(required = true)
    private CPUDao cpuDao;
    @Autowired(required = true)
    private VendorDao vendorDao;

    @Autowired(required = true)
    private SalesDao salesDao;

    @Autowired(required = true)
    private StoreDao storeDao;

    @Autowired(required = true)
    private MemoryDao memoryDao;

    public NotebookServiceImpl() {
    }

    @Override
    @Autowired(required = true)
    public Long receive(Long noteId, int amount, double price) {
        return storeDao.create(new Store(notebookDao.read(noteId), amount, price));
    }

    @Override
    @Autowired(required = true)
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
    @Autowired(required = true)
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Override
    @Autowired(required = true)
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Override
    @Autowired(required = true)
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Override
    @Autowired(required = true)
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Override
    @Autowired(required = true)
    public boolean removeFromStore(Store store, int amount) {
        int account = store.getAmount();
        if (account > amount) {
            store.setAmount(account - amount);
            storeDao.update(store);
        }
        return false;
    }

    @Override
    @Autowired(required = true)
    public List getNotebooksByPortion(int size) {
//        List<Notebook> notebooks = new ArrayList<>();
//        SessionFactory factory = getSessionFactory();
//        Session session = null;
//       try {
//           session = factory.openSession();
//
//           String name = "%";
//           Query query = session.createQuery("from NOTEBOOKS n where n.name like:name");
//           query.setParameter("name", name);
//           for (int i = 0; (notebooks = query.list()).size() != 0; i += size) {
//               query.setFirstResult(i);
//               query.setMaxResults(size);
//               return notebooks;
//           }
//       } catch (HibernateException e) {
//               log.error("Open session failed", e);
//               if (session != null) {
//                   session.getTransaction().rollback();
//                   return null;
//               }
//           } finally {
//               if (session != null) {
//                   session.close();
//               }
//               factory.close();
//           }
//           log.info(session);
        return null;

    }

    @Override
    @Autowired(required = true)
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    @Autowired(required = true)
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    @Autowired(required = true)
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    @Autowired(required = true)
    public List getNotebooksStorePresent() {
        return null;
    }

    @Override
    @Autowired(required = true)
    public Map getSalesByDays() {
        return null;
    }


}
