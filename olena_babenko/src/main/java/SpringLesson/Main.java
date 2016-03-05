package SpringLesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenchi on 20.02.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("SpringLesson/context2.xml");

        Phone phone1 = cont.getBean("phone1",Phone.class);
        //возвращает объект типа bean phone1, созданного из класса Phone
        Phone phone2 = cont.getBean("phone2",Phone.class);

        System.out.println(phone1);
        System.out.println(phone2);
    }
}
