package session16TRANSCTION.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16TRANSCTION.domain.Employee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */
@Repository

public class EmployeeDaoImpl implements EmployeeDao {

    public EmployeeDaoImpl(){

    }

    @Autowired
    private SessionFactory mySessionFactory;

    @Override
    public Long create(Employee ntb) {
        Long id = null;
        id  = (Long)mySessionFactory.getCurrentSession().save(ntb);
      return id;
    }


    @Override
    public Employee read(Long id) {

        return (Employee) mySessionFactory.getCurrentSession().get(Employee.class, id);

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

    public SessionFactory getMySessionFactory() {
        return mySessionFactory;
    }

    public void setMySessionFactory(SessionFactory mySessionFactory) {
        this.mySessionFactory = mySessionFactory;
    }
}
