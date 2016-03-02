package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Юлия on 19.02.2016.
 */
@Service("ser")
@Transactional
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookDao notebookDao;

    @Autowired
    private CpuDao cpuDao;

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private SalesDao salesDao;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private MemoryDao memoryDao;

    public Long createCPU(Cpu cpu) {
        return cpuDao.create(cpu);
    }

    public Long createVendor(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    public Long createNotebook(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    public Long createMemory(Memory memory) {
        return memoryDao.create(memory);
    }

    public NotebookServiceImpl() {
        this.cpuDao = new CpuDaoImpl();
        this.vendorDao = new VendorDaoImpl();
        this.salesDao = new SalesDaoImpl();
        this.notebookDao = new NotebookDaoImpl();
        this.storeDao = new StoreDaoImpl();
    }

    @Transactional(readOnly = true)
    @Override
    public Long receive(Long noteId, int amount, double price) {

        return storeDao.create(new Store(amount, price, notebookDao.read(noteId)));

    }

    @Transactional(readOnly = true)
    @Override
    public Long sale(Long storeId, int amount) {
        Sales sales = new Sales();
        Store stores = storeDao.read(storeId);
        Integer account = stores.getAmount();
        if (account.compareTo(amount) >= 0) {
            sales.setAmount(amount);
            sales.setStore(stores);
            sales.setDate(new Date());
            return salesDao.create(sales);
        }
        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public boolean updateCpu(Cpu cpu) {
        return cpuDao.update(cpu);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean removeFromStore(Store store, int amount) {
        Integer account = store.getAmount();
        if (account.compareTo(amount) >= 0) {
            store.setAmount(account - amount);
            return storeDao.update(store);
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksByPortion(int size) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksFromStore() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List getNotebooksStorePresent() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Map getSalesByDays() {
        return null;
    }

}
