package session16;

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
        ApplicationContext cont = new ClassPathXmlApplicationContext("session16/context-db.xml");
        EmployeeDaoImpl empD = cont.getBean("empD", EmployeeDaoImpl.class);

        List<Employee> em = empD.findAll();

        for(int i = 0; i< em.size(); i++){
            System.out.println(em.get(i));
        }

        List<Employee> yu = empD.findAll(30);

        for(int i = 0; i< yu.size(); i++){
            System.out.println(yu.get(i));
        }

        List<Employee> we = empD.findAllWithout();

        for(int i = 0; i< we.size(); i++){
            System.out.println(we.get(i));
        }
    }


}
