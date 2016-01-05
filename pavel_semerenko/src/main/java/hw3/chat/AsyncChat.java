package hw3.chat;

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
public class AsyncChat extends Application implements Runnable{

    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private String targetIP;
    private int targetPort;
    private int inputPort;
    private ByteBuffer bufferIN;
    private ByteBuffer bufferOUT;
    private final int bufferSize = 15;

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
    private String tempMessage = "";
    private boolean keep_running = true;

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

    @Override
    public void stop() throws Exception {
        System.exit(0);
    }

    public void onClickConnect() throws IOException {
        buttonConnect.setDisable(true);
        fieldInputPort.setDisable(true);
        fieldTargetIP.setDisable(true);
        fieldTargetPort.setDisable(true);
        bufferIN = ByteBuffer.allocate(bufferSize);
        bufferOUT = ByteBuffer.allocate(bufferSize);
        targetIP = fieldTargetIP.getText();
        targetPort = Integer.parseInt(fieldTargetPort.getText());
        inputPort = Integer.parseInt(fieldInputPort.getText());
        buttonSend.setDisable(false);
        textMessage.setDisable(false);
        textHistory.setDisable(false);

        new Thread(this).start();
    }

    public void onClickSend() throws IOException {
        int currPosition = 0;
        String message = textMessage.getText();
        send("some guy >> ");
        while(currPosition < message.length()){
            send(message.substring(currPosition, Integer.min(currPosition + bufferSize, message.length())));
            currPosition += bufferSize;
        }
        send("\n");
        textHistory.appendText(String.format("you >> ") + textMessage.getText() + "\n");
        textMessage.setText("");
    }

    private void send(String substring) throws IOException {
        bufferOUT.clear();
        bufferOUT.put(substring.getBytes());
        bufferOUT.flip();

        ByteBuffer bf = ByteBuffer.allocate(bufferSize);
        bf.put(substring.getBytes());
        bf.flip();
        socketChannel.write(bf);
    }

    @Override
    public void run() {
        reconnect();
        while (keep_running) {
            try {
                bufferIN = ByteBuffer.allocate(bufferSize);
                socketChannel.read(bufferIN);
                addAndGetMessage(new String(bufferIN.array()));
            } catch (IOException e) {
                try {
                    socketChannel = serverSocketChannel.accept();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    textHistory.appendText(addAndGetMessage(null));
                }
            });
        }
    }

    private void reconnect() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(inputPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(targetIP, targetPort));
        } catch (Exception e) {
            try {
                socketChannel = serverSocketChannel.accept();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    synchronized private String addAndGetMessage(String s) {
        String prevMessage;
        if(s != null) {
            tempMessage += s;
            return tempMessage;
        } else {
            prevMessage = tempMessage;
            tempMessage = "";
            return prevMessage;
        }
    }
}
