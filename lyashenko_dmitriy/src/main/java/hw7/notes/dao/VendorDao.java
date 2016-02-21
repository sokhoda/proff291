package hw7.notes.dao;

import antlr.collections.List;
import hw7.notes.damain.Vendor;

/**
 * Created by Admin on 17.02.2016.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List findAll();
}
