package homework2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by Юлия on 12.01.2016.
 * Написать чат, в котором можно отправлять и принимать сообщения в любом порядке.
 * 1) Создать интерфейс для чата и описать все кнопки
 * 2) Запустить клиента
 * 3) Запустить сервер
 */
public class Chat extends Application {


    private SocketChannel socketChannel;
    private ServerSocketChannel serverSocketChannel;
    private Socket socket;
    private int inPort = 1001;
    private int outPort = 1002;
    private StringBuffer text = new StringBuffer();

    private String ipAddress;

    private ByteBuffer receivedBuffer = ByteBuffer.allocate(10);
    ByteBuffer sendBuffer = ByteBuffer.allocate(10);

    private BufferedWriter bufferedWriter;
    private ChatThread thread;
    private PrintWriter out;
    private Button connectButton;
    private TextArea serverText;


    private TextArea clientText;
    private TextField textPort;
    private TextField aftertextPort;
    private int minIpValue = 0;
    private int maxIpValue = 255;
    private int minPortValue = 0;
    private int maxPortValue = 40000;
    private TextField textIp;
    private boolean isConnected;
    private boolean isStart;
    private SocketChannel clientSocketChannel;

    public static void main(String[] args) {

        launch(args);
    }

    public void disconnect() {
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    public void connect() {
        clientText.setWrapText(true);
        serverText.setWrapText(true);

        if (!isStart) {
            final long PAUSE = 200;
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ignored) {
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                double scrollPos = serverText.getScrollTop();
                                serverText.setText(getText());
                                serverText.setScrollTop(scrollPos);
                                serverText.appendText("");
                            }
                        });
                    }
                }
            }).start();

        }
        if (!textIp.getText().isEmpty() && !textPort.getText().isEmpty() &&
                !aftertextPort.getText().isEmpty()) {

            int serverPort = Integer.parseInt(aftertextPort.getText());
            int clientPort = Integer.parseInt(textPort.getText());
            ipAddress = textIp.getText();
            textPort.setDisable(true);
            aftertextPort.setDisable(true);
            textIp.setDisable(true);

            // client attempts to connect to other chat server
            if (!isConnected) {
                connectToServer();
            }
            // server thread starts
            if (thread == null) {
                thread = new ChatThread(ipAddress, serverPort);
                thread.start();
            }
        }
    }

    public void connectToServer() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ipAddress, inPort));
            updateChatText("Chat client connected to remote server " + socketChannel.getRemoteAddress().toString() + "\n");
            isConnected = true;
        } catch (IOException e) {
            disconnect();
            updateChatText("Chat server waiting for connection from other chat...\n");
        }
    }

    public synchronized void updateChatText(String message) {
        if (!message.isEmpty()) {
            text.append(message);
        }
    }

    public String getText() {
        if (text != null) {
            return text.toString();
        }
        return "";
    }


    public void send(SocketChannel socketCh, String message) {
        if (socketCh==null && message == null) {
            sendBuffer.clear();
            sendBuffer.put(message.getBytes());
            sendBuffer.flip();
            boolean state = true;

            try {
                while (sendBuffer.hasRemaining()) {
                    socketCh.write(sendBuffer);
                    if (false) {
                        serverText.appendText(message);
                    }
                }
                sendBuffer.flip();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }


    public void run() {
//        try {
//            socket = new Socket("127.0.0.1", 40000);
//
//            bufferedReader = new BufferedReader(new InputStreamReader(
//                    socket.getInputStream()));
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(
//                    socket.getOutputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//            thread = new Thread();
//            thread.start();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//
//        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        textIp = new TextField("127.0.0.1");
        textIp.setMaxHeight(100);
        textIp.setPromptText(ipAddress);


        textPort = new TextField();
        textPort.setMaxHeight(100);
        textPort.setPromptText("40000");
        //  GridPane.setConstraints(port,0,0);

//        GridPane.setConstraints(text1, 10, 0);
//        root.getChildren().addAll(text1);

//        TextField text2 = new TextField();
//        text2.setMaxWidth(6);
//        GridPane.setConstraints(text2, 0, 10);
//        root.getChildren().addAll(text2);

//        TextField enterText=new TextField();
//        enterText.setPromptText("Write a message");
//        GridPane.setConstraints(enterText,6,10);
//        root.getChildren().addAll(enterText);

        Button ipButton = new Button("ip");
//        GridPane.setConstraints(ip, 9, 0);
//        root.getChildren().add(ip);

        Button portButton = new Button("port");
//        GridPane.setConstraints(port, 0, 0);
//        root.getChildren().add(port);

        Button sendButton = new Button("send");
//        GridPane.setConstraints(send, 0, 30);
//        root.getChildren().add(send);


        sendButton.setOnAction(event -> {

            send(socketChannel != null ? socketChannel : clientSocketChannel, getClientText().getText());

            getClientText().clear();
        });

        connectButton = new Button("connect");

        connectButton.setOnAction(event -> {
            if (connectButton.getText().equals("Connect"))
                connect();
            else disconnect();
        });


        serverText = new TextArea();
        serverText.setMaxHeight(400);
        serverText.setMaxWidth(445);

        clientText = new TextArea();
        clientText.setMaxHeight(10);
        clientText.setMaxWidth(400);
        gridPane.add(portButton, 1, 0);

        gridPane.add(textPort, 2, 0);

        gridPane.add(ipButton, 3, 0);
        gridPane.add(textIp, 4, 0);
        gridPane.add(connectButton, 5, 0);

        gridPane.add(serverText, 1, 5, 5, 1);
        gridPane.add(clientText, 2, 10, 6, 1);
        // rot.add(send, 5, 2, 6, 1);
        gridPane.add(sendButton, 1, 10);

        //rot.add(text1, 1,4,5,6 );
//        VBox root1 = new VBox(text, message);
//        root1.setPrefSize(400, 400);
        Scene scene = new Scene(new Group(), 480, 350);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(gridPane);


        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public TextArea getClientText() {
        return clientText;
    }

    public void setClientText(TextArea clientText) {
        this.clientText = clientText;
    }

}

