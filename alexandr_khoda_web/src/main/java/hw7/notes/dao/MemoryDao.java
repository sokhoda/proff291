package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
public interface MemoryDao {
    Long create(Memory memory);
    Memory read(Long id);
    boolean update(Memory memory);
    boolean delete(Memory memory);
    boolean checkExist(Memory memory) throws HibernateException;
    boolean checkExistExceptId(Memory memory, Long memoryID) throws
            HibernateException;
    List findAll();
}
