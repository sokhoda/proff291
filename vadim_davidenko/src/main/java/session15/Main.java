package session15;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

/**
 * Created by Вадим on 20.02.2016.
 */
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("session15/context-db.xml");

        SessionFactory sf = cont.getBean("sf", SessionFactory.class);
        TestDao testDao = cont.getBean("testDao", TestDao.class);

        List<Employee> list = testDao.findAll();
        System.out.println(list.toString());
    }


}
