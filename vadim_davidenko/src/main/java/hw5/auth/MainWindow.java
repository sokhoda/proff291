package hw5.auth;

import hw5.auth.*;
import hw5.auth.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class MainWindow extends Application {
    public PasswordField password;
    public TextField userName;
    public Label message;
    public Button registration;
    public TableView tableUsers;
    public TableColumn colId;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public TableColumn colDate;

    final static String LOGIN_ERR_MSG = "Wrong login or password!";


    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/login_form.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Registration form");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickLogin() {


    }

    public static void main(String[] args) throws SQLException {
        launch(args);

//        UserJDBCManager userMan = new UserJDBCManager();
//        User user = userMan.readByNamePass("vadim2", "12345");
//        System.out.println("\n" + user);

    }


}
