package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Admin on 17.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private NotebookDao notebookDao;
    private SalesDao salesDao;
    private StoreDao storeDao;
    private VendorDao vendorDao;

    private SessionFactory sessionFactory = getSessionFactory();
    public NotebookServiceImpl(){}

    public NotebookServiceImpl(String key){
        this.cpuDao = new CPUDaoImpl();
        this.memoryDao = new MemoryDaoImpl();
        this.notebookDao = new NotebookDaoImpl();
        this.salesDao = new SalesDaoImpl();
        this.storeDao = new StoreDaoImpl();
        this.vendorDao = new VendorDaoImpl();

    }
    public static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("resources.hw7.hw7.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        ssrb.applySettings(cfg.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        return cfg.buildSessionFactory(ssr);
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store(notebookDao.read(noteId), amount,price);
        return storeDao.create(store);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Date date =  new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Store store = storeDao.read(storeId);
        store.setQuantity(store.getQuantity() - amount);
        store.setPrice(store.getPrice() - (store.getPriseForOne() * amount));
        storeDao.update(store);
        Sales sales = new Sales(store ,simpleDateFormat.format(date),amount);
        Long id = salesDao.create(sales);

        return id;
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
        store = storeDao.read(store.getId());
        store.setQuantity(store.getQuantity() - amount);
        store.setPrice(store.getPrice() - (amount * store.getPriseForOne()));
        return storeDao.update(store);
    }

    @Override
    public List getNotebooksByPortion(int size) {
        return null;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        return null;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        return null;
    }

    @Override
    public List getNotebooksFromStore() {
        return null;
    }

    @Override
    public List getNotebooksStorePresent() {
        return null;
    }

    @Override
    public Map getSalesByDays() {
        return null;
    }

    public CPUDao getCpuDao() {
        return cpuDao;
    }

    public void setCpuDao(CPUDao cpuDao) {
        this.cpuDao = cpuDao;
    }

    public MemoryDao getMemoryDao() {
        return memoryDao;
    }

    public void setMemoryDao(MemoryDao memoryDao) {
        this.memoryDao = memoryDao;
    }

    public NotebookDao getNotebookDao() {
        return notebookDao;
    }

    public void setNotebookDao(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public SalesDao getSalesDao() {
        return salesDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }

    public StoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public VendorDao getVendorDao() {
        return vendorDao;
    }

    public void setVendorDao(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }
}
