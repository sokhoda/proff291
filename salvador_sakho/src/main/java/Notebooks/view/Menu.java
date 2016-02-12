package Notebooks.view;

import Notebooks.dao.NotebookDao;
import Notebooks.dao.NotebookHibernateDaoImpl;
import Notebooks.domain.Notebook;
import Notebooks.service.NotebookService;
import Notebooks.service.NotebookServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by User on 08.02.2016.
 */
public class Menu {

    public Menu(NotebookService noteService) {
        this.noteService = noteService;
    }

    public void showAllNotebooks() {
        for (Notebook note : noteService.getAllNotes()) {
            System.out.println(note);
        }

    }

    public void addNotebook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Put the model of notebook");
        String model = scan.next();
        long keyLong = (long) keysGenerator();
        Notebook note = new Notebook(keyLong, model);
        noteService.addNewNote(note);
    }

    public int keysGenerator() {
        int key = (int) (Math.random() * 43);
        return key;
    }

    SessionFactory sessionFactory = getSessionFactory();
    NotebookDao notebookDao = new NotebookHibernateDaoImpl(sessionFactory);
    NotebookService noteService = new NotebookServiceImpl(notebookDao);
    Scanner scan = new Scanner(System.in);
    int choice = scan.nextInt();
    Menu menu = new Menu(noteService);

    @FXML
    private Button showAllBtn;
    @FXML
    private Button AddNewBtn;
    @FXML
    private TextArea inputField;
    @FXML
    private TextArea outPutField;

    @FXML
    private void showAll() {
        String notes = noteService.getAllNotes().toString();
        outPutField.setText(notes);
    }


    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("Hibernate/hibernateNotes.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}
