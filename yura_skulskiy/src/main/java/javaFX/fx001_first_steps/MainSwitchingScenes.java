package javaFX.fx001_first_steps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Юра on 17.01.2016.
 */
public class MainSwitchingScenes extends Application {
 Stage stage;
    Scene scene1;
    Scene scene2;
    Button btnSwitchScene2;
    Button btnSwitchBackScene1;
    Label label1;
    Label label2;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("primary stage");
        label1 = new Label("welcome to the first scene");
        label2 = new Label("welcome to the second scene");
        btnSwitchScene2 = new Button("SWITCH SCENE");
        btnSwitchBackScene1 = new Button("SWITCH SCENE");

        btnSwitchScene2.setOnAction(e->stage.setScene(scene2));
        btnSwitchBackScene1.setOnAction(e->stage.setScene(scene1));

        //layout1 - children are laid out in vertical position
        VBox verticalBoxLayout = new VBox(20);
        verticalBoxLayout.getChildren().addAll(label1,btnSwitchScene2);
//        scene1 = new Scene(verticalBoxLayout,300,200);

       //layout2
        StackPane stackPaneLayout = new StackPane();
        stackPaneLayout.getChildren().addAll(btnSwitchBackScene1);
        scene1 = new Scene(verticalBoxLayout,200,300);
        scene2 = new Scene(stackPaneLayout,600,300);
        stage.setScene(scene1);
        stage.show();
    }
}
