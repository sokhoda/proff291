package session16.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.service.EmployeeService;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Юлия on 22.02.2016.
 */
public class Main {
    public static void main(String [] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont=new ClassPathXmlApplicationContext("session16/context-db.xml");

        EmployeeService service=cont.getBean("serviceEmpl",EmployeeService.class);
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Employee last Name");
        String lastName=scan.nextLine();
        System.out.println(service.findByName(lastName));

    }
}
