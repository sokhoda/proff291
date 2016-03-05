package session16.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;
import session16.domain.Employee;

@Transactional
@Repository("empDao")
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeServiceImpl() {
    }

    @Override
    public Integer getSalaryById(Long id) {
        Employee employee = employeeDao.read(id);
        return employee.getSalary();
    }
}
