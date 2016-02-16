package hw7.notes.dao;

import hw6.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
public interface VendorDao {
    Long create(Vendor vendor);
    Vendor read(Long id);
    boolean update(Vendor vendor);
    boolean delete(Vendor vendor);
    List findAll();
}
