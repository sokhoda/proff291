package session4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by s_okhoda on 08.01.2016.
 */
public class test2 {
    static void print(int i, ServerSocketChannel sc) {
        System.out.println(Integer.toString(i) + "sc.isOpen()=\t" + sc.isOpen()
                + " sc.socket().isBound()=\t" + sc.socket().isBound() + " sc" +
                ".socket().isClosed()=\t" +
                sc.socket().isClosed() + " " + sc.socket().toString());

    }

    public static boolean checkServerSocketBound(ServerSocketChannel ch, String
            ip,
                                           int port) {
        if (ch == null || !ch.socket().isBound() || ip == null || ip.length() ==
                0)
            return false;

        if (ch.socket().getLocalSocketAddress().equals(new InetSocketAddress
                (ip, port))) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;


        try {
            serverSocketChannel = ServerSocketChannel.open();
            print(1, serverSocketChannel);

            System.out.println(checkServerSocketBound(serverSocketChannel,
                    "localhost", 30000));
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 30000));
            serverSocketChannel.configureBlocking(false);
            System.out.println(checkServerSocketBound(serverSocketChannel,
                    "localhost", 30000));

            System.out.println(serverSocketChannel.socket().getLocalPort());
            System.out.println(serverSocketChannel.socket().getLocalSocketAddress());

            print(2, serverSocketChannel);
            serverSocketChannel.close();

            print(3, serverSocketChannel);
            serverSocketChannel = ServerSocketChannel.open();

            print(4, serverSocketChannel);
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost",
                    30001));
            print(5, serverSocketChannel);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            serverSocketChannel.socket().close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
