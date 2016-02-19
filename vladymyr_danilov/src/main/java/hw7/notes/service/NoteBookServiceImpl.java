package hw7.notes.service;

import hw7.notes.dao.*;

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
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
    }
}
