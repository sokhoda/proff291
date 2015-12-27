package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by elenabugercuk on 26.12.15.
 */
public class GFM extends Application {



    public static FM current = new FM();

    public GFM() {
    }

    public static void main(String[] args) {
        int disks = current.getlHistory().size();
        System.out.println("Обнаружено " + disks + " дисков");
        launch(args);
    }

    public void start(Stage arg0) throws Exception {
        GFM manager = new GFM();
        manager.draw();
    }

    public void draw() throws Exception {
        Font bold = new Font("TIMES_NEW_ROMAN", 13.0D);
        Stage window = new Stage();
        window.setTitle("File Managment (c) tri___ton");
        Group out = new Group();
        TextArea panelLeft = new TextArea();
        panelLeft.setLayoutX(10.0D);
        panelLeft.setLayoutY(100.0D);
        panelLeft.setMaxHeight(450.0D);
        panelLeft.setMaxWidth(380.0D);
        panelLeft.setMinHeight(450.0D);
        panelLeft.setMinWidth(380.0D);
        panelLeft.setEditable(false);
        panelLeft.setFont(bold);
        ObservableList categories = FXCollections.observableArrayList(new String[]{"Бытовая Техника", "Посуда", "Хозтовары"});
        ListView leftList = new ListView(categories);
        leftList.setLayoutX(10.0D);
        leftList.setLayoutY(100.0D);
        leftList.setEditable(false);
        leftList.setMaxHeight(450.0D);
        leftList.setMaxWidth(380.0D);
        leftList.setMinHeight(450.0D);
        leftList.setMinWidth(380.0D);
        TextArea panelRight = new TextArea();
        panelRight.setLayoutX(420.0D);
        panelRight.setLayoutY(100.0D);
        panelRight.setMaxHeight(450.0D);
        panelRight.setMaxWidth(380.0D);
        panelRight.setMinHeight(450.0D);
        panelRight.setMinWidth(380.0D);
        panelRight.setEditable(false);
        Button lBack = new Button("back");
        lBack.setLayoutX(10.0D);
        lBack.setLayoutY(25.0D);
        Button lForward = new Button("forward");
        lForward.setLayoutX(327.0D);
        lForward.setLayoutY(25.0D);
        Button rBack = new Button("back");
        rBack.setLayoutX(420.0D);
        rBack.setLayoutY(25.0D);
        Button rForward = new Button("forward");
        rForward.setLayoutX(737.0D);
        rForward.setLayoutY(25.0D);
        Button lUp = new Button("up");
        lUp.setLayoutX(175.0D);
        lUp.setLayoutY(25.0D);
        Button rUp = new Button("up");
        rUp.setLayoutX(595.0D);
        rUp.setLayoutY(25.0D);
        Button create = new Button("create");
        create.setLayoutX(10.0D);
        create.setLayoutY(560.0D);
        Button rename = new Button("rename");
        rename.setLayoutX(86.0D);
        rename.setLayoutY(560.0D);
        Button copy = new Button("copy");
        copy.setLayoutX(170.0D);
        copy.setLayoutY(560.0D);
        Button move = new Button("move");
        move.setLayoutX(238.0D);
        move.setLayoutY(560.0D);
        Button prop = new Button("properties");
        prop.setLayoutX(312.0D);
        prop.setLayoutY(560.0D);
        ComboBox wayLeft = new ComboBox();
        wayLeft.setLayoutX(10.0D);
        wayLeft.setLayoutY(60.0D);
        wayLeft.setMinWidth(380.0D);
        wayLeft.setEditable(false);
        wayLeft.getItems().addAll(current.getlHistory());
        ComboBox wayRight = new ComboBox();
        wayRight.setLayoutX(420.0D);
        wayRight.setLayoutY(60.0D);
        wayRight.setMinWidth(380.0D);
        wayRight.setEditable(false);
        wayRight.getItems().addAll(current.getrHistory());
        out.getChildren().add(leftList);
        out.getChildren().add(panelRight);
        out.getChildren().add(wayLeft);
        out.getChildren().add(wayRight);
        out.getChildren().add(lBack);
        out.getChildren().add(lForward);
        out.getChildren().add(rBack);
        out.getChildren().add(rForward);
        out.getChildren().add(create);
        out.getChildren().add(rename);
        out.getChildren().add(copy);
        out.getChildren().add(move);
        out.getChildren().add(prop);
        out.getChildren().add(lUp);
        out.getChildren().add(rUp);
        File lDir = new File(current.lFile());
        File[] lFileList = lDir.listFiles();
        int size = lFileList.length;

        int i;
        for(i = 0; i < size; ++i) {
            String rDir = "" + lFileList[i];
            leftList.setAccessibleText(rDir);
        }

        new File(current.rFile());
        File[] rFileList = lDir.listFiles();
        size = rFileList.length;

        for(i = 0; i < size; ++i) {
            String look = "";
            String temp = "" + rFileList[i];
            if(!temp.startsWith("/.")) {
                if(lFileList[i].isDirectory()) {
                    look = "(DIR)";
                }

                panelRight.appendText(look + rFileList[i] + "\n");
            }
        }

        panelLeft.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                String choice = "" + event.getTarget();
                System.out.println(choice);
            }
        });
        copy.setOnAction(new EventHandler() {
            public void handle(Event event) {
                Stage cWindow = new Stage();
                cWindow.setTitle("copy window (c) tri___ton");
                Group cout = new Group();
                Scene look = new Scene(cout, 210.0D, 400.0D);
                cWindow.setScene(look);
                cWindow.show();
            }
        });
        Scene var29 = new Scene(out, 810.0D, 600.0D);
        window.setScene(var29);
        window.show();
    }
}
