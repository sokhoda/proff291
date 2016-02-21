package session16TRANSCTION.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import session16.Employee;
import session16TRANSCTION.dao.EmloyeeDaoImpl;
import session16TRANSCTION.dao.EmployeeDao;
import session16TRANSCTION.domain.Emloyee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */
@Transactional
@Component("empS")
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl(){
        this.employeeDao = new EmloyeeDaoImpl();
    }

    private EmployeeDao employeeDao;

    @Autowired
    @Override
    public Long create(Emloyee ntb) {
        return employeeDao.create(ntb);
    }

    @Override
    public Emloyee read(Long ig) {
        return null;
    }

    @Override
    public boolean update(Emloyee ntb) {
        return false;
    }

    @Override
    public boolean delete(Emloyee ntb) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }
}
