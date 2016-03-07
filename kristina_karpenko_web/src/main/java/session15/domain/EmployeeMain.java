package session15.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session15.dao.EmployeeDao;


import java.util.Locale;

/**
 * Created by Администратор on 21.02.2016.
 */
public class EmployeeMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session15/context-bd.xml");


        EmployeeDao employeeDao = context.getBean("dao", EmployeeDao.class);

       Employee allEmployee = employeeDao.findAllEmployee();
        System.out.println(allEmployee);
    }
    }

