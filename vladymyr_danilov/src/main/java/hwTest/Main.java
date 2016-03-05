package hwTest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 14.11.15
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext(
                "hwTest/context-db.xml"
        );

//        Phone phone1 = cont.getBean("phone1", Phone.class);
//        Phone phone2 = cont.getBean("phone2", Phone.class);
//
//        System.out.println(phone1);
//        System.out.println(phone2);

    }
}
