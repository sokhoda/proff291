package AChat;

import javafx.fxml.FXML;
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
    TextField tf1;
    @FXML
    TextField tf2;
    @FXML
    TextField portField;

    @FXML
    public void servOn1() {
        if (ss == null) {
            ss = new ServerSalva(Integer.parseInt(portField.getText()));
            ss.setPort(Integer.parseInt(portField.getText()));
            ss.start();
        }
    }

    @FXML
    public void makeAction() {
        String st=tf1.getText();

        massegeSender(st);
        System.out.println(st);
        tf1.clear();
    }

    public void connectionServer(ServerSocketChannel s, int portnumber){
        try {
            clientsockChan = SocketChannel.open(new InetSocketAddress(portnumber));
            isClientConnected=true;
            System.out.println("hello");

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
        tf2.setText(cm);
    }
}
