package session15.domain.session15.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session15.domain.Company;
import web.domain.*;

import java.util.Locale;

/**
 * Created by Юлия on 20.02.2016.
 */
public class Main {
    public static void main(String [] args){
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont=new ClassPathXmlApplicationContext("session15/context-db.xml");
        // Phone phone=cont.getBean("phone1",Phone.class);
        //  Phone phone2=cont.getBean("phone2",Phone.class);
      //  Company company=cont.getBean("company", Company.class);

        EmployeeDao employeeDao=cont.getBean("web.dao",EmployeeDaoIml.class);
//        Ditector director =cont.getBean("director", Ditector.class);
//        Car car=cont.getBean("car", Car.class);
        System.out.println(employeeDao.findAllEmployee());
    //    System.out.println(employeeDao.findAllEmployeeByDepartment(10));

    }

}
