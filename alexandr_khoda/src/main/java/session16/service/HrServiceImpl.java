package session16.service;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;

/**
 * Created by s_okhoda on 21.02.2016.
 */
@Service
@Transactional
public class HrServiceImpl implements  HrService {

    private SessionFactory factory;

    private static Logger log = Logger.getLogger(HrService.class);
    private EmployeeDao empDao;

    @Override
    public Integer getESalary(String name) {
        return empDao.getESalary(name);
    }
}
