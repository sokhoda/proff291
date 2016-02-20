package session15;

import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session15.dao.EmployeeDao;
import session15.dao.EmployeeDaoImpl;

import java.util.Locale;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public class DbMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext
                ("session15/context-db.xml");

        SessionFactory factory = cont.getBean("sf", SessionFactory.class);
//        Employee
        EmployeeDao  emplDao1 = cont.getBean("emplDao1", EmployeeDaoImpl.class);
        System.out.println(  emplDao1.findAll());
    }
}
