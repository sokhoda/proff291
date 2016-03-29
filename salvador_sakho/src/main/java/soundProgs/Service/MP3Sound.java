package soundProgs.Service;

/**
 * Created by ${BIM} on 23.02.2016.
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;


public class MP3Sound {

    private MediaPlayer mediaPlayer;
    private int state;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public MP3Sound() {
    }

    public int playSound(String sound) {
        File f = new File(sound).getAbsoluteFile();
        String path = "file:///" + f.getAbsolutePath().replace("\\", "/");
        Media hit = new Media(path);
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        setState(1);
        return getState();
    }

    public int stop() {
        mediaPlayer.stop();
        setState(0);
        return getState();
    }

    public int pause() {
        if (getState() == 1) {
            mediaPlayer.pause();
            setState(0);
            return getState();

        }
        mediaPlayer.setStartTime(mediaPlayer.getCurrentTime());
        mediaPlayer.play();
        setState(1);
        return getState();
    }

    public void movement(Slider slider){
        slider.setMin(0.0);
        slider.setValue(0.0);
        slider.setMax(mediaPlayer.getTotalDuration().toSeconds());
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
    }

    public void rewind(Slider slider){
        slider.setMin(0.0);
        slider.setValue(0.0);
        slider.setMax(mediaPlayer.getTotalDuration().toSeconds());
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration current) {
                slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mediaPlayer.seek(Duration.seconds( slider.getValue()));
                    }
                });
            }
        });
    }


}

