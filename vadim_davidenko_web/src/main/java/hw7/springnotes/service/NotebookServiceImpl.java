package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Вадим on 14.02.2016.
 */

@Scope("singleton")
@Service("notebookService")
@Transactional (readOnly = true)
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;
    private VendorDao vendorDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private StoreDao storeDao;
    private SalesDao salesDao;

    private static int pageCounter = -1;

    private NotebookServiceImpl() {}

    ////////////////////////////////////////////////////////////
    // Inserts

    @Transactional (readOnly = false)
    public Long insertCPU(CPU cpu) {
        if (cpu == null) return 0L;
        return cpuDao.create(cpu);
    }

    @Transactional (readOnly = false)
    public Long insertMemory(Memory memory) {
        if (memory == null) return 0L;
        return memoryDao.create(memory);
    }

    @Transactional (readOnly = false)
    public Long insertVendor(Vendor vendor) {
        if (vendor == null) return 0L;
        return vendorDao.create(vendor);
    }

    @Transactional (readOnly = false)
    public Long insertNotebook(Notebook notebook) {
        if (notebook == null) return 0L;
        return notebookDao.create(notebook);
    }

    ////////////////////////////////////////////////////////////
    // Updates

    @Transactional (readOnly = false)
    public boolean updateCPU(CPU cpu) {
        return cpuDao.update(cpu);
    }

    @Transactional (readOnly = false)
    public boolean updateMemory(Memory memory) {
        return memoryDao.update(memory);
    }

    @Transactional (readOnly = false)
    public boolean updateVendor(Vendor vendor) {
        return vendorDao.update(vendor);
    }

    @Transactional (readOnly = false)
    public boolean updateNotebook(Notebook notebook) {
        return notebookDao.update(notebook);
    }

    ////////////////////////////////////////////////////////////
    // Store services

    @Transactional (readOnly = false)
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store();
        store.setAmount(amount);
        store.setPrice(price);
        Notebook note = getNotebookById(noteId);
        store.setNotebook(note);

        return storeDao.create(store);
    }

    @Transactional (readOnly = false)
    public boolean removeFromStore(Store store, int amount) {
        Integer currentAmount = store.getAmount();

        if (currentAmount.compareTo(amount) > 0) {
            Integer newAmount = currentAmount - amount;
            Double newPrice = store.getPrice() / currentAmount * newAmount;
            store.setAmount(newAmount);
            store.setPrice(newPrice);
            return storeDao.update(store);
        } else if (currentAmount.compareTo(amount) == 0) {
            return storeDao.delete(store);
        }
        return false;
    }

    @Transactional (readOnly = false)
    public Long sale(Long storeId, int amount) {
        Store store = getStoreById(storeId);
        if (store == null) return 0L;

        Integer currentAmount = store.getAmount();
        if (currentAmount.compareTo(amount) > 0) {
            Integer newAmount = currentAmount - amount;
            Double newPrice = store.getPrice() / currentAmount * newAmount;
            store.setAmount(newAmount);
            store.setPrice(newPrice);
            storeDao.update(store);
        } else if (currentAmount.compareTo(amount) == 0) {
            storeDao.delete(store);
        } else {
            return 0L;
        }
        Sales sale = new Sales();
        sale.setAmount(amount);
        sale.setStore(store);
        sale.setDate(new Date());

        return salesDao.create(sale);
    }

    /////////////////////////////////////////////////////////////
    // Reports

    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksByPortion(int size) {
        if (size == 0) {
            pageCounter = -1;
            return null;
        } if (size < 0) {
            if (pageCounter > 0) pageCounter--;
        } else {
            pageCounter++;
        }
        return (List<Notebook>) notebookDao.findByPortion(pageCounter, Math.abs(size));
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return (List<Notebook>) notebookDao.findGtAmount(amount);
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return (List<Notebook>) notebookDao.findByCpuVendor(cpuVendor);
    }

    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksFromStore() {
        return (List<Notebook>) notebookDao.findAllOnStore();
    }

    @SuppressWarnings("unchecked")
    public List<Store> getNotebooksStorePresent() {
        return (List<Store>) storeDao.findOnStorePresent();
    }

    @SuppressWarnings("unchecked")
    public Map<Date, Integer> getSalesByDays() {
        return (Map<Date, Integer>) salesDao.findAllByDays();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters by Id

    public Notebook getNotebookById(Long id) {
        return notebookDao.read(id);
    }

    public Vendor getVendorById(Long id) {
        return vendorDao.read(id);
    }

    public CPU getCPUById(Long id) {
        return cpuDao.read(id);
    }

    public Memory getMemoryById(Long id) {
        return memoryDao.read(id);
    }

    public Store getStoreById(Long id) {
        return storeDao.read(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get all (list)

    @SuppressWarnings("unchecked")
    public List<Notebook> getAllNotebooks() {
        return notebookDao.findAll();
    }

    @SuppressWarnings("unchecked")
    public List<Vendor> getAllVendors() {
        return vendorDao.findAll();
    }

    @SuppressWarnings("unchecked")
    public List<CPU> getAllCPUs() {
        return cpuDao.findAll();
    }

    @SuppressWarnings("unchecked")
    public List<Memory> getAllMemories() {
        return memoryDao.findAll();
    }

    @SuppressWarnings("unchecked")
    public List<Store> getAllStores() {
        return storeDao.findAll();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Setters

    public void setNotebookDao(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public void setVendorDao(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }

    public void setCpuDao(CPUDao cpuDao) {
        this.cpuDao = cpuDao;
    }

    public void setMemoryDao(MemoryDao memoryDao) {
        this.memoryDao = memoryDao;
    }

    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public void setSalesDao(SalesDao salesDao) {
        this.salesDao = salesDao;
    }
}
