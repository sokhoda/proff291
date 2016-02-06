package session8HomeTask;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by i.gonchar on 12/29/2015.
 */
public class ConfirmBox {

    static boolean answer;

    public static boolean display (String title, String message){
        Stage popUpWindow = new Stage();

        popUpWindow.initModality(Modality.APPLICATION_MODAL); //blocks User interaction with other windows
        popUpWindow.setTitle(title);
        popUpWindow.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        // create 2 buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            popUpWindow.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            popUpWindow.close();
        });

        HBox layout = new HBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        popUpWindow.setScene(scene);
        popUpWindow.showAndWait();

        return answer;
    }

}
