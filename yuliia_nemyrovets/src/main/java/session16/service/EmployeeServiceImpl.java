package session16.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */
    @Transactional
    @Service("serviceEmpl")
    public class EmployeeServiceImpl implements EmployeeService{
        EmployeeDao dao;

        @Override
        @Transactional(readOnly = true)
        public List findByName(String name) {
            return dao.findName(name);
        }

    @Override
    public List findAll() {
        return dao.findAllEmployee();
    }
}


