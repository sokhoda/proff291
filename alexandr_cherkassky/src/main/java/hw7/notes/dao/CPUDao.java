package hw7.notes.dao;

import hw7.notes.domain.CPU;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public interface CPUDao  {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
