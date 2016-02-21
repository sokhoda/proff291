package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Home on 20.02.2016.
 */
public class MainCar {
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context.xml");

        Phone phone1 = cont.getBean("phone1", Phone.class);
        Phone phone2 = cont.getBean("phone2", Phone.class);
        Phone phone3 = cont.getBean("phone3", Phone.class);
        Phone phone4 = cont.getBean("phone4", Phone.class);

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.println(phone4);

        System.out.println("-------------");
        Car car1 = cont.getBean("car1", Car.class);
        Company company1 = cont.getBean("company1", Company.class);
        Director director1 = cont.getBean("director1", Director.class);

        System.out.println(car1);
        System.out.println(company1);
        System.out.println(director1);


    }
}
