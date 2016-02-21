package laptopshop.dao;

import laptopshop.domain.Sales;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface SalesDao {
    Long create(Sales cpu);
    Sales read(Long id);
    boolean update(Sales cpu);
    boolean delete(Sales cpu);
    List<Sales> findAll();
}
