package hw6;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
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
    HibernateUtil util = new HibernateUtil();
    SessionFactory sessionFactory = util.getSessionFactory();
    NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
    NotebookService notebookService = new NotebookServiceImpl(notebookDao);
}


