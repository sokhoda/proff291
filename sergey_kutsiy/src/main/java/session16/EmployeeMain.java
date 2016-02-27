package session16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Сергей on 21.02.2016.
 */
public class EmployeeMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session16/context.xml");
        EmployeeServise srv1 = new EmployeeServise();
        Employee empl1 = new Employee();
        srv1.getSalary(empl1);
    }
}
