package session4.ChatFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Администратор on 16.01.2016.
 */
public class AsyncChat extends Application implements Runnable {
    private static TextField textField;
    private static TextArea textArea;
    private ByteBuffer buf = ByteBuffer.allocate(100);
    private SocketChannel socketChannel = null;
    private HaveChat haveChat;
    boolean isConnectedToServer = false;
    private static TextField ipText;
    private static TextField portClientText;

    public static void main(String[] args) throws IOException {
        launch(args);
    }


    public void connectToServer() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ipText.getText(), Integer.parseInt(portClientText.getText())));
            isConnectedToServer = true;
        } catch (IOException e) {

        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Server");

        textField = new TextField();
        textField.setPadding(new Insets(10, 210, 2, 1));

        Button sendButton = new Button("Send");
        sendButton.setTextAlignment(TextAlignment.RIGHT);
        sendButton.setFont(new Font("MV Boli", 14));
        sendButton.setMinSize(90, 30);

        //горизонталь
        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, sendButton);
        hBox.setMargin(textField, new Insets(0, 4, 4, 4));
        hBox.setMargin(sendButton, new Insets(0, 4, 4, 4));

        //горизонталь для подключения
        Label ipLabel = new Label("IP");
        Label portServer = new Label("Server");
        Label portLClient = new Label("Client");

        ipText = new TextField("127.0.0.1");
        TextField portText = new TextField("30000");
        portClientText = new TextField("30001");
        Button connectionButton = new Button("Connect");

        HBox connectionBox = new HBox();
        connectionBox.getChildren().addAll(ipLabel, ipText, portServer, portText, portLClient, portClientText, connectionButton);
        connectionBox.setMargin(ipLabel, new Insets(7, 4, 12, 4));
        connectionBox.setMargin(ipText, new Insets(4, 4, 12, 0));
        connectionBox.setMargin(portServer, new Insets(7, 4, 12, 12));
        connectionBox.setMargin(portLClient, new Insets(7, 4, 12, 12));
        connectionBox.setMargin(portClientText, new Insets(4, 4, 12, 0));
        connectionBox.setMargin(portText, new Insets(4, 4, 12, 0));
        connectionBox.setMargin(connectionButton, new Insets(4, 4, 12, 15));
        ipText.setMaxSize(70, 5);
        portText.setMaxSize(70, 5);
        portClientText.setMaxSize(70, 5);
        connectionButton.setMinSize(90, 5);
        //вертикаль
        textArea = new TextArea();
        textArea.setFocusTraversable(false);
        textArea.setEditable(false);
        Label writeMes = new Label("Wrire Message:");
        writeMes.setFont(new Font("MV Boli", 13));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(connectionBox, textArea, writeMes, hBox);
        vBox.setMargin(writeMes, new Insets(5, 0, 0, 5));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);
        stage.setScene(new Scene(stackPane, 500, 350));

        connectionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (haveChat == null) {
                    haveChat = new HaveChat(ipText.getText(), Integer.parseInt(portText.getText()));
                    haveChat.start();
                }
                if (!isConnectedToServer) {
                    connectToServer();
                }
            }
        });

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    run();//writeMessage();
                    textField.clear();
                } catch (Exception e) {
                    //  e.printStackTrace();
                }
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 25, 10, 25));
        grid.add(stackPane, 20, 10);
        Scene scene = new Scene(grid, 500, 320);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void run() {
        // public void writeMessage() throws IOException {
        buf.clear();
        buf.put(textField.getText().getBytes());
        buf.flip();
        try {
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }
            String read = new String(buf.array()).substring(0, socketChannel.read(buf));
            textArea.appendText(read);
        } catch (IOException e) {
        }

        //  }
    }

    //=========================================================
    private class HaveChat extends Thread {
        private ServerSocketChannel serverSocketChannel;
        private SocketChannel socketChannel;
        private String ip;
        private int port;
        private ByteBuffer bufA = ByteBuffer.allocate(100);

        public HaveChat(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        @Override
        public void run() {
            try {
                serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
                socketChannel = serverSocketChannel.accept();
            } catch (IOException e) {
            }

            while (true) {
                bufA.clear();
                try {

                    while (bufA.hasRemaining()) {
                        socketChannel.write(bufA);
                    }

                    bufA.flip();
                    String read = new String(bufA.array()).substring(0, socketChannel.read(bufA));
                    textArea.appendText(textField.getText() + "\n");
                    textArea.appendText(read + "\n");


                } catch (Exception e) {
                }
            }
        }

    }
}
