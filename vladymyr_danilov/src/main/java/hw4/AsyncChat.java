package hw4;

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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AsyncChat extends Application implements Runnable {
    @FXML
    private TextField IPField;
    @FXML
    private TextField clientPortField;
    @FXML
    private TextField serverPortField;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextArea messageTextArea;
    @FXML
    private Button connectButton;


    private String title;
    private String ip;
    private int sendPort;
    private int listenPort;
    private StringBuffer chatText;
    private ServerSocketChannel serverSocket;
    private SocketChannel socketChannel;
    private boolean isConnected;
    private boolean isAccepted;

    public AsyncChat() {
        this(null);
    }

    public AsyncChat(String title) {
        this.title = title;
        chatText = new StringBuffer();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Chat.fxml"));
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void run() {
        try {
            serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(listenPort));
            System.out.println(serverSocket.toString());
        } catch (IOException e) {

            e.printStackTrace();
        }
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, sendPort));
            System.out.println(socketChannel.toString());
        } catch (IOException e) {
            try {
                socketChannel = serverSocket.accept();
                System.out.println(socketChannel.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        connectButton.setDisable(true);

        while (true) {
            int buffSize = 100;
            ByteBuffer bufferRead = ByteBuffer.allocate(buffSize);
            try {
                bufferRead.clear();
                socketChannel.read(bufferRead);
                bufferRead.flip();
                chatText.append(new String(bufferRead.array()).substring(0, bufferRead.limit()));
            } catch (IOException e) {
                try {
                    socketChannel = serverSocket.accept();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }


    }

    public void connectTo() throws IOException {
        if ( !IPField.getText().isEmpty() &&
                !clientPortField.getText().isEmpty() &&
                !serverPortField.getText().isEmpty() ) {
            ip = IPField.getText();
            sendPort = Integer.parseInt(clientPortField.getText());
            listenPort = Integer.parseInt(serverPortField.getText());
            System.out.println("All param");
        } else {
            chatText.append("Invalid input parameters!");
            return;
        }

        new Thread(this).start();
    }

    public void sendMessage() throws IOException {
        if ( !messageTextArea.getText().isEmpty() ) {
            String msg = messageTextArea.getText();
            ByteBuffer bufferWright = ByteBuffer.allocate(msg.getBytes().length);
            bufferWright.put(msg.getBytes());
            bufferWright.flip();
            socketChannel.write(bufferWright);
            messageTextArea.clear();
            bufferWright.flip();
            chatText.append(msg);
//            showText();
        }
    }
    private String showText(StringBuffer buffer) {
        return buffer.toString();
    }


    public void disconnectTo() throws IOException {
        if (isConnected == true && isAccepted) {
            socketChannel.close();
        }
    }
}
