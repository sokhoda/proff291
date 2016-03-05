package SpringHibernateTransaction.service;

import SpringHibernateTransaction.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenchi on 21.02.16.
 */
@Repository
@Transactional
public class EmployeeServiceImplDAO implements EmployeeServiceDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getSalaryForEmployee(String EmployeeFirstName) {
        return null;
    }
}
