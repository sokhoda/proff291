package hw5.auth;

import hw5.auth.*;
import hw5.auth.User;
import hw5.users.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class MainWindow extends Application {

    private ObservableList<User> usersList = FXCollections.observableArrayList();
    @FXML
    public TableView tableUsers;
    @FXML
    public TableColumn<User, Integer> idColumn;
    @FXML
    public TableColumn<User, String> nameColumn;
    @FXML
    public TableColumn<User, String> passwordColumn;
    @FXML
    public TableColumn<User, Date> dateColumn;
    @FXML
    public PasswordField password;
    @FXML
    public TextField userName;
    @FXML
    public Label message;

    final static String LOGIN_ERR_MSG = "Wrong name or password!";
    final static String NO_USERS_FOUND_MSG = "No users found!";

    @FXML
    private void initTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<User, Date>("date"));
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/login_form.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Authentication form");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickLogin() {
        if (!userName.getText().isEmpty() && !password.getText().isEmpty()) {
            message.setText("");

            UserJDBCManager userMan = new UserJDBCManager();
            User loggedUser = null;
            try {
                loggedUser = userMan.readByNamePass(userName.getText().trim(), password.getText().trim());
            } catch (SQLException e) {
                message.setText(LOGIN_ERR_MSG);
            }
            if (loggedUser != null) {
                try {
                    usersList = (ObservableList<User>)userMan.findAll();
                } catch (SQLException e) {
                    message.setText(NO_USERS_FOUND_MSG);
                }
                if (usersList != null && !usersList.isEmpty()) {
                    initTableView();
                    tableUsers.setItems(usersList);
                } else {
                    message.setText(NO_USERS_FOUND_MSG);
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }


}
