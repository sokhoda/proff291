package session4HomeTask;

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
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by i.gonchar on 1/13/2016.
 */
public class ServerChatWindow extends Application {
    @FXML
    private TextField serverIpTextField;
    @FXML
    private TextArea generalMessageTextArea;
    @FXML
    private TextArea userMessageTextArea;
    @FXML
    private Button connectButton;

    private static StringBuilder generalTextAreaMessage = new StringBuilder();
    private boolean serverCreated = false;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Server Chat Window");

        Parent root = FXMLLoader.load(getClass().getResource("/session4HomeTask/serverChatWindow.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public void sendMessageButtonClicked() {

    }

    public void connectButtonClicked() throws Exception {
        if (!serverCreated) {
            Thread server = new Server();
            server.start();
            serverCreated = true;
        } else {
            updateGeneralText("Server has been already started");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
        }
    }

    public static void updateGeneralText(String message) {
        if (!message.isEmpty()) {
            generalTextAreaMessage.append(message + "\n");
        }
    }


    private class Server extends Thread {

        private String ip = "127.0.0.1";
        private int port = 3001;
        private ServerSocketChannel serverSocketChannel;
        private Selector selector;
        private ByteBuffer buffer = ByteBuffer.allocate(100);


        @Override
        public void run() {
            try {
                startServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void startServer() throws Exception {

            this.serverSocketChannel = ServerSocketChannel.open();
            this.selector = Selector.open();
            int ops = this.serverSocketChannel.validOps();

            this.serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.register(selector, ops, null);
            updateGeneralText("An echo server has been started\nWaiting for any client to connect");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());

            startProgress();

        }


        private void startProgress() throws Exception {
            while (serverSocketChannel.isOpen()) {
                int channels = this.selector.select();

                if (channels > 0) {
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();

                        if (key.isAcceptable()) {
                            accept();
                        }
                        if (key.isReadable()) {
                            read(key);
                        }
                        if (key.isWritable()) {
                            write(key);
                        }
                    }
                }
            }
        }

        private void accept() throws Exception {
            SocketChannel socketChannel = this.serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(this.selector, SelectionKey.OP_READ);
            updateGeneralText("Client has connected to server");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
        }

        private void read(SelectionKey key) throws Exception {
            SocketChannel channel = (SocketChannel) key.channel();
            int read = channel.read(buffer);
            byte[] bytes = new byte[read];

            buffer.flip();
            String message = new String(buffer.array()).substring(0, buffer.limit());
            updateGeneralText("Client message: " + message);
            generalMessageTextArea.setText(generalTextAreaMessage.toString());

            buffer.flip();
            channel.write(ByteBuffer.wrap(bytes));
            System.out.println("Sending message back to client");
            buffer.clear();

        }

        private void write(SelectionKey key) throws IOException {

        }
    }
}
