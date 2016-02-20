package laptopshop.dao;

import laptopshop.domain.Memory;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
public interface MemoryDao {
    Long create(Memory cpu);
    Memory read(Long id);
    boolean update(Memory cpu);
    boolean delete(Memory cpu);
    List<Memory> findAll();
}
