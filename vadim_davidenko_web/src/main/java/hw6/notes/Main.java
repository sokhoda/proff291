package hw6.notes;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import hw6.notes.view.Menu;
import org.hibernate.SessionFactory;

/**
 * Created by Вадим on 07.02.2016.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        NotebookService notebookService = new NotebookServiceImpl(notebookDao);

        Menu menu = new Menu(notebookService);
        menu.main();
    }

}
