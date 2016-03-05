package Session16;

import Session16.Servise.EmplService;
import Session16.Servise.EmplServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Пк2 on 23.02.2016.
 */
public class MainSpring {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context=new ClassPathXmlApplicationContext("Session16/EmployeeContextDb.xml");

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Employee First name");
        String firstName=scan.nextLine();
        System.out.println("Enter Employee Last name");
        String lastName=scan.nextLine();
         EmplService service=context.getBean("Service1",EmplServiceImpl.class);
         System.out.println("Employee: "+firstName+" "+lastName+" salary:");
         System.out.println(service.getSalaryByEmplName(firstName,lastName).toString());

      //  System.out.println("Enter Employee First name");
       // System.out.println(service);

    }

}
