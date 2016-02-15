package hw7.notes.service;

import hw7.notes.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 14.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {

    public Long receive(Long noteId, int amount, double price) {

        return 0L;
    }

    public Long sale(Long storeId, int amount) {

        return 0L;
    }

    public boolean updateCPU(CPU cpu) {

        return false;
    }

    public boolean updateMemory(Memory memory) {

        return false;
    }

    public boolean updateVendor(Vendor vendor) {

        return false;
    }

    public boolean updateNotebook(Notebook notebook) {

        return false;
    }

    public boolean removeFromStore(Store store, int amount) {

        return false;
    }

    public List<Notebook> getNotebooksByPortion(int size) {

        return null;
    }

    public List<Notebook> getNotebooksGtAmount(int amount) {

        return null;
    }

    public List<Notebook> getNotebooksByCpuVendor(Vendor cpuVendor) {

        return null;
    }

    public List<Notebook> getNotebooksFromStore() {

        return null;
    }

    public List<Notebook> getNotebooksStorePresent() {

        return null;
    }

    public Map<Date, Integer> getSalesByDays() {

        return null;
    }
}
