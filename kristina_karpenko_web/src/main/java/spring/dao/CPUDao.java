package spring.dao;

import spring.domain.CPU;
import spring.domain.Vendor;

import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
    List findCPUbyVendor(Vendor vendor);
    CPU findCPUByName(String name);
}
