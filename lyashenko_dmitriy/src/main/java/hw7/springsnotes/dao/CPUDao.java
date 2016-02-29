package hw7.springsnotes.dao;



import hw7.springsnotes.domain.CPU;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
   CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();

}
