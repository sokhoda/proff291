package hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

import hibernate.Region;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            //получаем существующий объект
            Region region = (Region) session.get(Region.class, 1L);//создаем объект и передаем класс, который хотим получить.
            //объект класса Region с идентификатором 1
            log.info(region);

            //добавляем новый регион
            //создаем и фиксируем транзакции
            Region ua = new Region("UkraineRegion");
            //создаем транзакцию
            session.beginTransaction();
            session.save(ua);
            //фиксируем изменения в транзакции
            session.getTransaction().commit();

            //апдейтим уже существующую запись
            ua.setName("UkraineChanged");
            session.beginTransaction();
            session.update(ua);
            session.getTransaction().commit();

            //удаление объекта
            ua.setId(1L);
            session.beginTransaction();
            session.delete(ua);
            session.getTransaction().commit();

            log.info("Connection established");
            log.info(session);
        } catch (HibernateException e) {
            log.error("Open session failed", e);

            //откат транзакции в случае её неудачного выполнения
            if(session!=null){
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}

