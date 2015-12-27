package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonAction extends Application {
    Text text;

    public ButtonAction() {
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Четвертый пример");
        stage.setScene(this.createScene());
        stage.show();
    }

    public Scene createScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20.0D);
        grid.setVgap(10.0D);
        grid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Button btn = new Button("Button 1");
        this.text = new Text();
        this.text.setText("Пустой текст");
        btn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                ButtonAction.this.text.setFill(Color.MAROON);
                ButtonAction.this.text.setText(ButtonAction.this.text.getText() + "\nWai! Wai! Somebody pressed on me");
            }
        });
        grid.add(btn, 0, 0);
        grid.add(this.text, 1, 0);
        Scene scene = new Scene(grid, 600.0D, 400.0D);
        return scene;
    }
}
