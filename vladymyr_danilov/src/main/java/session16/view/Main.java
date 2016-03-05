package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.dao.EmployeeDao;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session16/transactionalContext.xml");

        EmployeeDao empDao = context.getBean("empDao", EmployeeDao.class);
        System.out.println(empDao.findAll());
    }
}
