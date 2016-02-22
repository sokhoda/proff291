package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;

import java.util.*;

/**
 * Created by Вадим on 14.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;
    private VendorDao vendorDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private StoreDao storeDao;
    private SalesDao salesDao;

    private static int pageCounter = -1;

    private NotebookServiceImpl() {}

    public NotebookServiceImpl(NotebookDao notebookDao, VendorDao vendorDao, CPUDao cpuDao,
                               MemoryDao memoryDao, StoreDao storeDao, SalesDao salesDao) {
        this.notebookDao = notebookDao;
        this.vendorDao = vendorDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.storeDao = storeDao;
        this.salesDao = salesDao;
    }

    ////////////////////////////////////////////////////////////
    // Updates

    @Override
    public boolean updateCPU(CPU cpu) {
        if (cpu == null) return false;
        if (cpuDao.read(cpu.getId()) != null) {
            return cpuDao.update(cpu);
        } else {
            return (cpuDao.create(cpu) != null);
        }
    }

    @Override
    public boolean updateMemory(Memory memory) {
        if (memory == null) return false;
        if (memoryDao.read(memory.getId()) != null) {
            return memoryDao.update(memory);
        } else {
            return (memoryDao.create(memory) != null);
        }
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        if (vendor == null) return false;
        if (vendorDao.read(vendor.getId()) != null) {
            return vendorDao.update(vendor);
        } else {
            return (vendorDao.create(vendor) != null);
        }
    }

    @Override
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

    @Override
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store();
        store.setAmount(amount);
        store.setPrice(price);
        Notebook note = getNotebookById(noteId);
        store.setNotebook(note);

        return storeDao.create(store);
    }

    @Override
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

    @Override
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

    ///////////////////////////////////////////////////////////////////////////
    // Getters by Id

    @Override
    public Notebook getNotebookById(Long id) {
        return notebookDao.read(id);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorDao.read(id);
    }

    @Override
    public CPU getCPUById(Long id) {
        return cpuDao.read(id);
    }

    @Override
    public Memory getMemoryById(Long id) {
        return memoryDao.read(id);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeDao.read(id);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get all (list)

    @Override
    public List<Notebook> getAllNotebooks() {
        return notebookDao.findAll();
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorDao.findAll();
    }

    @Override
    public List<CPU> getAllCPUs() {
        return cpuDao.findAll();
    }

    @Override
    public List<Memory> getAllMemories() {
        return memoryDao.findAll();
    }

    @Override
    public List<Store> getAllStores() {
        return storeDao.findAll();
    }

    /////////////////////////////////////////////////////////////
    // Reports

    @Override
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

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {
        return (List<Notebook>) notebookDao.findGtAmount(amount);
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {
        return (List<Notebook>) notebookDao.findByCpuVendor(cpuVendor);
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {
        return (List<Notebook>) notebookDao.findAllOnStore();
    }

    @Override
    public List<Store> getNotebooksStorePresent() {
        return (List<Store>) storeDao.findOnStorePresent();
    }

    @Override
    public Map<Date, Integer> getSalesByDays() {
        return (Map<Date, Integer>) salesDao.findAllByDays();
    }


}
