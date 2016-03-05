package hw7.dao;

import hw7.domain.CPU;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public interface CPUDao {
    Long create(CPU cpu);

    CPU read(Long id);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List findAll();
}
