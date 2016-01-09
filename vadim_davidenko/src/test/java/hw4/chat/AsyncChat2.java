package hw4.chat;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by Вадим on 05.01.2016.
 */
public class AsyncChat2 extends Application {
    @FXML
    private TextField fieldIP;
    @FXML
    private TextField fieldClientPort;
    @FXML
    private TextField fieldListenPort;
    @FXML
    private TextArea fieldUserMessage;
    @FXML
    private TextArea fieldChatText;

    private int clientPort;
    private String ip;
    public static String chatText = "";
    private SocketChannel socketChannel;
    private ChatThread2 chatThread;
    public static boolean isConnected = false;
    private boolean isRefreshStarted;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/chat2.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("P2P Chat 2");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        disconnect();
        System.exit(0);
    }

    public void onClickConnect() {
        fieldUserMessage.setWrapText(true);
        fieldChatText.setWrapText(true);

        if (!isRefreshStarted) {
            // Start chat text area refreshing thread
            final long PAUSE = 200; // in ms
            isRefreshStarted = true;

            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(PAUSE);
                        } catch (InterruptedException ignored) {
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                double scrollPos = fieldChatText.getScrollTop();
                                fieldChatText.setText(getChatText());
                                fieldChatText.setScrollTop(scrollPos);
                                fieldChatText.appendText("");   // just to move cursor to the bottom of text
                            }
                        });
                    }
                }
            }).start();
        }

        if (!fieldIP.getText().isEmpty() && !fieldClientPort.getText().isEmpty() &&
                !fieldListenPort.getText().isEmpty()) {
            // Get connection parameters
            int listenPort = Integer.parseInt(fieldListenPort.getText());
            clientPort = Integer.parseInt(fieldClientPort.getText());
            ip = fieldIP.getText();
            fieldListenPort.setDisable(true);
            fieldClientPort.setDisable(true);
            fieldIP.setDisable(true);

            // server starts
            if (chatThread == null) {
                chatThread = new ChatThread2(ip, listenPort);
                chatThread.start();
            }
            // client attempts to connect to other chat server
            if (!isConnected) {
                isConnected = connectToServer();
            }
        }
    }

    public void onClickSend() throws Exception {
        if (!fieldUserMessage.getText().isEmpty()) {
            String msg = fieldUserMessage.getText();
            if (msg.trim().equalsIgnoreCase("exit")) {
                stop();
            }
            if (isConnected) {
                sendMessage(msg);
                fieldUserMessage.clear();
                updateChatText("<< This user >>\n" + msg + "\n");
            }
        }
    }

    public boolean connectToServer() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, clientPort));
            updateChatText("Chat client connected to server " + socketChannel.getRemoteAddress().toString() + "\n");
            return true;
        } catch (IOException e) {
            disconnect();
            return false;
        }
    }

    public void sendMessage(String msg) {
        String sendMsg = "<< Other user >>\n" + msg + "\n";
        ByteBuffer buf = ByteBuffer.allocate(sendMsg.getBytes().length);
        buf.put(sendMsg.getBytes());
        buf.flip();
        try {
            socketChannel.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void updateChatText(String msg) {
        if (!msg.isEmpty()) {
            chatText += msg;
        }
    }

    public static String getChatText() {
        return chatText;
    }

    public void disconnect() {
        try {
            if (socketChannel != null) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}