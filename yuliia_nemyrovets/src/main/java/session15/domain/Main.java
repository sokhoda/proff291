package session15.domain;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Юлия on 20.02.2016.
 */
public class Main {

    public static void main(String [] args){
        ApplicationContext cont=new ClassPathXmlApplicationContext("session15/Context.xml");
        Phone phone=cont.getBean("phone1",Phone.class);
        Phone phone2=cont.getBean("phone2",Phone.class);
        System.out.println(phone);
        System.out.println(phone2);
    }

}

