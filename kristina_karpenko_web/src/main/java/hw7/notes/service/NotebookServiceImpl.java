package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 15.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDao notebookDao;
    private Notebook notebook;
    private CPUDao cpuDao;
    private CPU cpus;
    private MemoryDao memoryDao;
    private Memory memory;
    private StoreDao storeDao;
    private SalesDao salesDao;


    public NotebookServiceImpl(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public NotebookServiceImpl(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public NotebookServiceImpl(SalesDao salesDao) {
        this.salesDao = salesDao;
    }


    @Override
    public Long receive(Long noteId, int amount, double price) {
        return null;
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
        cpus = cpuDao.read(cpu.getId());
        if (cpus != null) {
            cpuDao.update(cpu);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        this.memory = memoryDao.read(memory.getId());
        if (this.memory != null) {
            memoryDao.update(memory);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        VendorDao vendorDao = null;
        Vendor vend = vendorDao.read(vendor.getId());
        if (vend != null) {
            vendorDao.update(vendor);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNotebook(Notebook notebook) {
        this.notebook = notebookDao.read(notebook.getId());
        if (this.notebook != null) {
            notebookDao.update(notebook);
            return true;
        }
        return false;
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
        return  null;
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        if (amount == 0) {
            List<Notebook> list = notebookDao.findAll();
            return list;
        }
        List<Notebook> list = notebookDao.findNotebooksGtAmount(amount);
        return list;
    }

    @Override
    public List getNotebooksByCpuVendor(Vendor cpuVendor) {
        List<Object> list = notebookDao.findNotebooksByCpuVendor(cpuVendor);
        return list;
    }

    @Override
    public List getNotebooksFromStore() {
        List<Object> list = notebookDao.findAll();
        return list;
    }

    @Override
    public List getNotebooksStorePresent() {
        List<Object> list = notebookDao.getNotebooksFromStore();
        return list;
    }

    @Override
    public Map getSalesByDays() {
        Map<Sales, Notebook> map = salesDao.getSalesByDays();
        return map;
    }
}
