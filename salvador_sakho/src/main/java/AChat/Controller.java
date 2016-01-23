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



    public String getTextOfChat() {
        return textOfChat;
    }

    public void setTextOfChat(String textOfChat) {
        this.textOfChat = textOfChat;
    }

    public Controller() {
    }

    public Controller(SocketChannel clientsockChanForWrite) {
        this.clientsockChanForWrite = clientsockChanForWrite;
    }

    private String masse;
    private ServerSalva ss;
    private SocketChannel clientsockChan;
    private SocketChannel clientsockChanForWrite;
    private boolean isClientConnected;
    private String textOfChat;
    public String ip;

    @FXML
    private TextArea tf1;
    @FXML
    private TextArea tf2;
    @FXML
    private TextArea portField;
    @FXML
    private  TextArea ipArea;

    @FXML
    public void connectionServer(){
        try {
            if(!portField.getText().isEmpty()) {
                ss = new ServerSalva(ipArea.getText(),Integer.parseInt(portField.getText()));
            }else
            {portField.setText("54594");ipArea.setText("127.0.0.1");
                ss = new ServerSalva(ipArea.getText(),Integer.parseInt(portField.getText()));}

                ss.start();
            clientsockChan = SocketChannel.open(new InetSocketAddress(ipArea.getText(),Integer.parseInt(portField.getText())));
            isClientConnected=true;
            System.out.println(clientsockChan.getLocalAddress()+" "+clientsockChan.getRemoteAddress() +" Клиент");
            System.out.println("hello you are connected to chat");
        }catch (IOException e)
        {
            System.out.println(e+" connectionServer");
        }
    }
    @FXML
    public void massegeSender()
    {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            String message = tf1.getText();
            buffer.put(message.getBytes());
            buffer.flip();
            clientsockChan.write(buffer);
        }catch (IOException e)
        {
            System.out.println("massegeSender "+e);
        }

    }
    @FXML
    public void chatMess() throws IOException{
        ByteBuffer buffer = ByteBuffer.allocate(10);
        clientsockChanForWrite.read(buffer);
        buffer.flip();
        String messText= new String(buffer.array());
        System.out.println(messText);
        tf2.appendText(messText);
    }
}
