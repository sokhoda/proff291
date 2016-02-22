package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Сергей on 20.02.2016.
 */
public class PhoneMain {
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context.xml");

        Phone phone1 = cont.getBean("phone1", Phone.class);
        Phone phone2 = cont.getBean("phone2", Phone.class);

        System.out.println(phone1);
        System.out.println(phone2);
    }
}
