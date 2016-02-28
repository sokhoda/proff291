package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.EmployeeDao;
import web.domain.Employee;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.03.15
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findUserByName(String name) {
        return employeeDao.findUserByName(name);
    }
}
