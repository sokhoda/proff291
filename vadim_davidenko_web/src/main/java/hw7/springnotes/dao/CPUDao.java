package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);

    CPU read(Long id);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List findAll();
}
