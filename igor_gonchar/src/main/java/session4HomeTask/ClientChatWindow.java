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
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by i.gonchar on 1/12/2016.
 */
public class ClientChatWindow extends Application {
    @FXML
    private TextField serverIpTextField;
    @FXML
    private TextArea generalMessageTextArea;
    @FXML
    private TextArea userMessageTextArea;
    @FXML
    private Button connectButton;
    @FXML
    private TextField connectToPortTextField;

    private static StringBuilder generalTextAreaMessage = new StringBuilder();
    private String connectToIp;
    private int connectToPort;
    private boolean connectedToServer = false;
    ByteBuffer buffer = ByteBuffer.allocate(100);


    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Client Chat Window");

        Parent root = FXMLLoader.load(getClass().getResource("/session4HomeTask/clientChatWindow.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public void connectButtonClicked() throws Exception {
        boolean ipAndPortValidation = getIpAndPort();
        if (ipAndPortValidation) {
            updateGeneralText("We have connected to IP: " + this.connectToIp);
            updateGeneralText("We have connected to port: " + this.connectToPort);
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
            Thread client = new Client();
            client.start();
        }
    }


    public boolean getIpAndPort() {
        String connectToIp = serverIpTextField.getText();
        String connectToPortString = connectToPortTextField.getText();

        if (!connectToIp.isEmpty() && !connectToPortString.isEmpty()) {
            int connectToPort = Integer.parseInt(connectToPortString);
            this.connectToIp = connectToIp;
            this.connectToPort = connectToPort;
            return true;

        } else if (connectToIp.isEmpty() && connectToPortString.isEmpty()) {
            updateGeneralText("No Server IP and Server port are entered");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
            return false;
        } else if (connectToIp.isEmpty()) {
            updateGeneralText("No Server IP entered");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
            return false;
        } else {
            updateGeneralText("No Server port entered");
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
            return false;
        }
    }


    public String sendMessageButtonClicked() {
        if (userMessageTextArea.getText().isEmpty()) {
            return null;
        }

        String userText = userMessageTextArea.getText();
        updateGeneralText("You: " + userText);
        generalMessageTextArea.setText(generalTextAreaMessage.toString());
        userMessageTextArea.clear();

        return userText;
    }

    public static void updateGeneralText(String message) {
        if (!message.isEmpty()) {
            generalTextAreaMessage.append(message + "\n");
        }
    }


    private class Client extends Thread {
        /*private String ip = "127.0.0.1";
        private int port = 3001;*/
        private SocketChannel socketChannel;
        private Selector selector;
        private ByteBuffer buffer = ByteBuffer.allocate(100);
        private Scanner scanner;


        public void run() {
            try {
                startClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private void startClient() throws Exception {
            this.socketChannel = SocketChannel.open();
            this.selector = Selector.open();

            this.socketChannel.configureBlocking(false);
            this.socketChannel.connect(new InetSocketAddress(connectToIp, connectToPort));
            this.socketChannel.register(selector, SelectionKey.OP_CONNECT);

            scanner = new Scanner(System.in);
            startProcess();

        }

        private void startProcess() throws IOException {
            while (true) {
                int channels = this.selector.select();

                if (channels > 0) {
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove();

                        if (key.isConnectable()) {
                            connect(key);
                        }
                        if (key.isWritable()) {
                            write(key);
                        }
                        if (key.isReadable()) {
                            read(key);
                        }
                    }
                }
            }
        }

        private void connect(SelectionKey key) throws IOException {
            System.out.println("Client has connected to server");
            this.socketChannel.finishConnect();
            this.socketChannel.register(this.selector, SelectionKey.OP_WRITE);

            key.interestOps(SelectionKey.OP_WRITE);
        }

        private void write(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();

            // TO Do - to transfer this on GUI - button click
            String message = null;
            if (scanner.hasNext()) {
                message = scanner.next();
                buffer.clear();
                buffer.put(message.getBytes());
            }
            if (message != null) {
                updateGeneralText(message);
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
            key.interestOps(SelectionKey.OP_READ);


            /* String message = sendMessageButtonClicked();

            while (true) {

                if (message != null) {
                    buffer.clear();
                    buffer.put(message.getBytes());

                    buffer.flip();
                    channel.write(buffer);
                    buffer.clear();
                    key.interestOps(SelectionKey.OP_READ);
                    message = null;
                }

            }*/
        }


        private void read(SelectionKey key) throws IOException {
            String message = new String(buffer.array()).substring(0, buffer.limit());
            updateGeneralText("Server: " + message);
            generalMessageTextArea.setText(generalTextAreaMessage.toString());
            System.out.println("Server posted: " + message);
            buffer.clear();
            key.interestOps(SelectionKey.OP_WRITE);
        }
    }
}