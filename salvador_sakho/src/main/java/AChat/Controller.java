package AChat;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by User on 09.01.2016.
 */
public class Controller {

     public String getMasse() {
        return masse;
    }

    public void setMasse(String masse) {
        this.masse = masse;
    }



    public boolean isClientConnected() {
        return isClientConnected;
    }

    public void setClientConnected(boolean clientConnected) {
        isClientConnected = clientConnected;
    }

    private String masse;
    private ServerSalva ss;
    private SocketChannel clientsockChan;
    private ServerSocketChannel servSockChen;
    private boolean isClientConnected;
   // ByteBuffer buffer = ByteBuffer.allocate(1000);

    @FXML
    TextArea tf1;
    @FXML
    TextArea tf2;
    @FXML
    TextArea portField;
    @FXML
    TextArea IPField;

    @FXML
    public void servOn1() {
//        if (ss == null) {
//            ss = new ServerSalva(Integer.parseInt(portField.getText()));
//            ss.start();
//        }
    }

    @FXML
    public void makeAction() {
        String st=tf1.getText();
        massegeSender(st);
        System.out.println(st);
        tf1.clear();
    }
    @FXML
    public void connectionServer(){
        try {
            ss = new ServerSalva(Integer.parseInt(portField.getText()));
            ss.start();
            clientsockChan = SocketChannel.open(new InetSocketAddress(ss.getPort()));
            isClientConnected=true;
            System.out.println(clientsockChan.getLocalAddress()+" "+clientsockChan.getRemoteAddress());
            System.out.println("hello you are connected to chat");
        }catch (IOException e)
        {
            System.out.println(e+" connectionServer");
        }
    }

    public void massegeSender(String mess)
    {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            String message = mess + "  from Salva";
            buffer.put(message.getBytes());
            buffer.flip();
            clientsockChan.write(buffer);
            System.out.println(buffer);
        }catch (IOException e)
        {
            System.out.println("massegeSender "+e);
        }

    }
    public void chatMess(String cm){
        tf2.appendText(String.format("Your masseg ")+cm);
    }
}
