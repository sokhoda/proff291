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

    @Override
    public Long receive(Long noteId, int amount, double price) {

        return 0L;
    }

    @Override
    public Long sale(Long storeId, int amount) {

        return 0L;
    }

    @Override
    public boolean updateCPU(CPU cpu) {

        return false;
    }

    @Override
    public boolean updateMemory(Memory memory) {

        return false;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {

        return false;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {

        return false;
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {

        return false;
    }

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

    public Long createNotebook(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    public Long createVendor(Vendor vendor) {
        return vendorDao.create(vendor);
    }

    public Long createCPU(CPU cpu) {
        return cpuDao.create(cpu);
    }

    public Long createMemory(Memory memory) {
        return memoryDao.create(memory);
    }

    public List<Notebook> getAllNotebooks() {
        return notebookDao.findAll();
    }

    public List<Vendor> getAllVendors() {
        return vendorDao.findAll();
    }

    public List<CPU> getAllCPUs() {
        return cpuDao.findAll();
    }

    public List<Memory> getAllMemories() {
        return memoryDao.findAll();
    }

}
