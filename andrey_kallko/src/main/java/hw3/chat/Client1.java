package hw3.chat;

/**
 * Created by elenabugercuk on 03.01.16.
 */

import example.ButtonAction;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class Client1 extends Application {
    String tempMessage="";
    SocketChannel chanel;

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage arg0) throws Exception {
        Client1 manager = new Client1();
        manager.starter();
    }

    private void starter() throws IOException {
//        Way clientWay = new Way(30000+numberOfClients*2);
//        clientWay.start();


        Stage client = new Stage();

        client.setTitle("Открываю порт " + 30000);
        Group cGroup = new Group();
        Scene clientScene = new Scene(cGroup, 420, 370);

        Text ip = new Text();
        ip.setText("IP");
        ip.setLayoutX(10);
        ip.setLayoutY(33);


        TextField adresIP = new TextField();
        adresIP.setLayoutX(30);
        adresIP.setLayoutY(15);
        adresIP.setAlignment(Pos.BASELINE_RIGHT);
        adresIP.setEditable(true);


        Text port = new Text();
        port.setText("port");
        port.setLayoutX(220);
        port.setLayoutY(33);


        final TextField adresPort = new TextField();
        adresPort.setLayoutX(260);
        adresPort.setLayoutY(15);
        adresPort.setMaxWidth(70);
        adresPort.setAlignment(Pos.BASELINE_RIGHT);
        adresPort.setEditable(true);


        Button connect = new Button("Connect");
        connect.setLayoutX(340);
        connect.setLayoutY(15);


        Text chatTitle = new Text();
        chatTitle.setText("Сообщения:");
        chatTitle.setLayoutX(11);
        chatTitle.setLayoutY(65);

        final TextArea chat = new TextArea();
        chat.setLayoutX(10);
        chat.setLayoutY(70);
        chat.setMinHeight(250);
        chat.setMinWidth(400);
        chat.setMaxHeight(250);
        chat.setMaxWidth(400);
        chat.setEditable(false);
        //chat.setAlignment(Pos.BOTTOM_LEFT);


        final TextField message = new TextField();
        message.setLayoutX(10);
        message.setLayoutY(330);
        message.setMinWidth(340);
        message.setAlignment(Pos.BASELINE_RIGHT);
        message.setEditable(true);


        Button send = new Button("Send");
        send.setLayoutX(360);
        send.setLayoutY(330);

        send.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String temp = message.getText() + "\n";
                ByteBuffer buf = ByteBuffer.allocate(256);
                byte[] toPut = new byte[256];
                toPut=temp.getBytes();
                buf.put(toPut);
                buf.rewind();
                try {
                    chanel.write(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                chat.appendText(temp);
                message.setText("");
            }
        });


        connect.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Integer port = new Integer(adresPort.getText());
                try {
                    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
                    chanel=socketChannel;
                    chat.appendText("Connect succesfull \n");
                } catch (IOException e) {
                    chat.appendText("Error adress. Try another, please. \n");
                    e.printStackTrace();
                }
            }
        });


        cGroup.getChildren().add(ip);
        cGroup.getChildren().add(adresIP);
        cGroup.getChildren().add(port);
        cGroup.getChildren().add(adresPort);
        cGroup.getChildren().add(connect);
        cGroup.getChildren().add(chatTitle);
        cGroup.getChildren().add(chat);
        cGroup.getChildren().add(message);
        cGroup.getChildren().add(send);


        client.setScene(clientScene);
        client.show();






         class Ear extends Thread {
            int channel;

            public Ear(){

            }

            public Ear (int channel){
                this.channel=channel;
            }

            public void run()  {
                ServerSocketChannel serverSocketChannel;
                SocketChannel socketChannel=null;
                try {
                    serverSocketChannel = ServerSocketChannel.open();
                    serverSocketChannel.socket().bind(new InetSocketAddress(this.channel));
                    System.out.println("The port is open");
                    socketChannel = serverSocketChannel.accept();
                    System.out.println("The port is listening");
                    chat.appendText("Chat in process \n");
                } catch (IOException e) {
                    System.out.println("Error found");
                    e.printStackTrace();

                }
                while (true) {
                    ByteBuffer readbuf = ByteBuffer.allocate(256);
                    readbuf.clear();
                    try {
                        socketChannel.read(readbuf);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] massa = new byte[256];
                    massa = readbuf.array();
                    String rex ="      " + new String(massa);
                    chat.appendText(rex);
                    readbuf.clear();
                }

            }


        }

        Ear listening = new Ear(30000);
        listening.start();

    }







}
