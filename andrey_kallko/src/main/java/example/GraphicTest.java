package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphicTest extends Application {
    public GraphicTest() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Несколько примеров");
        stage.setScene(this.createScene1());
        stage.show();
    }

    public Scene createScene1() {
        Group root = new Group();
        Label label1 = new Label("Comment 1");
        label1.setLayoutX(5.0D);
        label1.setLayoutY(14.0D);
        Button button1 = new Button("Button 1");
        button1.setLayoutX(80.0D);
        button1.setLayoutY(10.0D);
        Button button2 = new Button("Button 2");
        button2.setLayoutX(80.0D);
        button2.setLayoutY(50.0D);
        button2.setMaxWidth(100.0D);
        TextField text = new TextField("abc");
        text.setLayoutX(20.0D);
        text.setLayoutY(80.0D);
        text.setMinWidth(80.0D);
        text.setEditable(true);
        root.getChildren().add(label1);
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(text);
        Scene scene = new Scene(root, 800.0D, 600.0D);
        return scene;
    }

    public Scene createScene2() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_RIGHT);
        grid.setHgap(20.0D);
        grid.setVgap(10.0D);
        grid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        button3.setMinWidth(200.0D);
        grid.add(button1, 0, 0);
        grid.add(button2, 5, 3);
        grid.add(button3, 1, 0);
        grid.add(button4, 1, 1);
        grid.add(button5, 2, 4);
        Scene scene = new Scene(grid, 600.0D, 400.0D);
        return scene;
    }

    public Scene createScene3() {
        HBox hBox = new HBox(30.0D);
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        btn1.setStyle("-fx-background-color:maroon;-fx-color:white;");
        hBox.setStyle("-fx-border:1px solid #ed1c24");
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(btn1);
        hBox.getChildren().add(btn2);
        hBox.getChildren().add(btn3);
        hBox.getChildren().add(btn4);
        Scene scene = new Scene(hBox, 600.0D, 400.0D);
        return scene;
    }

    public Scene createScene4() {
        VBox vBox = new VBox(20.0D);
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().add(btn1);
        vBox.getChildren().add(btn2);
        vBox.getChildren().add(btn3);
        vBox.getChildren().add(btn4);
        Scene scene = new Scene(vBox, 600.0D, 400.0D);
        return scene;
    }
}
