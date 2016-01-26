package example;

/**
 * Created by elenabugercuk on 08.01.16.
 */


        import java.util.ArrayList;

        import javafx.animation.AnimationTimer;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.scene.text.Font;
        import javafx.stage.Stage;

public class GraphDelay extends Application {
    // массив знакомест
    ArrayList<Label> aLabels = new ArrayList<Label>();
    // число знакомест
    final private int digitCount = 5; // цифр будет + 1
    // ограничение процесса
    final private int maxCount = 12345;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Example");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        for(int i = 0; i <= digitCount; i++){
            aLabels.add(new Label("X"));
            aLabels.get(i).setFont(new Font("Arial", 30));
            aLabels.get(i).setStyle("-fx-padding: 5;"
                    + "-fx-border-color: rgb(49, 89, 23);"
                    + "-fx-border-radius: 5;");
            hbox.getChildren().add(aLabels.get(i));
        }
        // кнопка, запускающая процесс
        Button button = new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                at.start();
            }
        });

        vbox.getChildren().add(hbox);
        vbox.getChildren().add(button);

        primaryStage.setScene(new Scene(vbox, 55 * (digitCount + 1), 100));
        primaryStage.show();
    }

    // заготовка для процесса
    private int counter = 0;

    private void longProcess(){
        int digit;
        for(int i = 0; i <= this.maxCount; i++){
            for(int j = 0; j <= digitCount; j++){
                digit = (int) (i % (Math.pow(10.0, (double)(j + 1))));
                digit = (int) (digit / (Math.pow(10.0, (double)j)));
                this.aLabels.get(digitCount - j).setText(Integer.toString(digit));
            }
        }
    }


    private void longProcess2(){
        int digit;
        if(counter > maxCount){
            at.stop();
            return;
        }
        // операции для отображения процесса
        for(int j = 0; j <= digitCount; j++){
            digit = (int) (counter % (Math.pow(10.0, (double)(j + 1))));
            digit = (int) (digit / (Math.pow(10.0, (double)j)));
            this.aLabels.get(digitCount - j).setText(Integer.toString(digit));
        }
        // *******
        // собственно процесс, подлежащий отображению:
        counter++;
        // *******
    }

    protected AnimationTimer at = new AnimationTimer(){
        @Override
        public void handle(long now) {
            longProcess2();
        }
    };
}