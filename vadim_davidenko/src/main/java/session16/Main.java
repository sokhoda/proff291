package session16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.dao.EmployeeDao;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 15.11.15
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "session16/context-db.xml"
        );
        EmployeeDao empDao = context.getBean("empDao", EmployeeDao.class);
        System.out.println(empDao.findAll());
    }
}
