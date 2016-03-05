package session15;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("session15/context-db.xml");
            
//        Phone phone1 = context.getBean("phone1", Phone.class);
//        Phone phone2 = context.getBean("phone2", Phone.class);
        SessionFactory factory = context.getBean("sf", SessionFactory.class);
        EmployeeDaoImpl employeeDao = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

        List<Employee> list = employeeDao.findAll();

        System.out.println(list.toString());


    }
}
