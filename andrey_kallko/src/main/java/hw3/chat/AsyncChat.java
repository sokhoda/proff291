package hw3.chat;

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
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


/**
 * Created by tri___ton on 03.01.16.
 */
public class AsyncChat extends Application {
    private static int numberOfClients=0;

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage arg0) throws Exception {
        AsyncChat manager = new AsyncChat();
        manager.starter();
    }

    private void starter() {
        Stage starter = new Stage();
        starter.setTitle("Окно для запуска клиентов.");
        Group gStarter = new Group();
        String status = "Запушено " + numberOfClients + " клиентов";

        TextField annotaition = new TextField();

        annotaition.setText(status);
        annotaition.setLayoutY(20.0);
        annotaition.setLayoutX(10.0);
        annotaition.setMinWidth(280.0);
        annotaition.setMaxHeight(50.0);
        annotaition.setAlignment(Pos.BOTTOM_CENTER);
        annotaition.setEditable(false);
        annotaition.setBackground(Background.EMPTY);



        Button clientStart = new Button("Add Client");
        clientStart.setLayoutX(70);
        clientStart.setLayoutY(50);
        clientStart.setMinWidth(75);
        clientStart.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                newClient();
                annotaition.setText("Запушено " + numberOfClients + " клиентов");
            }
        });


        Button close = new Button("Close All");
        close.setLayoutX(155);
        close.setLayoutY(50);
        close.setMinWidth(75);
        close.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                starter.close();
            }
        });




        gStarter.getChildren().add(annotaition);
        gStarter.getChildren().add(clientStart);
        gStarter.getChildren().add(close);
        Scene sStarter = new Scene(gStarter, 300, 100);
        starter.setScene(sStarter);
        starter.show();



    }

    public void newClient(){
        Way clientWay = new Way(30000+numberOfClients*2);
        clientWay.start();
        Stage client = new Stage();
        numberOfClients++;
        client.setTitle("Новое Окно." + numberOfClients);
        Group cGroup = new Group();
        Scene clientScene = new Scene(cGroup, 420, 370);

        Text ip=new Text();
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


        TextField adresPort = new TextField();
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

        TextArea chat = new TextArea();
        chat.setLayoutX(10);
        chat.setLayoutY(70);
        chat.setMinHeight(250);
        chat.setMinWidth(400);
        chat.setMaxHeight(250);
        chat.setMaxWidth(400);
        chat.setEditable(false);
        //chat.setAlignment(Pos.BOTTOM_LEFT);


        TextField message = new TextField();
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
                chat.appendText(temp);
                message.setText("");
            }
        });




        connect.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String ipad = ip.getText();
                Integer portad = Integer.parseInt((String) adresPort.getText());
                System.out.println(portad);
                try {
                    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(ipad, portad));
                } catch (IOException e) {
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

    }

    public  class Way extends Thread {
        String name;
        int portnumber;

        public Way() {

        }

        public Way(int port){

            this.portnumber=port;

        }


        public void run()  {


            System.out.println("My port is " + this.portnumber);
            ServerSocketChannel serverSocketChannel = null;
            try {
                serverSocketChannel = ServerSocketChannel.open();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocketChannel.socket().bind(new InetSocketAddress(this.portnumber));
                System.out.println("Port is open " + this.portnumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (this.isInterrupted()==false){

            }

        }
    }

}
