package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.dao.EmployeeDao;
import session16.domain.Employee;
import session16.service.EmployeeService;
import session16.service.EmployeeServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 21.02.2016.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session16/transactionalContext.xml");

        EmployeeService employeeService = context.getBean("empService", EmployeeService.class);
        List<Integer> salary = employeeService.getEmployeeSalaryByName("John");
        System.out.println(salary.toString());

        Employee employee = new Employee("NEWMAN", "kto-to");
        int id = employeeService.createEmployee(employee);
    }
}