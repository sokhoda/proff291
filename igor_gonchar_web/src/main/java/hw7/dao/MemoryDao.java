package hw7.dao;

import hw7.domain.Memory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface MemoryDao {
    public Long create(Memory memory);

    public Memory read(Long id);

    public boolean update(Memory memory);

    public boolean delete(Memory memory);

    public List findAll();
}
