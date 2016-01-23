package ChatApp;/**
 * Created by lenchi on 12.01.16.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ChatWindow extends Application {
    private boolean isServer = true;//start as server with true value, then change to false value and start as client

    private ChatConnection connection = isServer ? createChatServer() : createChatClient();
    private TextArea chatArea;

    //chat window preview
    public Scene addChatWindowContent(boolean isServer, String ip, Integer port) {

        this.isServer = isServer;

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        //IP
        Label ipLabel = new Label("IP: ");
        GridPane.setConstraints(ipLabel, 0, 0);
        TextField ipField = new TextField(ip);
        ipField.setDisable(true);
        GridPane.setConstraints(ipField, 1, 0);

        //Port
        Label portLabel = new Label("Port: ");
        GridPane.setConstraints(portLabel, 2, 0);
        TextField portField = new TextField(port.toString());
        portField.setDisable(true);
        GridPane.setConstraints(portField, 3, 0);

        //Connect button
        Button connectButton = new Button("Connect");
        connectButton.setPrefSize(100, 20);
        GridPane.setConstraints(connectButton, 4, 0);

        //set Action for Connect button
        connectButton.setOnAction(e -> {
            try {
                connection.startConnection();
            } catch (Exception e1) {
                chatArea.appendText("Fail to connect\n");
            }
            connectButton.setDisable(true);
        });

        //chat messages area
        chatArea = new TextArea();
        chatArea.setPrefSize(300, 100);
        chatArea.editableProperty().setValue(false);
        GridPane.setConstraints(chatArea, 0, 1, 5, 1);

        //field for message to send
        TextField input = new TextField();
        input.setPromptText("Enter message...");
        GridPane.setConstraints(input, 0, 2, 4, 1);

        //send button
        Button sendButton = new Button("Send");
        sendButton.setPrefSize(100, 20);
        GridPane.setConstraints(sendButton, 4, 2);

        //set action for send button
        sendButton.setOnAction(event -> {
            String messageHead = Date.valueOf(LocalDate.now()).toString() + " " + Time.valueOf(LocalTime.now()).toString() + ": ";
            String message = isServer ? "Server: " : "Client: "; //msg will be started with this exprsn
            message = messageHead + message + input.getText();
            input.clear();

            chatArea.appendText(message + "\n");
            try {
                connection.send(message);
            } catch (Exception e) {
                chatArea.appendText("Failed to send\n");
            }
        });

        grid.getChildren().addAll(ipLabel, ipField, portLabel, portField, connectButton, chatArea, input, sendButton);
        Scene ChatWindow = new Scene(grid);

        return ChatWindow;
    }

    @Override
    public void start(Stage primaryStage) {
        String stageTitle = isServer ? "Server" : "Client";
        primaryStage.setScene(addChatWindowContent(isServer, "127.0.0.1", 5555));
        primaryStage.setTitle(stageTitle);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {//javafx method
        connection.closeConnection();
    }

    private ChatServer createChatServer() {
        return new ChatServer(5555, data -> {
            Platform.runLater(() -> {
                chatArea.appendText(data.toString() + "\n");
            });
        });
    }

    private ChatClient createChatClient() {
        return new ChatClient("127.0.0.1", 5555, data -> {
            Platform.runLater(() -> {
                chatArea.appendText(data.toString() + "\n");
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}


