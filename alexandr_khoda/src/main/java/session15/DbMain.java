package session15;

import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session15.dao.EmployeeDao;
import session15.dao.EmployeeDaoImpl;

import java.io.IOException;
import java.util.List;
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
        EmployeeDao  emplDao1 = cont.getBean("emplDao", EmployeeDao.class);
//        System.out.println(emplDao1.findAll());
//        System.out.println(emplDao1.findAllUnemployed());
        List list = emplDao1.findAllDept(100L);
        printList(list);
    }

    private static  void printList(List<Object[]> list){
            if (list.size() == 0){
                System.out.println("List is empty");
                return;
            }
            for (Object[] obj : list) {
                for (Object ob : obj) {
                    System.out.println(ob);
                }
            }
    }
}
