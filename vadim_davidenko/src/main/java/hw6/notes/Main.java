package hw6.notes;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Created by Вадим on 10.02.2016.
 */
public class Main {
    private static boolean isCreated = false;
    private static NotebookService noteService;

    public static NotebookService getInstance() {
        if (!isCreated) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
            noteService = new NotebookServiceImpl(noteDao);
            isCreated = true;
        }
        return noteService;
    }
}
