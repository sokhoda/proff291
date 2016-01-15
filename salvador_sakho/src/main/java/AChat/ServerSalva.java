package AChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by User on 10.01.2016.
 */
public class ServerSalva extends Thread{

    ServerSalva(int port){
        this.port=port;
    }
    ServerSalva(){
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private  int port;
    private SocketChannel scForlisten;
    private ServerSocketChannel ssc;
    Controller con = new Controller();
@Override
    public void run() {
    try {
        ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(getPort()));
        System.out.println("I am hear");
        if(!con.isClientConnected()){
        con.connectionServer(ssc,getPort());
        }
        System.out.println("I am hear2");
        scForlisten=ssc.accept();

    } catch (IOException e) {
        System.out.println("serverTurnOn " + e);
    }

    ByteBuffer bb= ByteBuffer.allocate(1000);
    while (true){
        try {
            bb.clear();
            scForlisten.read(bb);
            bb.flip();
            String messText= new String(bb.array());
            if (!messText.isEmpty()) {///метод вывода в окно(messText)
              con.chatMess(messText);//Должен выводить в окно текст
                System.out.println(messText);
            }
        }catch (IOException e)
        {
            System.out.println("Reading from scForlisten "+e);
        }
    }
}

}