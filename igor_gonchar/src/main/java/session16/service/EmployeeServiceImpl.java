package session16.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;
import session16.domain.Employee;

import java.util.List;

/**
 * Created by Home on 21.02.2016.
 */
@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired(required = true)
    private EmployeeDao empDao;

    public EmployeeServiceImpl() {
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteEmployee(Employee employee) {
        return empDao.delete(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getEmployeeSalaryByName(String name) {
        return empDao.getEmployeeSalaryByName(name);
    }

    @Override
    @Transactional
    public Integer createEmployee(Employee employee) {
        return empDao.create(employee);
    }
}
