package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;

import java.util.List;


/**
 * Created by Admin on 17.02.2016.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List findAll();
    List getNotebooksGtAmount(int amount);
}
