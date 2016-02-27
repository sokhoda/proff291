package session15;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Сергей on 20.02.2016.
 */
public class EmploteeMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context.xml");

        session15.EmployeeDao emp2 = cont.getBean("emplDao", EmployeeDao.class);
        emp2.getAllEmployees();
    }
}
