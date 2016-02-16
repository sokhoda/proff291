package hw7.dao;

import hw7.domain.Vendor;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface VendorDao {
    public Long create(Vendor vendor);

    public Vendor read(Long id);

    public boolean update(Vendor vendor);

    public boolean delete(Vendor vendor);

    public List findAll();
}
