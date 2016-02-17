package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List findAll();
}
