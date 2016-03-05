package session16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;
import session16.dao.EmployeeDaoImpl;
import session16.domain.Employee;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */

@Service("serviceImpl")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl() {
        this.dao = new EmployeeDaoImpl();

    }
    @Autowired
    private EmployeeDao dao;



    @Transactional(readOnly = true)
    @Override
    public List findByName(String firstName) {
        return dao.findName(firstName);
    }

    @Transactional(readOnly = true)
    @Override
    public List findAll() {
        return dao.findAllEmployee();
    }

    public EmployeeDao getDao() {
        return dao;
    }

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }
    @Transactional(readOnly = true)
    @Override
    public Employee read(Long ig) {
        return dao.read(ig);
    }


}



