package hw7.springnotes.service;

import hw7.springnotes.dao.*;
import hw7.springnotes.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Вадим on 14.02.2016.
 */

@Scope("singleton")
@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {

    @Autowired(required = true)
    private NotebookDao notebookDao;

    @Autowired(required = true)
    private VendorDao vendorDao;

    @Autowired(required = true)
    private CPUDao cpuDao;

    @Autowired(required = true)
    private MemoryDao memoryDao;

    @Autowired(required = true)
    private StoreDao storeDao;

    @Autowired(required = true)
    private SalesDao salesDao;

    private NotebookServiceImpl() {}

    ////////////////////////////////////////////////////////////
    // Updates

    @Transactional
    public boolean updateCPU(CPU cpu) {
        if (cpu == null) return false;
        if (cpuDao.read(cpu.getId()) != null) {
            return cpuDao.update(cpu);
        } else {
            return (cpuDao.create(cpu) != null);
        }
    }

    @Transactional
    public boolean updateMemory(Memory memory) {
        if (memory == null) return false;
        if (memoryDao.read(memory.getId()) != null) {
            return memoryDao.update(memory);
        } else {
            return (memoryDao.create(memory) != null);
        }
    }

    @Transactional
    public boolean updateVendor(Vendor vendor) {
        if (vendor == null) return false;
        if (vendorDao.read(vendor.getId()) != null) {
            return vendorDao.update(vendor);
        } else {
            return (vendorDao.create(vendor) != null);
        }
    }

    @Transactional
    public boolean updateNotebook(Notebook notebook) {
        if (notebook == null) return false;
        if (notebookDao.read(notebook.getId()) != null) {
            return notebookDao.update(notebook);
        } else {
            return (notebookDao.create(notebook) != null);
        }
    }

    ////////////////////////////////////////////////////////////
    // Store services

    @Transactional
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store();
        store.setAmount(amount);
        store.setPrice(price);
        Notebook note = getNotebookById(noteId);
        store.setNotebook(note);

        return storeDao.create(store);
    }

    @Transactional
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

    @Transactional
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

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksByPortion(int page, int size) {
        return (List<Notebook>) notebookDao.findByPortion(page, size);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return (List<Notebook>) notebookDao.findGtAmount(amount);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return (List<Notebook>) notebookDao.findByCpuVendor(cpuVendor);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Notebook> getNotebooksFromStore() {
        return (List<Notebook>) notebookDao.findAllOnStore();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Store> getNotebooksStorePresent() {
        return (List<Store>) storeDao.findOnStorePresent();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public Map<Date, Integer> getSalesByDays() {
        return (Map<Date, Integer>) salesDao.findAllByDays();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters by Id

    @Transactional
    public Notebook getNotebookById(Long id) {
        return notebookDao.read(id);
    }

    @Transactional
    public Vendor getVendorById(Long id) {
        return vendorDao.read(id);
    }

    @Transactional
    public CPU getCPUById(Long id) {
        return cpuDao.read(id);
    }

    @Transactional
    public Memory getMemoryById(Long id) {
        return memoryDao.read(id);
    }

    @Transactional
    public Store getStoreById(Long id) {
        return storeDao.read(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get all (list)

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Notebook> getAllNotebooks() {
        return notebookDao.findAll();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Vendor> getAllVendors() {
        return vendorDao.findAll();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<CPU> getAllCPUs() {
        return cpuDao.findAll();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Memory> getAllMemories() {
        return memoryDao.findAll();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Store> getAllStores() {
        return storeDao.findAll();
    }


}
