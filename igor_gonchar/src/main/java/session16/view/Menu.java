package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.dao.EmployeeDao;
import session16.service.EmployeeService;
import session16.service.EmployeeServiceImpl;

import java.util.Locale;

/**
 * Created by Home on 21.02.2016.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session16/transactionalContext.xml");

        EmployeeService employeeService = context.getBean("empService", EmployeeService.class);
        int salary = employeeService.getEmployeeSalaryByName("Igor");
        System.out.println(salary);


    }
}
