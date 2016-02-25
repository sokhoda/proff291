package hw6.notes;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import hw6.notes.view.Menu;
import org.hibernate.SessionFactory;

/**
 * Created by Пк2 on 14.02.2016.
 */
public class Main {
    public static void main(String[] args){

        NotebookDao thisNoteDAO=new NotebookDaoImpl(new HibernateUtil().makeFactory());
        NotebookService thisNoteService=new NotebookServiceImpl(thisNoteDAO);
        Menu thisMenu=new Menu(thisNoteService);
        thisMenu.main();
    }
}
