package hw7.service;

import hw7.domain.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface NotebookService {
    Long receive(Long noteId, int amount, double price);

    Long sale(Long storeId, int amount);

    List getNotebooksByPortion(int size);

    List getNotebooksGtAmount(int amount);

    List getNotebooksByCpuVendor(Vendor cpuVendor);

    List getNotebooksFromStore();

    List getNotebooksStorePresent();

    Map getSalesByDays();

    boolean updateCPU(CPU cpu);

    boolean updateMemory(Memory memory);

    boolean updateVendor(Vendor vendor);

    boolean updateNotebook(Notebook notebook);

    boolean removeFromStore(Store store, int amount);

}
