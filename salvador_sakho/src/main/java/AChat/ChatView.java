package AChat;/**
 * Created by User on 09.01.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatView extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStageUser1) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStageUser1.setTitle("User1");
        primaryStageUser1.setScene( new Scene(root,300,275));
        primaryStageUser1.show();
    }
}
