package session16TRANSCTION.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16TRANSCTION.service.EmployeeService;


import java.util.Locale;

/**
 * Created by Solyk on 21.02.2016.
 */
public class EmployeeMain {
    public static void main(String[] args) {
       Locale.setDefault(Locale.ENGLISH);
        ApplicationContext con = new ClassPathXmlApplicationContext("session16/context-dbdb.xml");
        EmployeeService eee = con.getBean("eee", EmployeeService.class);
//        EmployeeDao eee = con.getBean("eee", EmployeeDao.class);

        System.out.print(eee.read(100L));

    }
}
