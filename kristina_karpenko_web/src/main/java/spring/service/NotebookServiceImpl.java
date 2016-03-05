package spring.service;

import spring.dao.*;
import spring.domain.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Kris on 15.02.2016.
 */
@Scope("singleton")
@Service("notebookService")
@Transactional
public class NotebookServiceImpl implements NotebookService {
    @Autowired(required = true)
    private SessionFactory factory;
    @Autowired(required = true)
    private NotebookDao notebookDao;
    @Autowired(required = true)
    private Notebook notebook;
    @Autowired(required = true)
    private CPUDao cpuDao;
    @Autowired(required = true)
    private CPU cpus;
    @Autowired(required = true)
    private MemoryDao memoryDao;
    @Autowired(required = true)
    private Memory memory;
    @Autowired(required = true)
    private StoreDao storeDao;
    @Autowired(required = true)
    private SalesDao salesDao;
    @Autowired(required = true)
    private VendorDao vendorDao;

    public NotebookServiceImpl() {
    }

    public NotebookServiceImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    public NotebookServiceImpl(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public NotebookServiceImpl(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public NotebookServiceImpl(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Long receive(Long noteId, int amount, double price) {
        Store store = notebookDao.receive(noteId, amount, price);
        return store.getId();
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        Sales sales = new Sales(store, amount);

        boolean isRemove = removeFromStore(store, amount);
        if (!isRemove) {
            return 0L;
        } else {
            salesDao.create(sales);
        }
        return sales.getId();
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
        int oldAmount = store.getAmount();
        if (oldAmount == amount) {
            storeDao.delete(store);
            return true;
        }
        if (oldAmount < amount) {
            return false;
        } else {
            store.setAmount(oldAmount - amount);
            storeDao.update(store);
            return true;
        }
    }

    @Override
    public List getNotebooksByPortion(int size) {

//        List<Notebook> list = notebookDao.findAll(size, from);
//        from = size;
//        return list;
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksGtAmount(int amount) {
        if (amount == 0) {
            return (List<Notebook>) notebookDao.findAll();
        }
        return (List<Notebook>) notebookDao.findNotebooksGtAmount(amount);
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return (List<Object>) notebookDao.findNotebooksByCpuVendor(cpuVendor);
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksFromStore() {
        return (List<Object>) notebookDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksStorePresent() {
        return (List<Object>) notebookDao.getNotebooksFromStore();
    }

    @Transactional(readOnly = true)
    @Override
    public Map getSalesByDays() {
        return (Map<Sales, Notebook>) salesDao.getSalesByDays();
    }
}
