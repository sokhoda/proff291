package hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Pavel on 06.02.2016.
 */
public class HiberConnecion {

    private static Logger log = Logger.getLogger(HiberConnecion.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        System.out.println("enter name");
        String name = sc.nextLine();
        System.out.println("enter pass");
        String pass = sc.nextLine();
        UserDAO userDAO = new UserDAOImpl(factory);
        List<Object[]> users = userDAO.findExceptOne(name, pass);
        for(int i = 0; i < users.size(); i++){
            System.out.println(Arrays.toString(users.get(i)));
        }

        int i = 0;
        int step = 3;
        do {
            System.out.println("   ---------    " + userDAO.findUsersByPortion(i, i + step));
            i+= 3;
        } while (userDAO.findUsersByPortion(i, i + step).size() != 0);
    }
}
