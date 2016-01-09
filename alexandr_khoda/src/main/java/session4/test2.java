package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by s_okhoda on 08.01.2016.
 */
public class test2 {
    static void print(int i, SocketChannel sc){
        System.out.println(Integer.toString(i) + "sc.isOpen()=\t" +sc.isOpen()
                +" sc.socket().isBound()=\t" +sc.socket().isBound() + " sc" +
                ".socket().isClosed()=\t" +
                sc.socket().isClosed() +" "+ sc.socket().toString());

    }
    public static void main(String[] args) {
        SocketChannel serverSocketChannel = null;

        try {
            serverSocketChannel = SocketChannel.open();
            print(1,serverSocketChannel);


            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 30000));
            serverSocketChannel.configureBlocking(false);


            print(2,serverSocketChannel);
            serverSocketChannel.close();

            print(3,serverSocketChannel);
            serverSocketChannel = SocketChannel.open();

            print(4,serverSocketChannel);
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost",
                    30001));
            print(5, serverSocketChannel);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

//        serverSocketChannel.socket().close();

        System.out.println(serverSocketChannel.isOpen() +" " +
                serverSocketChannel.socket().isBound() + " " +
                serverSocketChannel.socket().isClosed());
    }
}
