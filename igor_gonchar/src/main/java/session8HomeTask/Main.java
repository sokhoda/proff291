package session8HomeTask;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    public void loginButtonClick(){

    }

    public void registerButtonClick(){

    }
}
