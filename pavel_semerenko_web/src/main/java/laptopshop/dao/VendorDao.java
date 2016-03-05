package laptopshop.dao;

import laptopshop.domain.Vendor;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface VendorDao {
    Long create(Vendor cpu);
    Vendor read(Long id);
    boolean update(Vendor cpu);
    boolean delete(Vendor cpu);
    List<Vendor> findAll();
}
