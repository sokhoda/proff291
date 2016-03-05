package session16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.dao.EmployeeDao;
import session16.domain.Employee;

import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 20.02.2016.
 */
public class MainEmp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session16/context-db.xml");

        EmployeeDao employeeDao = context.getBean("empDao", EmployeeDao.class);

        List<Employee> list = employeeDao.findAll();
        System.out.println(list);


    }
}
