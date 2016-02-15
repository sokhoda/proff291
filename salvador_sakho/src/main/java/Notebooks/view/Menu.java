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

    public Menu() {

    }

/*    public void showAllNotebooks() {
        for (Notebook note : noteService.getAllNotes()) {
            System.out.println(note);
        }

    }*/
/*
    public void addNotebook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Put the model of notebook");
        String model = scan.next();
        long keyLong = (long) keysGenerator();
        Notebook note = new Notebook(keyLong, model);
        noteService.addNewNote(note);
    }*/

    public int keysGenerator() {
        int key = (int) (Math.random() * 43);
        return key;
    }

    SessionFactory sessionFactory = getSessionFactory();
    NotebookDao notebookDao = new NotebookHibernateDaoImpl(sessionFactory);
    NotebookService noteService = new NotebookServiceImpl(notebookDao);
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
        NotebookHibernateDaoImpl nhdi = new NotebookHibernateDaoImpl();
        nhdi.findAll();
    }

    @FXML
    private void addNote() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Put the name  of notebook");
        String model = scan.next();

        System.out.println("Put the price of notebook");
        String vendor = scan.next();

        System.out.println("Put the manufacture  of notebook");
        String manufacture = scan.next();

        System.out.println("Put the price of notebook");
        String price = scan.next();

        long keyLong = (long) keysGenerator();

        Notebook note = new Notebook(keyLong, model, vendor, manufacture, Long.parseLong(price));
        noteService.addNewNote(note);
    }

    @FXML
    private void deleteNotebookByID() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Put the id (number) of notebook which you want to delete");
        String id = scan.next();
        NotebookHibernateDaoImpl nhdi = new NotebookHibernateDaoImpl();
        Long idFordelete = Long.parseLong(id);
        nhdi.delete(idFordelete);
    }

    @FXML
    private void updatePrice() {
        NotebookHibernateDaoImpl nhdi = new NotebookHibernateDaoImpl();
        Scanner scan = new Scanner(System.in);

        System.out.println("Put the id (number) of notebook");
        String id = scan.next();

        System.out.println("Put the name of notebook");
        String model = scan.next();

        System.out.println("Put the price of notebook");
        String vendor = scan.next();

        System.out.println("Put the manufacture of notebook");
        String manufacture = scan.next();

        System.out.println("Put the price of notebook");
        String price = scan.next();


        Notebook notebook = new Notebook(Long.parseLong(id), model, vendor, manufacture, Long.parseLong(price));
        nhdi.update(notebook);
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
