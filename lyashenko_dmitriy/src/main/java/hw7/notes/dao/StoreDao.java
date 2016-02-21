package hw7.notes.dao;

import antlr.collections.List;
import hw7.notes.damain.Store;

/**
 * Created by Admin on 17.02.2016.
 */
public interface StoreDao {
    Long create(Store store);
    Store read(Long id);
    boolean update(Store store);
    boolean delete(Store store);
    List findAll();
}
