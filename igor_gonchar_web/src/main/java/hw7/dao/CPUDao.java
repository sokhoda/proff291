package hw7.dao;

import hw7.domain.CPU;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface CPUDao {
    public Long create(CPU cpu);

    public CPU read(Long id);

    public boolean update(CPU cpu);

    public boolean delete(CPU cpu);

    public List findAll();
}
