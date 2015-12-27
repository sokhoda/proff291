package session4.Chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Юлия on 27.12.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(1111));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
           handleRequest(socketChannel);
        }

    }

    public static void handleRequest(SocketChannel socketChannel) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(100);
        socketChannel.read(buf);
        buf.put("Hello, Client".getBytes());
        buf.flip();
        while (true) {
            socketChannel.write(buf);
            buf.clear();

            int readed=socketChannel.read(buf);
            buf.flip();

            System.out.println(new String(buf.array(),0,readed));


        }

    }
}

