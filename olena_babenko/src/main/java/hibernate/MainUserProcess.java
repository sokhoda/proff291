package hibernate;

import hibernate.dao.UserProcessDAO;
import hibernate.dao.UserProcessImplDAO;
import hibernate.service.UserProcessService;
import hibernate.service.UserProcessServiceImpl;
import hibernate.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class MainUserProcess {
    public static void main(String[] args) {
        // !! IMPORTANT !! this is only example of structure
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserProcessDAO userDao = new UserProcessImplDAO(sessionFactory);
        UserProcessService UserProcessService = new UserProcessServiceImpl(userDao);

        System.out.println("==============================\n");
        //int id = 4;

        List<Object[]> users = (List) UserProcessService.getAllUsers();
        System.out.println(Arrays.toString(users.get(0)));
        //System.out.println(userDao.findAll().get(id).getName()+", "+userDao.findAll().get(id).getPassword());

        System.out.println("==============================\n");
    }
}
