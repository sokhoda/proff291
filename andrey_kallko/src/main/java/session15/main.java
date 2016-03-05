package session15;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by elenabugercuk on 20.02.16.
 */
public class Main {



    public static void main(String[] args) {
        ApplicationContext cont= new ClassPathXmlApplicationContext("session15/context.xml");
        Phone phone1= cont.getBean("phone1", Phone.class);
        Phone phone2= cont.getBean("phone2", Phone.class);


        Phone phone3= cont.getBean("phone3", Phone3.class);

//
          System.out.println(phone3);
//        System.out.println(phone2);
//
//        Car car1 = cont.getBean("car1", Car.class);
//        Director dir1 = cont.getBean("dir1", Director.class);

//        Company company1=cont.getBean("company1", Company.class);
//        System.out.println(company1);
    }
}
