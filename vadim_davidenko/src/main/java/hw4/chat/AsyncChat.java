package hw4.chat;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Вадим on 05.01.2016.
 */
public class AsyncChat
        extends Application
        implements Runnable {
    @FXML
    private TextField fieldServerIP;
    @FXML
    private TextField fieldServerPort;
    @FXML
    private TextField fieldClientPort;
    @FXML
    private TextArea fieldUserMessage;
    @FXML
    private TextArea fieldChatMessage;
    @FXML
    private Button buttonConnect;

    private int clientPort;
    private int serverPort;
    private String serverIP;
    private String chatMessage;
    private final int bufferSize = 100;

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/chat.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("P2P Chat");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void run() {

    }

    public void onClickConnect() throws IOException {
        if (!fieldServerIP.getText().isEmpty() &&
            !fieldServerPort.getText().isEmpty() &&
            !fieldClientPort.getText().isEmpty()) {
            // read data from fields
            clientPort = Integer.parseInt(fieldClientPort.getText());
            serverPort = Integer.parseInt(fieldServerPort.getText());
            serverIP = fieldServerIP.getText();
            // disable fields and button
            fieldClientPort.setDisable(true);
            fieldServerPort.setDisable(true);
            fieldServerIP.setDisable(true);
            buttonConnect.setDisable(true);

            new Thread(this).start();


        }
    }

    public void onClickSend() {
        String userMessage = fieldUserMessage.getText();
        if (userMessage != null) {
            fieldUserMessage.clear();
            addMessage(userMessage);


        }
    }

    public synchronized void addMessage(String msg) {
        if (msg != null) {
            chatMessage += msg + "\n";


        }
    }

}
