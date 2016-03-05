package hw7.notes.dao;

import java.util.List;
import hw7.notes.domain.Store;

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
