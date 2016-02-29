package hw7.springnotes.dao;

import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public interface VendorDao {

    Long create(Vendor vendor);

    Vendor read(Long id);

    boolean update(Vendor vendor);

    boolean delete(Vendor vendor);

    List findAll();
}
