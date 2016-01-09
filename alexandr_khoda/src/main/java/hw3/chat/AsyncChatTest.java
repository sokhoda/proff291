package hw3.chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import scala.App;

import java.io.IOException;

/**
 * Created by s_okhoda on 04.01.2016.
 */
public class AsyncChatTest extends Application{
//    public static void main(String[] args) throws IOException{
////        AsyncChat client1 = new AsyncChat();
//
//        AsyncChat.launch(AsyncChat.class, "client1");
//        AsyncChat.launch(AsyncChat.class, "client2");
////        client1.runApp(AsyncChat.class);
////        Application app1 = client1.getClass().newInstance();
////        Stage stage1 = new Stage();
////        app1.start(stage1);
//
////        AsyncChat client2 = new AsyncChat("Client2");
////        AsyncChat.launch(client2.getClass(), args);
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AsyncChat client1 = new AsyncChat("client1");
        Stage stage1 = new Stage();
        client1.showGUI(stage1, false);

        new Thread(client1).start();

//        Platform.runLater(client1);

        AsyncChat client2 = new AsyncChat("client2");
        Stage stage2 = new Stage();
        client2.showGUI(stage2, true);
//        Platform.runLater(client2);

       new Thread(client2).start();
//        while(true){
//            System.out.println("\t\t MAIN THREAD");
//        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
