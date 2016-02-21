package laptopshop.dao;

import laptopshop.domain.Laptop;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface LaptopDao {
    Long create(Laptop cpu);
    Laptop read(Long id);
    boolean update(Laptop cpu);
    boolean delete(Laptop cpu);
    List<Laptop> findAll();
}
