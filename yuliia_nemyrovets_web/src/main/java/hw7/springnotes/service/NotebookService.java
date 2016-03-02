package hw7.springnotes.service;

import hw7.springnotes.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Юлия on 19.02.2016.
 */

public interface NotebookService {

       Long receive(Long noteId, int amount, double price);

    Long sale(Long storeId, int amount);

    boolean updateCpu(Cpu cpu);

    boolean updateMemory(Memory memory);

    boolean updateVendor(Vendor vendor);

    boolean updateNotebook(Notebook notebook);

    boolean removeFromStore(Store store, int amount);

    List getNotebooksByPortion(int size);

    List getNotebooksGtAmount(int amount);

    List getNotebooksByCpuVendor(Vendor cpuVendor);

    List getNotebooksFromStore();

    List getNotebooksStorePresent();

    Map getSalesByDays();
}
