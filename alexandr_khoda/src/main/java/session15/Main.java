package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext
                ("session15/context.xml");
//        Phone phone1 = cont.getBean("phone1", Phone.class);
//        Phone phone2 = cont.getBean("phone2", Phone.class);
//
//        System.out.println(phone1);
//        System.out.println(phone2);
//
        Car car1 = cont.getBean("car1", Car.class);
        Chef chef1 = cont.getBean("chef1", Chef.class);
        Company company1 = cont.getBean("comp1", Company.class);

        System.out.println(car1);
        System.out.println(chef1);
        System.out.println(company1);



    }
}
