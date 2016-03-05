package session16TRANSCTION.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16TRANSCTION.dao.EmployeeDaoImpl;
import session16TRANSCTION.dao.EmployeeDao;
import session16TRANSCTION.domain.Employee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */


@Service("eee")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl(){
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Long create(Employee ntb) {
        return employeeDao.create(ntb);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee read(Long ig) {
        return employeeDao.read(ig);
    }

    @Override
    public boolean update(Employee ntb) {
        return false;
    }

    @Override
    public boolean delete(Employee ntb) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
