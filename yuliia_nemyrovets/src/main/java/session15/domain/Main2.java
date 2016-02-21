package session15.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Юлия on 20.02.2016.
 */
public class Main2 {
    public static void main(String [] args){
        ApplicationContext cont=new ClassPathXmlApplicationContext("session15/Context.xml");
       // Phone phone=cont.getBean("phone1",Phone.class);
      //  Phone phone2=cont.getBean("phone2",Phone.class);
        Company company=cont.getBean("company", Company.class);
//        Ditector director =cont.getBean("director", Ditector.class);
//        Car car=cont.getBean("car", Car.class);
        System.out.println(company);

    }

}
