package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyGraphic extends Application {
    public MyGraphic() {
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void draw() throws Exception {
        Stage basic = new Stage();
        basic.setTitle("Upper text");
        Label tx = new Label("advice");
        tx.setLayoutX(0.0D);
        tx.setLayoutY(0.0D);
        TextField tF = new TextField("Vvedite chislo");
        HBox wind = new HBox(80.0D);
        wind.setAlignment(Pos.TOP_LEFT);
        Button btn1 = new Button("TEST");
        Button btn2 = new Button("Small Test");
        wind.getChildren().add(tF);
        wind.getChildren().add(tx);
        wind.getChildren().add(btn1);
        wind.getChildren().add(btn2);
        wind.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Scene sc = new Scene(wind, 800.0D, 100.0D);
        basic.setScene(sc);
        basic.show();
    }

    public void start(Stage arg0) throws Exception {
        MyGraphic go = new MyGraphic();
        go.draw();
    }
}
