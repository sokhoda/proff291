package hw3.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Solyk on 03.01.2016.
 */
public class AsyncChat extends Application {


    private TextField serverIPdAdress;
    private TextField serverPort;
    private TextField myPort;

    private TextArea messageWindow;
    private TextArea enterTextWindow;

    private Button connect;
    private Button send;

    private String tmpe = "";

    private SocketChannel socketChannel;
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannelServ;

    Thread client;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MyChat");
        stage.getIcons().add(new Image("23.gif"));
        stage.resizableProperty().set(false);
        stage.setScene(createScean());
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent arg0) {
                if (client != null) {
                    client.interrupt();
                }
                stage.close();

            }

        });
        stage.show();
    }

    private Scene createScean() {

        HBox first = new HBox();
        first.setPrefSize(400, 30);
        first.setAlignment(Pos.CENTER);

        HBox second = new HBox();
        second.setPrefSize(400, 200);
        second.setAlignment(Pos.CENTER);

        HBox third = new HBox();
        third.setPrefSize(400, 100);
        third.setAlignment(Pos.CENTER);

        serverIPdAdress = new TextField("127.0.0.1");
        serverPort = new TextField("2345");
        myPort = new TextField("4567");
        connect = new Button("Connect");

        connect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                process();

            }
        });

        messageWindow = new TextArea();
        messageWindow.setEditable(false);

        enterTextWindow = new TextArea();
        enterTextWindow.setEditable(true);
        enterTextWindow.setPrefSize(250, 100);

        send = new Button("Send");
        send.setPrefSize(100, 30);

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                setTmp(enterTextWindow.getText());
                sendMassage();

            }
        });

        first.getChildren().addAll(serverIPdAdress, serverPort, myPort, connect);
        second.getChildren().add(messageWindow);
        third.getChildren().addAll(enterTextWindow, send);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setBackground(new Background(
                new BackgroundImage(new Image("Chrysanthemum.jpg"), null, null, BackgroundPosition.CENTER,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true))));

        grid.addRow(0, first);
        grid.addRow(1, second);
        grid.addRow(2, third);

        Scene myScene = new Scene(grid, 500, 500);

        return myScene;
    }

    public void process() {

        if(client != null){

            client.interrupt();

        }

        client = new Thread() {

            @Override
            public void run() {

                try {

                    serverSocketChannel = ServerSocketChannel.open();
                    serverSocketChannel.socket().bind(new InetSocketAddress(getServerIPdAdress().getText(),
                            Integer.parseInt(getMyPort().getText())));

                } catch (NumberFormatException | IOException e) {
                    try {

                        serverSocketChannel.close();
                    } catch (IOException e1) {

                        e1.printStackTrace();
                    }


                }

                while (true) {

                    try {

                        socketChannelServ = serverSocketChannel.accept();

                    } catch (NotYetBoundException | IOException | NullPointerException e) {
                        try {

                            socketChannelServ.close();
                            serverSocketChannel.socket().close();
                            serverSocketChannel.close();

                            if (socketChannelServ.isConnected() == false) {
                                getMessageWindow().appendText("LostConnection!!!" + "\n");

                            }

                            break;

                        } catch (IOException | NullPointerException e1) {

                            e1.printStackTrace();
                        }

                    }
                    if (socketChannelServ != null) {

                        handlerMasseages();

                    } else if (socketChannelServ == null) {

                        break;
                    }

                }

            }

        };

        client.start();

    }

    public synchronized void sendMassage() {

        try {

            socketChannel = SocketChannel.open(
                    new InetSocketAddress(getServerIPdAdress().getText(), Integer.parseInt(getServerPort().getText())));

        } catch (NumberFormatException | IOException e1) {
            getMessageWindow().appendText("NoConnection!!!" + "\n");
            System.out.println("NoConnection!!!");
            return;
        }

        ByteBuffer bufferOut = ByteBuffer.allocate(50);

        getMessageWindow().appendText(new String(getTmp().getBytes()) + "\n");

        bufferOut.put(getTmp().getBytes());
        setTmp("");
        enterTextWindow.clear();
        bufferOut.flip();

        try {
            socketChannel.write(bufferOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferOut.flip();

        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized void handlerMasseages() {

        ByteBuffer bufferIn = ByteBuffer.allocate(50);

        try {
            socketChannelServ.read(bufferIn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bufferIn.flip();
        getMessageWindow().appendText("\t" + new String(bufferIn.array()) + "\n");
        bufferIn.clear();

        try {
            socketChannelServ.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public TextField getServerIPdAdress() {
        return serverIPdAdress;
    }

    public void setServerIPdAdress(TextField serverIPdAdress) {
        this.serverIPdAdress = serverIPdAdress;
    }

    public TextField getServerPort() {
        return serverPort;
    }

    public void setServerPort(TextField serverPort) {
        this.serverPort = serverPort;
    }

    public TextField getMyPort() {
        return myPort;
    }

    public void setMyPort(TextField myPort) {
        this.myPort = myPort;
    }

    public TextArea getMessageWindow() {
        return messageWindow;
    }

    public void setMessageWindow(TextArea messageWindow) {
        this.messageWindow = messageWindow;
    }

    public TextArea getEnterTextWindow() {
        return enterTextWindow;
    }

    public void setEnterTextWindow(TextArea enterTextWindow) {
        this.enterTextWindow = enterTextWindow;
    }

    public String getTmp() {
        return tmpe;
    }

    public void setTmp(String tmpe) {
        this.tmpe = tmpe;
    }

    public static void main(String[] args) {
//        try {
//            Desktop.getDesktop().open(new File("D:/chat4.jar"));
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
        launch();

    }

}
