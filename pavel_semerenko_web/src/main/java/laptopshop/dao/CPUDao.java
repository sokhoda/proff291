package laptopshop.dao;

import laptopshop.domain.CPU;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List<CPU> findAll();
}
