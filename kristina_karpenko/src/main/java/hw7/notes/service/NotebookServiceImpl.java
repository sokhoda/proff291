package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 15.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {
    @Override
    public Long receive(Long noteId, int amount, double price) {
        return null;
    }

    @Override
    public Long sale(Long storeId, int amount) {
        return null;
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
}
