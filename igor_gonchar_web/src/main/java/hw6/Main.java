package hw6;

import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session8HomeTask.HiberConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.gonchar on 2/10/2016.
 */


public class Main {
}


   /* HibernateUtil util = new HibernateUtil();
    Logger log = HibernateUtil.getLog();
    SessionFactory factory = util.getSessionFactory();
    Session session = null;
try{
        session = factory.openSession();
        log.info(session);
        log.info("Everything is OK");
        }finally {
        util.closeSessionAndFactory(factory, session);
        }*/