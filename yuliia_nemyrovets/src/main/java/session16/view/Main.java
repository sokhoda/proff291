package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.service.EmployeeService;

import java.util.Locale;

/**
 * Created by Юлия on 22.02.2016.
 */
public class Main {
    public static void main(String [] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont=new ClassPathXmlApplicationContext("session16/context-db.xml");

        EmployeeService service=cont.getBean("serviceEmpl",EmployeeService.class);
        System.out.println(service.findAll());

    }
}
