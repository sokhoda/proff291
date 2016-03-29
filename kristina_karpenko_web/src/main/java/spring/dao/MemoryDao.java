package spring.dao;


import spring.domain.Memory;

import java.util.List;

/**
 * Created by Kris on 15.02.2016.
 */
public interface MemoryDao {
    Long create(Memory memory);

    Memory read(Long id);

    boolean update(Memory memory);

    boolean delete(Memory memory);

    List findAll();

    Memory findMemoryByName(String nameVend, String size);
}
