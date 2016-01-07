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
public class AsyncChat
        extends Application
        implements Runnable {
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
    private String chatText = "";
    private final int BUFFER_SIZE = 100;
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;


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

            new Thread(this).start();
            fieldChatText.setText("Server started");
        }
    }

    public void onClickSend() throws IOException {
        if (!fieldUserMessage.getText().isEmpty()) {
            String userMessage = fieldUserMessage.getText();
            sendMessage(userMessage);
            fieldUserMessage.clear();
        }
    }

    @Override
    public void run() {
        process();
        while (true) {
            try {
                ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
                buf.flip();
                StringBuilder sb = new StringBuilder();
                while(socketChannel.read(buf) > 0) {
                    sb.append(new String(buf.array()));
                }
                updateChatText(sb.toString());
//                socketChannel.read(buf);
//                updateChatText(new String(buf.array()));
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
                    fieldChatText.setText(chatText);
                }
            });
        }
    }

    @Override
    public void stop() throws Exception {
        // super.stop();
        System.exit(0);
    }

    public void process() {
        try {
            // server initialization
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(ip, listenPort));
            chatText += "Server initialized\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // attempt to connect to server
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, serverPort));
            chatText += "Connected to server: " + socketChannel.getRemoteAddress().toString() + "\n";
        } catch (Exception ignored) {
            chatText += "Connection to server failed\n";
            try {
                // if server is not available then start listening for clients
                socketChannel = serverSocketChannel.accept();
                chatText += "Connected with client: " + socketChannel.getLocalAddress().toString()+ "\n";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(chatText);
    }

    public void sendMessage(String msg) {
        ByteBuffer buf = ByteBuffer.allocate(msg.length());
        buf.put(msg.getBytes());
        buf.flip();
        try {
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void updateChatText(String msg) {
        if (!msg.isEmpty()) {
            chatText += msg + "\n";
        }
    }

}
