package session16;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Сергей on 21.02.2016.
 */

public class EmployeeServise {

    @Autowired
    private SessionFactory factory;


    @Transactional
    public int getSalary (Employee employee) {
        int salary = 0;
        Session tmpSession = factory.getCurrentSession();
        Query query = tmpSession.createQuery("from Employee");
        List <session16.Employee> users = query.list();

        for (int i=0;i<users.size();i++) {
            if (employee.getId()==users.get(i).getId()) {
                return users.get(i).getSalary();
            }
        }
        return -1;
    }
}
