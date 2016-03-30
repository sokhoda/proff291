package soundProgs.View;

/**
 * Created by ${BIM} on 19.02.2016.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;

public class SoundListnerMain extends Application {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        launch(args);
    }

    @Override
    public void start(Stage primaryStageUser1) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/soundListnerView.fxml"));
            primaryStageUser1.setTitle("Listner");
            primaryStageUser1.setScene(new Scene(root, 1187, 656));
            primaryStageUser1.show();
    }

}
