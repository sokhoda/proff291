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
    private SocketChannel scForWrite;
    private ServerSocketChannel ssc;
    private ServerSocketChannel sscForWrite;
    Controller con = new Controller();

@Override
    public void run() {
    try {
        ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(ip,listenPort));
        System.out.println("I am hear");

         sscForWrite= ServerSocketChannel.open();
         sscForWrite.socket().bind(new InetSocketAddress(ip,listenPort+5));
        System.out.println("Server On");


        scForlisten=ssc.accept();
        scForWrite=sscForWrite.accept();

    } catch (IOException e) {
        System.out.println("serverTurnOn " + e);
    }

    ByteBuffer bbIN= ByteBuffer.allocate(10);

    while (true){
        try {
            bbIN.clear();
            scForlisten.read(bbIN);
            bbIN.flip();
            String messText= new String(bbIN.array()+" перед записью в канал");
               System.out.println(scForWrite.getLocalAddress()+" "+scForWrite.getRemoteAddress()+" Сервер/порт для записи");
            scForWrite.write(bbIN);
            Controller cont= new Controller(scForWrite);
            cont.chatMess();// метод con.chatMess берет байты из канала приобразует и выводит в окно вывода
        }catch (IOException e)
        {
            System.out.println("Reading from scForlisten "+e);
        }
    }

}

}