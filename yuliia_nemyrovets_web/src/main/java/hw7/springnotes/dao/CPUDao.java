package hw7.springnotes.dao;

import hw7.notes.domain.CPU;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
}
