package hw7.service;

import hw7.dao.*;
import hw7.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private SalesDao salesDao;
    private StoreDao storeDao;
    private VendorDao vendorDao;

    public NotebookServiceImpl(NotebookDao notebookDao, CPUDao cpuDao, MemoryDao memoryDao, VendorDao vendorDao, SalesDao salesDao, StoreDao storeDao) {
        this.notebookDao = notebookDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.salesDao = salesDao;
        this.storeDao = storeDao;
        this.vendorDao = vendorDao;
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
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
        if(memory == null) return false;
        if(memoryDao.read(memory.getId()) != null){
            return memoryDao.update(memory);
        } else {
            return (memoryDao.create(memory) != null);
        }
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        if(vendor == null) return false;
        if(vendorDao.read(vendor.getId()) != null){
            return vendorDao.update(vendor);
        } else {
            return (vendorDao.create(vendor) != null);
        }
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        if(notebook == null) return false;
        if(notebookDao.read(notebook.getId()) != null){
            return notebookDao.update(notebook);
        } else {
            return (notebookDao.create(notebook) != null);
        }
    }

    @Override
    public boolean removeFromStore(Store store, int amount) {
        return false;
    }


}
