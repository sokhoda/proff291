package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Pavel on 20.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context.xml");

        Phone phone1 = cont.getBean("phone1", Phone.class);
        Phone phone2 = cont.getBean("phone2", Phone.class);

        Company company = cont.getBean("company", Company.class);

        System.out.println(company);

        System.out.println(new EmployeeDaoImpl().findAll());
    }
}
