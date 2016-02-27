package session15;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 20.02.2016.
 */
public class MainEmp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        List<Employee> list = new EmployeeDaoImpl().findAll();
        System.out.println(list);


    }
}
