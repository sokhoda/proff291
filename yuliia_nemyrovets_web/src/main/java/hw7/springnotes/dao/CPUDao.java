package hw7.springnotes.dao;

import hw7.springnotes.domain.Cpu;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public interface CpuDao {
    Long create(Cpu cpu);
    Cpu read(Long id);
    boolean update(Cpu cpu);
    boolean delete(Cpu cpu);
    List findAll();
}
