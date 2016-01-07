package hw4.chat;

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
 * Created by Вадим on 05.01.2016.
 */
public class AsyncChat2 extends Application implements Runnable {
    @FXML
    private TextField fieldIP;
    @FXML
    private TextField fieldServerPort;
    @FXML
    private TextField fieldListenPort;
    @FXML
    private TextArea fieldUserMessage;
    @FXML
    private TextArea fieldChatText;
    @FXML
    private Button buttonConnect;

    private int listenPort;
    private int serverPort;
    private String ip;
    public static String chatText = "";
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private ChatThread2 chatThread;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/chat2.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("P2P Chat 2");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void run() {
        while (true) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    fieldChatText.setText(chatText);
                }
            });
        }
    }

    public void onClickConnect() throws IOException {
        if (!fieldIP.getText().isEmpty() &&
                !fieldServerPort.getText().isEmpty() &&
                !fieldListenPort.getText().isEmpty()) {

            listenPort = Integer.parseInt(fieldListenPort.getText());
            serverPort = Integer.parseInt(fieldServerPort.getText());
            ip = fieldIP.getText();
            fieldListenPort.setDisable(true);
            fieldServerPort.setDisable(true);
            fieldIP.setDisable(true);
            buttonConnect.setDisable(true);

            connection();
            fieldChatText.setText(chatText);
            chatThread = new ChatThread2(socketChannel);
            chatThread.start();
        }
    }

    public void onClickSend() throws IOException {
        if (!fieldUserMessage.getText().isEmpty()) {
            String msg = fieldUserMessage.getText();
            if (msg.trim().equalsIgnoreCase("exit")) {
                chatThread.interrupt();
                disconnect();
                System.exit(0);
            }
            msg = "[This user]:\n" + msg;
            sendMessage(msg);
            updateChatText(msg);
            fieldChatText.setText(chatText);
            fieldUserMessage.clear();
        }
    }

    public void connection() {
        try {
            // Chat attempts to connect to other chat as a client
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, serverPort));
            chatText = "Connected to server: " + socketChannel.getRemoteAddress().toString() + "\nChat started...\n";
        } catch (Exception ignored) {
            try {
                // If other chat is not available then chat starts as a server to listen for other chat
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(ip, listenPort));
                socketChannel = serverSocketChannel.accept();
                chatText = "Connected with client: " + socketChannel.getLocalAddress().toString()+ "\nChat started...\n";
            } catch (IOException e) {
                disconnect();
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String msg) {
        ByteBuffer buf = ByteBuffer.allocate(msg.length());
        buf.put(msg.getBytes());
        buf.flip();
        try {
            socketChannel.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void updateChatText(String msg) {
        if (!msg.isEmpty()) {
            chatText += msg + "\n";
        }
    }

    public void disconnect() {
        try{
            if(serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        try{
            if(socketChannel != null) {
                socketChannel.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}