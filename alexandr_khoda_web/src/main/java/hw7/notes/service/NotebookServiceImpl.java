package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import hw7.notes.exception.PortionException;
import hw7.notes.exception.StoreException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by s_okhoda on 09.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {
    private SessionFactory factory;

    private static Logger log = Logger.getLogger(NotebookServiceImpl.class);
    NotebookDao noteDao;
    StoreDao storeDao;
    SalesDao salesDao;
    VendorDao vendorDao;
    CPUDao cpuDao;
    MemoryDao memoryDao;

    public NotebookServiceImpl(NotebookDao noteDao) {
        factory = getSessionFactory();
        this.noteDao = new NotebookDaoImpl(factory);
        this.storeDao = new StoreDaoImpl(factory);
        this.salesDao = new SalesDaoImpl(factory);
        this.vendorDao = new VendorDaoImpl(factory);
        this.cpuDao = new CPUDaoImpl(factory);
        this.memoryDao = new MemoryDaoImpl(factory);

    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        return storeDao.create( new Store(noteDao.read(noteId), amount, price));

    }

    @Override
    public Long sale(Long storeId, int amount) throws StoreException{
        Store store = storeDao.read(storeId);
        int existingQuant;

        if ((existingQuant = store.getQuantity()) >= amount){
            store.setQuantity(existingQuant - amount);
            if(storeDao.update(store)){
                return storeId;
            }
            else {
                throw new StoreException("Failed to sale items.");
            }
        }
        throw new StoreException("Amount of existing items on store less than" +
                "  required.");
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
        return noteDao.update(notebook);
    }

    @Override
    public boolean removeFromStore(Store store, int amount) throws StoreException{
        int existingQuant;

        if ((existingQuant = store.getQuantity()) >= amount){
            store.setQuantity(existingQuant - amount);
            return storeDao.update(store);
        }
        throw new StoreException("Amount of existing items on store less than" +
                "  required.");
    }

    @Override
    public List getNotebooksByPortion(int size, int cnt) throws
            PortionException, HibernateException{
        if (size <= 0) {
            throw new PortionException("Negative portion size.")
            return null;
        }
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Notebook");
            query.setFirstResult(cnt * size);
            query.setMaxResults(size);
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
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

    //    @Override
//    public Long add(Notebook notebook) throws HibernateException{
//        return noteDao.create(notebook);
//    }
//
//    @Override
//    public List findAll() {
//        return noteDao.findAll();
//    }
//
//    @Override
//    public boolean changePrice(Long id, double price) {
//        return noteDao.changePrice(id, price);
//    }
//
//    @Override
//    public boolean changeSerialVendor(Long id, String serial, String vendor) {
//        return noteDao.changeSerialVendor(id, serial, vendor);
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        return noteDao.delete(id);
//    }
//
//    @Override
//    public boolean deleteByModel(String model) {
//        return noteDao.deleteByModel(model);
//    }
//
//    @Override
//    public List findByVendor(String vendor) {
//        return noteDao.findByVendor(vendor);
//    }
//
//    @Override
//    public List findByPriceManufDate(Double price, Date date) {
//        return noteDao.findByPriceManufDate(price, date);
//    }
//
//    @Override
//    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
//        return noteDao.findBetweenPriceLtDateByVendor(priceFrom, priceTo,
//                date, vendor);
//    }
//
    public SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg =
                new Configuration().configure("hw7.notes/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

}
