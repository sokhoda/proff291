package session16TRANSCTION.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16TRANSCTION.domain.Emloyee;
import session16TRANSCTION.service.EmployeeServiceImpl;

import java.util.Locale;

/**
 * Created by Solyk on 21.02.2016.
 */
public class EmployeeMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session16/context-db.xml");
        EmployeeServiceImpl empS = cont.getBean("empS", EmployeeServiceImpl.class);
        Emloyee emloyee = new Emloyee();
        Long im  = empS.create(emloyee);
        System.out.print(im);
    }
}
