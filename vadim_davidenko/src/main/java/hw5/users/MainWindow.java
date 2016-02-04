package hw5.users;

import hw5.*;
import javafx.application.Application;
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
import java.util.Date;
import java.util.List;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class MainWindow extends Application {

    public PasswordField password;
    public TextField userName;
    public Label message;
    public TextArea tableUsers;
    public DatePicker regDate;

    final static String REG_SUCCESS_MSG = "New user registered successfully";
    final static String REG_ERR_MSG = "Such user is already registered!";
    final static String NO_USERS_FOUND_MSG = "No users found!";

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/reg_form.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Registration form");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickRegistration() {
        if (!userName.getText().isEmpty() && !password.getText().isEmpty() &&
                !regDate.getEditor().getText().isEmpty()) {
            message.setText("");
            Date date = null;
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            try {
                date = formatter.parse(regDate.getEditor().getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            UserJDBCManager userMan = new UserJDBCManager();
            User newUser = new User(userName.getText().trim(), password.getText().trim(), date);
            int result = 0;
            try {
                result = userMan.create(newUser);
            } catch (SQLException e) {
                message.setText(REG_ERR_MSG);
            }
            if (result == 1) {
                message.setText(REG_SUCCESS_MSG);
            }
        }
    }

    public void onClickShowList() {
        message.setText("");
        tableUsers.setText("");
        UserJDBCManager userMan = new UserJDBCManager();
        List<User> list = null;
        try {
            list = userMan.findAll();
        } catch (SQLException e) {
            message.setText(NO_USERS_FOUND_MSG);
        }
        if (list != null && !list.isEmpty()) {
            for (User user : list) {
                String row = String.format("%-10s%-30s%-30s%-30s",
                        String.valueOf(user.getId()), user.getName(),
                        user.getPassword(),String.valueOf(user.getDate()));
                tableUsers.appendText(row + "\n");
            }
        } else {
            message.setText(NO_USERS_FOUND_MSG);
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
    }


}
