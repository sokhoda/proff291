package hw2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Pavel on 28.12.2015.
 */
public class AsyncChat extends Application{

    private SocketChannel socketChannel;
    private ServerSocketChannel serverSocketChannel;
    private String targetIP;
    private int targetPort;
    private int inputPort;
    private ByteBuffer buffer;
    private final int maxMessageSize = 250;

    @FXML
    private Button buttonConnect;
    @FXML
    private Button buttonSend;
    @FXML
    private TextField fieldTargetIP;
    @FXML
    private TextField fieldTargetPort;
    @FXML
    private TextField fieldInputPort;
    @FXML
    private TextArea textHistory;
    @FXML
    private TextArea textMessage;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/main.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Message me softly");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onClickConnect() throws IOException {
        buttonConnect.setDisable(true);
        fieldInputPort.setDisable(true);
        fieldTargetIP.setDisable(true);
        fieldTargetPort.setDisable(true);
        buffer = ByteBuffer.allocate(maxMessageSize);
        targetIP = fieldTargetIP.getText();
        targetPort = Integer.parseInt(fieldTargetPort.getText());
        inputPort = Integer.parseInt(fieldInputPort.getText());
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(inputPort));
        buttonSend.setDisable(false);
        textMessage.setDisable(false);
        textHistory.setDisable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        socketChannel = serverSocketChannel.accept();
                        buffer.clear();
                        socketChannel.read(buffer);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                textHistory.appendText("some guy >>" + new String(buffer.array()) + "\n");
                            }
                        });
                        //buffer.clear();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        textMessage.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > maxMessageSize) {
                    textMessage.setText(oldValue);
                }
            }
        });
    }

    public void onClickSend() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(targetIP, targetPort));
        buffer.clear();
        buffer.put(textMessage.getText().getBytes());
        buffer.flip();
        if (buffer.hasRemaining()) {
            socketChannel.write(buffer);
            textHistory.appendText(String.format("you >> ") + textMessage.getText() + "\n");
        }
        textMessage.setText("");
    }
}
