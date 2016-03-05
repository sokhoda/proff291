package hw6.notes.service;

import hw6.notes.util.HibernateUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Solyk on 08.02.2016.
 */
public class Menu extends Application{

    private Text directoryHarvesting = new Text("Directory Harvesting");
    private Button directoryHarvestingButton;

    private Text directoryNotebooks = new Text("Directory Notebooks");
    private Button direcoryNotebooksButton;

    private Text directoryExpansion = new Text("Directory Expansion");
    private Button directoryExpansionButton;

    private Text mainText = new Text("Home Work 6");


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Notebook");
        primaryStage.setScene(crateScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Scene crateScene() {

        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox forth = new HBox();


        directoryHarvestingButton = new Button("Harvesting");
        directoryHarvestingButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new HibernateUtil().directoryHarvesting();
             }
        });
        directoryExpansionButton = new Button("Expansion");
        directoryExpansionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new HibernateUtil().directoryExpansion();
            }
        });
        direcoryNotebooksButton = new Button("Notebooks");
        direcoryNotebooksButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new HibernateUtil().directoryNotebooks();
            }
        });
        first.getChildren().add(mainText);
        first.setAlignment(Pos.CENTER);


        second.getChildren().add(0,directoryHarvestingButton);
        second.getChildren().add(1,directoryHarvesting);
        second.setAlignment(Pos.CENTER);

        third.getChildren().add(0,direcoryNotebooksButton);
        third.getChildren().add(1,directoryNotebooks);
        third.setAlignment(Pos.CENTER);

        forth.getChildren().add(0,directoryExpansionButton);
        forth.getChildren().add(1,directoryExpansion);
        forth.setAlignment(Pos.CENTER);


        GridPane gridPane = new GridPane();
        gridPane.add(first,0,0);
        gridPane.add(second,0,1);
        gridPane.add(third,0,2);
        gridPane.add(forth,0,3);

        Scene scene = new Scene(gridPane);


        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}
