package javaFX.fx001_first_steps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Юра on 17.01.2016.
 */
public class MainAlertBoxes extends Application {
    Stage mainStage;
    Button btnClick;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        mainStage.setTitle("this is sparta");

        btnClick = new Button("Click me");
        StackPane layoutStackPane = new StackPane();
        layoutStackPane.getChildren().add(btnClick);
        Scene scene = new Scene(layoutStackPane,200,200);
        mainStage.setScene(scene);
        mainStage.show();

    }
}
class AlertBox{
    public static void Display(){

    };


}
