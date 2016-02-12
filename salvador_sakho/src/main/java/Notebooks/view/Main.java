package Notebooks.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by User on 08.02.2016.
 */
public class Main extends Application {

    //    public static void main(String[] args) {
//        // !! IMPORTANT !! this is only example of structure
//        SessionFactory sessionFactory = getSessionFactory();
//        NotebookDao notebookDao = new NotebookHibernateDaoImpl(sessionFactory);
//        NotebookService clientService = new NotebookServiceImpl(notebookDao);
//        Scanner scan = new Scanner(System.in);
//        int choice = scan.nextInt();
//        Menu menu = new Menu(clientService);
//
//                menu.showAllNotebooks();
//                menu.addNotebook();
//    }
//    SessionFactory sessionFactory = getSessionFactory();
//    NotebookDao notebookDao = new NotebookHibernateDaoImpl(sessionFactory);
//    NotebookService noteService = new NotebookServiceImpl(notebookDao);
//    Scanner scan = new Scanner(System.in);
//    int choice = scan.nextInt();
//    Menu menu = new Menu(noteService);
//
//    @FXML
//    private TextArea inputField;
//    @FXML
//    private TextArea outPutField;
//
//    @FXML
//    private void showAll() {
//       String notes= noteService.getAllNotes().toString();
//        outPutField.setText(notes);
//    }


    public static void main(String[] args) {
        launch(args);
    }

//    private static SessionFactory getSessionFactory() {
//        Locale.setDefault(Locale.ENGLISH);
//        Configuration cfg = new Configuration().configure("Hibernate/hibernateNotes.cfg.xml");
//        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//        sb.applySettings(cfg.getProperties());
//        StandardServiceRegistry standardServiceRegistry = sb.build();
//        return cfg.buildSessionFactory(standardServiceRegistry);
//    }

    @Override
    public void start(Stage primaryStageUser) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/forHibernate.fxml"));
        primaryStageUser.setTitle("User");
        primaryStageUser.setScene(new Scene(root, 282, 580));
        primaryStageUser.show();
    }
}
