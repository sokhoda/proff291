package javaFX.fx001_first_steps;/**
 * Created by Юра on 16.01.2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button btn;
    Button btn2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("my first stage");
        btn = new Button();
//        btn.setText("first button");// classic way to set on listener
        btn2 = new Button("my button2");
        btn.setOnAction(this);
        btn2.setOnAction(e -> {
            System.out.println("Ive done it via lyambda expression");
            System.out.println("yo cover me");
        });
        StackPane layout = new StackPane();
//        layout.getChildren().add(btn);
        layout.getChildren().add(btn2);
        Scene myScene = new Scene(layout, 300, 250);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btn) {
            System.out.println("Wazzaaa!!!#@?>#");
        }
        if (event.getSource() == btn2) {
            System.out.println("You clicked butn 2");
        }
    }
}
