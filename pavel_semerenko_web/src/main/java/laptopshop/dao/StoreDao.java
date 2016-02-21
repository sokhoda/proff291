package laptopshop.dao;

import laptopshop.domain.Store;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface StoreDao {
    Long create(Store cpu);
    Store read(Long id);
    boolean update(Store cpu);
    boolean delete(Store cpu);
    List<Store> findAll();
}
