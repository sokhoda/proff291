package spring.dao;


import spring.domain.Notebook;
import spring.domain.Store;
import spring.domain.Vendor;

import java.util.List;

/**
 * Created by Kris on 15.02.2016.
 */
//Показать все ноутбуки по указанному имени производителя процессора
public interface NotebookDao {
    Long create(Notebook notebook);

    Notebook read(Long id);

    boolean update(Notebook notebook);

    boolean delete(Notebook notebook);

    List findAll();

    List findAll(int size, int from);

    Notebook findNotebookByParam(String vendor, String model, String modelCPU, String vendMemory, String sizeMemory);

    List findNotebooksGtAmount(int amount);

    List findNotebooksByCpuVendor(Vendor cpuVendor);

    List getNotebooksFromStore();

    Store receive(Long noteId, int amount, double price);
}
