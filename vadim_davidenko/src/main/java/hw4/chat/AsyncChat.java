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
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 05.01.2016.
 */
public class AsyncChat extends Application {
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
    public static StringBuffer chatText = new StringBuffer();
    private SocketChannel socketChannel;
    private ChatThread chatThread;
    private boolean isConnectedToServer;
    private boolean isRefreshStarted;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/chat.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("P2P Chat 1");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

    public void refreshChatWindow() {
        final long PAUSE = 200; // in ms

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

    public void onClickConnect() {
        fieldUserMessage.setWrapText(true);
        fieldChatText.setWrapText(true);

        // Start chat text area refreshing thread (call once time)
        if (!isRefreshStarted) {
            refreshChatWindow();
            isRefreshStarted = true;
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

            // client attempts to connect to other chat server
            if (!isConnectedToServer) {
                connectToServer();
            }
            // server thread starts
            if (chatThread == null) {
                chatThread = new ChatThread(ip, listenPort);
                chatThread.start();
            }
        }
    }

    public void onClickSend() throws Exception {
        if (!fieldUserMessage.getText().isEmpty()) {
            String msg = fieldUserMessage.getText();
            if (msg.trim().equalsIgnoreCase("exit")) {
                disconnect();
                stop();
            }
            if (isConnectedToServer) {
                sendMessage(msg);
                fieldUserMessage.clear();
                updateChatText("<< This user >>\n" + msg + "\n");
            }
        }
    }

    public void connectToServer() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ip, clientPort));
            updateChatText("Chat client connected to remote server " + socketChannel.getRemoteAddress().toString() + "\n");
            isConnectedToServer = true;
        } catch (IOException e) {
            disconnect();
            updateChatText("Chat server waiting for connection from other chat...\n");
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
            disconnect();
        }
    }

    public static synchronized void updateChatText(String msg) {
        if (!msg.isEmpty()) {
            chatText.append(msg);
        }
    }

    public static String getChatText() {
        if (chatText != null){
            return chatText.toString();
        }
        return "";
    }

    public void disconnect() {
        try {
            if (socketChannel != null) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateChatText("Remote chat disconnected\n");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    private class ChatThread extends Thread {

        private ServerSocketChannel serverSocketChannel;
        private SocketChannel socketChannel;
        private String ip;
        private int port;

        public ChatThread(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        @Override
        public void run() {
            final int BUFFER_SIZE = 100;
            try {
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
                socketChannel = serverSocketChannel.accept();
                updateChatText("Client " + socketChannel.getLocalAddress().toString() +
                        " connected to this chat\n");
                if (!isConnectedToServer) {
                    connectToServer();
                }
                updateChatText("Chat started...\n");

            } catch (IOException e) {
                disconnect();
            }

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            while (true) {
                try {
                    buffer.clear();
                    socketChannel.read(buffer);
                    buffer.flip();
                    String msg = new String(buffer.array()).substring(0, buffer.limit());
                    if (!msg.isEmpty()) {
                        updateChatText(msg);
                    }
                } catch (IOException ignored) {
                    try {
                        disconnect();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
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
            updateChatText("Remote chat disconnected\n");
        }
    }

}
