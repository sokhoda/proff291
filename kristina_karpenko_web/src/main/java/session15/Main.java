package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * Created by Администратор on 20.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session15/context.xml");

    Phone phone1 = context.getBean("phone1",Phone.class);
//        Phone phone2 = context.getBean("phone2",Phone.class);
//
//        System.out.println(phone1);
//        System.out.println(phone2);

     Company company = context.getBean("company",Company.class);
//        Car car = context.getBean("car",Car.class);
//        Director director = context.getBean("director",Director.class);
//
//        System.out.println(car);
//        System.out.println(director);
        System.out.println(company);
//        System.out.println(phone1);


    }
}
