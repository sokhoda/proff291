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

    ServerSalva(){
    }

    ServerSalva(String ip,int port){
        this.listenPort=port;
        this.ip=ip;
    }


    public int getWritingPort() {
        return writingPort;
    }

    public void setWritingPort(int writingPort) {
        this.writingPort = writingPort;
    }

    private  int listenPort;
    private  int writingPort;
    private  String ip;
    private SocketChannel scForlisten;
    private ServerSocketChannel ssc;
    Controller con = new Controller();

@Override
    public void run() {
    try {
        ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(ip,listenPort));
        System.out.println("I am hear");

        System.out.println("Server On");

        scForlisten=ssc.accept();

        System.out.println(scForlisten.getLocalAddress()+" "+scForlisten.getRemoteAddress()+" Сервер");
        System.out.println(scForlisten.isConnected());

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
              System.out.println(messText +" текст сообщения");
            scForlisten.write(bb);
                bb.clear();
                con.chatMess(scForlisten);//Должен выводить в окно текст

        }catch (IOException e)
        {
            System.out.println("Reading from scForlisten "+e);
        }
    }

}

}