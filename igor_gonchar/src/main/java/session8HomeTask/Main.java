package session8HomeTask;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Statement;

/**
 * Created by Home on 31.01.2016.
 */
public class Main extends Application {
    @FXML
    private TextField loginLogin;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Label label;
    @FXML
    private Button loginButton;
    @FXML
    private TextField registerLogin;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private PasswordField registerRepassword;
    @FXML
    private Button registerButton;
    @FXML
    private TextArea textArea;
    @FXML
    private Button emptyBase;
    @FXML
    private Button showUsers;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Registration base");

        Parent root = FXMLLoader.load(getClass().getResource("/session8HomeTask/registerForm.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void loginButtonClick() {
        String login = loginLogin.getText();
        String password = loginPassword.getText();

        OperatorBase base = new OperatorBase();
        boolean logVal = loginValidation(login, password);
        if (logVal) {
            boolean authRes = base.userAuthorization(login, password);
            if (authRes) {
                label.setText("User was Authorized");
            } else {
                label.setText("There is no such user");
            }
        } else {
            label.setText("Enter correct data");
        }
    }

    public void registerButtonClick() {
        String login = registerLogin.getText();
        String pasword = registerPassword.getText();
        String rePasword = registerRepassword.getText();
        boolean passResult = passwordCheck(pasword, rePasword);
        boolean logResult = loginCheck(login);

        if (passResult && logResult) {
            OperatorBase base = new OperatorBase();
            StringBuilder sb = base.addUser(login, pasword);
            if (sb == null) {
                label.setText("Such user already exists");
            } else {
                textArea.setText(sb.toString());
            }
        } else {
            label.setText("Enter correct data");
        }

    }

    public void emptyBaseClicked(){
       boolean answer = ConfirmBox.display("Confirm pop-up", "Are you sure to empty DB?");
        if (answer){
            OperatorBase base = new OperatorBase();
            base.emptyBase();
            label.setText("All data was deleted from DB");
        }
    }

    public void showUsersClicked(){
        OperatorBase base = new OperatorBase();
        StringBuilder sb = base.showUsers();
        if (sb == null || sb.toString().equals("")) {
            label.setText("Base is empty");
        } else {
            textArea.setText(sb.toString());
        }
    }

    private boolean passwordCheck(String pasword, String rePasword) {
        if (!pasword.isEmpty() && pasword.equals(rePasword)) {
            return true;
        }
        return false;
    }

    private boolean loginCheck(String login) {
        if (!login.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean loginValidation(String login, String password) {
        if (!login.isEmpty() && !password.isEmpty()) {
            return true;
        }
        return false;
    }
}
