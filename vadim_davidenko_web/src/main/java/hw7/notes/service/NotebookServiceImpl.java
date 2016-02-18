package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

        return 0L;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {

        return false;
    }

    /////////////////////////////////////////////////////////////
    // Sales

    @Override
    public Long sale(Long storeId, int amount) {

        return 0L;
    }

    /////////////////////////////////////////////////////////////
    // Reports

    @Override
    public List<Notebook> getNotebooksByPortion(int size) {

        return null;
    }

    @Override
    public List<Notebook> getNotebooksGtAmount(int amount) {

        return null;
    }

    @Override
    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {

        return null;
    }

    @Override
    public List<Notebook> getNotebooksFromStore() {

        return null;
    }

    @Override
    public List<Notebook> getNotebooksStorePresent() {

        return null;
    }

    @Override
    public Map<Date, Integer> getSalesByDays() {

        return null;
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

}
