package session16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */
@Transactional
@Service("serviceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired(required = true)
    private EmployeeDao dao;

    public EmployeeServiceImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public List findByName(String name) {
        return dao.findName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return dao.findAllEmployee();
    }
}


