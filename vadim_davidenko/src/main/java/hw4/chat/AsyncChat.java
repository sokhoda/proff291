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
public class AsyncChat extends Application implements Runnable {
    @FXML
    private TextField fieldTargetIP;
    @FXML
    private TextField fieldTargetPort;
    @FXML
    private TextField fieldSourcePort;
    @FXML
    private TextArea fieldUserMessage;
    @FXML
    private TextArea fieldChatMessage;
    @FXML
    private Button buttonConnect;

    private int sourcePort;
    private int targetPort;
    private String targetIP;
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
        if (!fieldTargetIP.getText().isEmpty() &&
            !fieldTargetPort.getText().isEmpty() &&
            !fieldSourcePort.getText().isEmpty()) {
            // read data from fields
            sourcePort = Integer.parseInt(fieldSourcePort.getText());
            targetPort = Integer.parseInt(fieldTargetPort.getText());
            targetIP = fieldTargetIP.getText();
            // disable fields and button
            fieldSourcePort.setDisable(true);
            fieldTargetPort.setDisable(true);
            fieldTargetIP.setDisable(true);
            buttonConnect.setDisable(true);

            new Thread(this).start();


        }
    }

    public void onClickSend() {
//        String msg = inputText.getText();
//        if (msg != null) {
//            chatServer.setText(msg);
//            outputText.appendText(chatServer.getText());
//            outputText.appendText("\n");
//            inputText.clear();
//        }
    }

}
