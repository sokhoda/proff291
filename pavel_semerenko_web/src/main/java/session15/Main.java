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
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context-db.xml");

        System.out.println(cont.getBean("empDao", EmployeeDao.class).findAll());
    }
}