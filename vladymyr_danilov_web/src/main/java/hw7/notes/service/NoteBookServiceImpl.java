package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;

import java.util.Date;

public class NoteBookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private SalesDao salesDao;
    private StoreDao storeDao;
    private VendorDao vendorDao;

    public NoteBookServiceImpl(NotebookDao notebookDao, CPUDao cpuDao, MemoryDao memoryDao, SalesDao salesDao, StoreDao storeDao, VendorDao vendorDao) {
        this.notebookDao = notebookDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.salesDao = salesDao;
        this.storeDao = storeDao;
        this.vendorDao = vendorDao;
    }

    public NoteBookServiceImpl() {
    }

    @Override
    public Long receive(Long noteId, int amount, double price) {
        Store store = new Store();
        store.setQuantity(amount);
        store.setPrice(price);
        store.setNotebook(notebookDao.read(noteId));

        return storeDao.create(store);
    }

    @Override
    public Long sale(Long storeId, int amount) {
        Store store = storeDao.read(storeId);
        if ( store != null ) {
            Integer currentQuantity = store.getQuantity();
            if ( currentQuantity >= amount ) {
                currentQuantity -= amount;
                store.setQuantity(currentQuantity);
                storeDao.update(store);
            } else if ( currentQuantity == 0 ) {
                storeDao.delete(store);
            }
        } else {
            return 0L;
        }

        Sales sales = new Sales();
        sales.setQuantity(amount);
        sales.setStore(store);
        sales.setDate(new Date());

        return salesDao.create(sales);
    }
}
