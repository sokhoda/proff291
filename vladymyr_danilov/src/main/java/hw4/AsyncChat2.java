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

public class AsyncChat2 extends Application {
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
    private SocketChannel listenChanel;
    private boolean isConnected;
    private boolean isAccepted;

    public AsyncChat2() {
        chatText = new StringBuffer();
    }

    public AsyncChat2(String title) {
        this.title = title;

    }

    public void connectTo() throws IOException {
//        boolean isAccepted = false;

        if ( !IPField.getText().isEmpty() &&
                !clientPortField.getText().isEmpty() &&
                !serverPortField.getText().isEmpty() ) {
            ip = IPField.getText();
            sendPort = Integer.parseInt(clientPortField.getText());
            listenPort = Integer.parseInt(serverPortField.getText());
            System.out.println("all param");
        } else {
            chatText.append("Invalid input parameters!");
            System.out.println("Invalid param");
            return;
        }

//        for ( int i = 0; (socketChannel == null && listenChanel == null); i++ ) {
////            if ( socketChannel == null ) {
////                if ( isAccepted == false ) {
//                    if ( listenChanel == null ) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                serverSocket = ServerSocketChannel.open();
//                                serverSocket.socket().bind(new InetSocketAddress(ip, listenPort));
//                                System.out.println(serverSocket.socket().toString());
//                                listenChanel = serverSocket.accept();
//                                System.out.println(serverSocket.socket().isBound() + "_servSock");
//                                isAccepted = true;
//
//                            } catch ( IOException e ) {
//                                e.printStackTrace();
//                                System.out.println(serverSocket.socket().isBound() + "_servSock");
//                            }
//                        }
//                    }).start();
//                }
//                try {
//                    if (socketChannel == null ) {
//                        socketChannel = SocketChannel.open(new InetSocketAddress(ip, sendPort));
//
//                    }
//                    System.out.println(socketChannel.socket().toString());
//
//                } catch ( IOException e ) {
//                    e.printStackTrace();
//                }
//
////            }
//        }

        if ( socketChannel == null ) {
            if ( isAccepted == false ) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            serverSocket = ServerSocketChannel.open();
                            serverSocket.socket().bind(new InetSocketAddress(ip, listenPort));
                            System.out.println(serverSocket.socket().toString());
                            listenChanel = serverSocket.accept();
                            listenChanel.configureBlocking(false);
                            System.out.println(serverSocket.socket().isBound() + "_servSock");
                            isAccepted = true;

                        } catch ( IOException e ) {
                            e.printStackTrace();
                            System.out.println(serverSocket.socket().isBound() + "_servSock");
                        }
                    }
                }).start();
            }
            try {
//                Thread.sleep(1000);
                socketChannel = SocketChannel.open(new InetSocketAddress(ip, sendPort));
                System.out.println(socketChannel.socket().toString());

            } catch ( IOException e ) {
                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            }

        }
        if ( socketChannel != null && listenChanel != null ) {
            connectButton.setText("Disconnect");
            System.out.println("connected to server");
        } else {
            System.out.println("can not connect to server");
        }
    }

//    public void dosconnectTo() {
//        if ( isConnected == true && isAccepted ) {
//            listenChanel.close();
//            socketChannel.close();
//        }
//    }

    public void sendMessage() throws IOException {
        System.out.println("send message");
        if ( !messageTextArea.getText().isEmpty() ) {
            String msg = messageTextArea.getText();
            ByteBuffer buffer = ByteBuffer.allocate(msg.getBytes().length);
            buffer.put(msg.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            messageTextArea.clear();
            buffer.flip();
            chatText.append(msg);
            showText();
        }
    }

    private void showText() {
        System.out.println("show text");

        chatTextArea.appendText(chatText.toString());

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
}
