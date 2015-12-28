package hw2;

import javafx.application.Application;
import javafx.application.Platform;
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
    private boolean connected;
    private ByteBuffer buffer;

    @FXML
    private Button buttonOpenPort;
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
        buttonSend.setDisable(false);
    }

    private void connect(String targetIP, int targetPort) throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(targetIP, targetPort));
        startChat();
    }

    private void startChat() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        buffer = ByteBuffer.allocate(50);
                        if(socketChannel != null) {
                            buffer.clear();
                            socketChannel.read(buffer);
                        }
                        if(buffer.hasRemaining()) {
                            textHistory.appendText("\nanother guy >> " + new String(buffer.array()));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void prepareForInputConnection(int inputPort) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(inputPort));
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!connected){
                    try {
                        socketChannel = serverSocketChannel.accept();
                        startChat();
                        ByteBuffer buffer = ByteBuffer.allocate(50);
                        buffer.put("Hi! you have connected to me".getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);

                        connected = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @FXML
    public void onClickOpenPort() throws IOException {
        int port = 0;
        try {
            port = Integer.parseInt(fieldInputPort.getText());
        } catch (Exception e) {
            System.out.println("Incorrect number in field \"input port\"");
        }
        if(port > 65535 || port < 1){
            System.out.println("Input port number is our of range");
        }
        prepareForInputConnection(port);
        buttonOpenPort.setDisable(true);
        buttonConnect.setDisable(true);
        textHistory.appendText("port " + port + " was opened");
    }

    public void onClickConnect() throws IOException {
        int port = Integer.parseInt(fieldTargetPort.getText());
        connect(fieldTargetIP.getText(), port);
        buttonOpenPort.setDisable(true);
        buttonConnect.setDisable(true);
        textHistory.appendText("you was connected to " + fieldTargetIP.getText() + " by port " + port);
    }

    public void onClickSend() throws IOException {
        buffer.clear();
        buffer.put(textMessage.getText().getBytes());
        buffer.flip();
        if (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        textHistory.appendText("\n" + String.format("\n you >> ") + textMessage.getText());
        textMessage.setText("");
    }
}
