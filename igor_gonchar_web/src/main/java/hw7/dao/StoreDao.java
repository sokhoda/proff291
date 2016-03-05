package hw7.dao;

import hw7.domain.Store;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface StoreDao {
    public Long create(Store store);

    public Store read(Long id);

    public boolean update(Store store);

    public boolean delete(Store store);

    public List findAll();
}
