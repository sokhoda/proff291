package hw7.notes.service;


import hw7.notes.domain.*;
import hw7.notes.exception.PortionException;
import hw7.notes.exception.StoreException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by s_okhoda on 09.02.2016.
 */
public interface NotebookService {

    Long receive(Long noteId, int amount, double price);
    Long sale(Long storeId, int amount) throws StoreException;
    boolean updateCPU(CPU cpu);
    boolean updateMemory(Memory memory);
    boolean updateVendor(Vendor vendor);
    boolean updateNotebook(Notebook notebook);
    boolean removeFromStore(Store store, int amount);

    List getNotebooksByPortion(int size, int cnt)throws PortionException;
    List getNotebooksGtAmount(int amount);
    List getNotebooksByCpuVendor(Vendor cpuVendor);
    List getNotebooksFromStore();
    List getNotebooksStorePresent();
    Map getSalesByDays();

//    Long add(Notebook notebook);
//    List findAll();
//    boolean changePrice(Long id, double price);
//    boolean changeSerialVendor(Long id, String serial, String vendor);
//    boolean delete(Long id);
//
//    boolean deleteByModel(String model);
//    List findByVendor(String vendor);
//    List findByPriceManufDate(Double price, Date date);
//    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo,
//                                        Date date, String vendor);
}
