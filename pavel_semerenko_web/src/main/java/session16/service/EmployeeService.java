package session16.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import session16.dao.EmployeeDao;

/**
 * Created by Pavel on 20.02.2016.
 */
public class EmployeeService{

    @Transactional(readOnly = true)
    public Double getSalaryById(Long id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session16/transactionalContext.xml");
        return context.getBean("employeeDaoImpl", EmployeeDao.class).getSalaryById(id);
    }
}
