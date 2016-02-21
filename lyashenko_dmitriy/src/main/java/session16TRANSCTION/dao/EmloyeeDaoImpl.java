package session16TRANSCTION.dao;

import org.hibernate.SessionFactory;
import session16.Employee;
import session16TRANSCTION.domain.Emloyee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */

public class EmloyeeDaoImpl implements EmployeeDao {

    public EmloyeeDaoImpl(){}

    private SessionFactory factory;

    @Override
    public Long create(Emloyee ntb) {
        Long id  = (Long)factory.getCurrentSession().save(ntb);
      return id;
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

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
