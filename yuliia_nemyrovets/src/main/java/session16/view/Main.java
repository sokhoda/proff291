package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.dao.EmployeeDao;
import session16.domain.Employee;
import session16.service.EmployeeService;

import java.util.List;
import java.util.Locale;

/**
 * Created by Юлия on 22.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session16/context-db.xml");

        EmployeeDao employeeDao = cont.getBean("empoyeeImpl", EmployeeDao.class);

        List<Employee> list = employeeDao.findAllEmployee();
        System.out.println(list);

    }
}
