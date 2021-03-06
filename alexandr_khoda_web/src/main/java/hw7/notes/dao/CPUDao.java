package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.exception.PortionException;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    boolean checkExist(CPU cpu) throws HibernateException;
    boolean checkExistExceptId(CPU cpu, Long cpuID) throws HibernateException;
    List findAll();
    List getCPUByPortion(int size, int cnt)throws PortionException, HibernateException;
}
