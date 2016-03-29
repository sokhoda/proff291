package hw7.notes.dao;

import hw7.notes.domain.Memory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    List findAll();
}
