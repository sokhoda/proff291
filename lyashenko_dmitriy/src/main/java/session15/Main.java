package session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session13.Employee;

import java.util.List;
import java.util.Locale;

/**
 * Created by Solyk on 20.02.2016.
 */
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context-db.xml");
//        Phone phone1 = cont.getBean("phone1", Phone.class);
//        Phone phone2 = cont.getBean("phone2", Phone.class);
//
//        Car car = cont.getBean("car", Car.class);
//        Director director = cont.getBean("director", Director.class);
//        Company company = cont.getBean("company", Company.class);
//
//        System.out.println(phone1);
//        System.out.println(phone2);
//
//        System.out.println(car);
//        System.out.println(director);
//        System.out.println(company);

        EmployeeDaoImpl empD = cont.getBean("empD", EmployeeDaoImpl.class);

        List<Employee> em = empD.findAll();

        for(int i = 0; i< em.size(); i++){
            System.out.println(em.get(i));
        }
    }


}
