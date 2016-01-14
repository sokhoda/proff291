package hw3.chat;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Вадим on 12.01.2016.
 */
public class AsyncChatTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        AsyncChat chat1 = new AsyncChat("P2P Chat 1");
//        Stage stage1 = new Stage();
//        chat1.start(stage1);

//        AsyncChat chat2 = new AsyncChat("P2P Chat 2");
//        Stage stage2 = new Stage();
//        chat2.start(stage2);

        AsyncChat chat1 = new AsyncChat("P2P Chat 1");
        Stage stage1 = new Stage();
        chat1.createStage(stage1);
        new Thread(chat1).start();

        AsyncChat chat2 = new AsyncChat("P2P Chat 2");
        Stage stage2 = new Stage();
        chat2.createStage(stage2);
        new Thread(chat2).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}