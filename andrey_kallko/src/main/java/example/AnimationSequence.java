package example;/**
 * Created by tri___ton on 09.01.16.
 */

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationSequence extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    Stage stage = new Stage();
        Group group = new Group();
        Image first = new Image("http://hq-oboi.ru/photo/kotik_kak_pushistyy_komochek_1920x1200.jpg", 100.0, 100.0, true, true);
        ImageView firstImage = new ImageView();
        firstImage.setImage(first);


        Image second = new Image("http://hq-wallpapers.ru/wallpapers/2/hq-wallpapers_ru_animals_8040_1280x1024.jpg", 100.0, 100.0, true, true);
        ImageView secondImage = new ImageView();
        secondImage.setImage(second);

        secondImage.setLayoutX(150);
        secondImage.setLayoutY(150);


        group.getChildren().add(firstImage);
        group.getChildren().add(secondImage);


        Scene scene = new Scene(group, 300, 300);
        stage.setScene(scene);
        stage.show();


        ScaleTransition ft = new ScaleTransition(Duration.millis(1000));
        ft.setByX(3.0);
        ft.setByY(1.0);
        ft.setNode(firstImage);



        ScaleTransition st = new ScaleTransition(Duration.millis(3000));
        st.setNode(secondImage);
        st.setByX(1.5);
        st.setByY(1.5);

        RotateTransition proba = new RotateTransition(Duration.millis(2000));
        proba.setNode(secondImage);
        proba.setByAngle(360f);
        proba.setCycleCount(4);
        proba.setAutoReverse(false);


        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        SequentialTransition sequence = new SequentialTransition(ft, pause, st, proba);
        sequence.play();


    }
}
