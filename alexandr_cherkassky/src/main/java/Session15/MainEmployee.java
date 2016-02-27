package Session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class MainEmployee {
    public static void main(String [] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context=new ClassPathXmlApplicationContext("Session15/context-db.xml");

        EmployeeDaoImpl emplDaoImpl= context.getBean("EmployeeDaoImpl1", EmployeeDaoImpl.class);
        System.out.println(emplDaoImpl.findAll());



    }
}
