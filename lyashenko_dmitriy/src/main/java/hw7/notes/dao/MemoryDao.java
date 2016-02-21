package hw7.notes.dao;

import hw7.notes.damain.Memory;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List findAll();

}
