package session4;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Valeriy on 03.01.2016.
 */
public class hwASyncChat extends Application {

    // инициализируем константы
    public static final String windowTitle = "P2P Chat";
    public static final String IP = "127.0.0.1";
    public static final int tcpIn = 30000;
    public static final int tcpOut = 30001;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {

        // устанавливаем заголовок главного окна
        primaryStage.setTitle(windowTitle);

        // создаем контейнер компонентов главного окна
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);

        // создаем компоненты главного окна
        Label ipLabel = new Label("IP : ");
        ipLabel.setLayoutX(10);
        ipLabel.setLayoutY(10);

        TextField ipSetField = new TextField(IP);
        ipSetField.setLayoutX(30);
        ipSetField.setLayoutY(10);
        ipSetField.setMaxWidth(110);

        Label tcpOutLabel = new Label("TCP out : ");
        tcpOutLabel.setLayoutX(155);
        tcpOutLabel.setLayoutY(10);

        TextField tcpOutSetField = new TextField(String.valueOf(tcpOut));
        tcpOutSetField.setLayoutX(210);
        tcpOutSetField.setLayoutY(10);
        tcpOutSetField.setMaxWidth(50);

        Label tcpInLabel = new Label("TCP in : ");
        tcpInLabel.setLayoutX(275);
        tcpInLabel.setLayoutY(10);

        TextField tcpInSetField = new TextField(String.valueOf(tcpIn));
        tcpInSetField.setLayoutX(323);
        tcpInSetField.setLayoutY(10);
        tcpInSetField.setMaxWidth(50);

        Button connectButton = new Button("Connect !");
        connectButton.setLayoutX(390);
        connectButton.setLayoutY(10);
        connectButton.setMaxWidth(100);

        Label messageLabel = new Label("Messages : ");
        messageLabel.setLayoutX(10);
        messageLabel.setLayoutY(45);

        TextArea messageArea = new TextArea();
        messageArea.setLayoutX(10);
        messageArea.setLayoutY(65);
        messageArea.setMaxHeight(1500);
        messageArea.setMaxWidth(447);
        messageArea.setEditable(false);

        TextField sendTextField = new TextField();
        sendTextField.setLayoutX(10);
        sendTextField.setLayoutY(255);
        sendTextField.setMinWidth(360);

        Button sendButton = new Button("Send !");
        sendButton.setLayoutX(390);
        sendButton.setLayoutY(255);
        sendButton.setMinWidth(67);

        // размещаем компоненты главного окна в контейнер
        root.getChildren().add(ipLabel);
        root.getChildren().add(ipSetField);
        root.getChildren().add(tcpOutLabel);
        root.getChildren().add(tcpOutSetField);
        root.getChildren().add(tcpInLabel);
        root.getChildren().add(tcpInSetField);
        root.getChildren().add(connectButton);
        root.getChildren().add(messageLabel);
        root.getChildren().add(messageArea);
        root.getChildren().add(sendTextField);
        root.getChildren().add(sendButton);

        primaryStage.setScene(scene);

        // устанавливаем размеры главного окна и отображаем его
        primaryStage.setHeight(332);
        primaryStage.setWidth(483);
        primaryStage.setMaxHeight(332);
        primaryStage.setMaxWidth(483);
        primaryStage.setMinHeight(332);
        primaryStage.setMinWidth(483);
        primaryStage.show();
    }
}