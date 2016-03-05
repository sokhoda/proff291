package session16.ses16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.ses15.dao.EmployeeDao;
import session16.ses15.domain.Employee;

import java.util.Locale;

/**
 * Created by Администратор on 21.02.2016.
 */
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session16/context-db.xml");


        EmployeeDao employeeDao = cont.getBean("dao", EmployeeDao.class);

        Employee allEmployee = employeeDao.findAllEmployee();
        System.out.println(allEmployee);
    }
}
