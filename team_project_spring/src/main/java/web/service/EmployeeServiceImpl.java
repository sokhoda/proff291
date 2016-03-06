package web.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.EmployeeDao;
import web.domain.Department;
import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.03.15
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> findAllInDepartmentByPortion(Department department, Long cnt) {
        return null;
    }

    @Override
    public List<Employee> findAllInDepartment(Department department) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("from Employee e join e.department d where d.id = :deptID")
                .setParameter("deptID", department.getId());
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
