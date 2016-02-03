package session8HomeTask;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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
                System.out.println("User was Authorized");
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
