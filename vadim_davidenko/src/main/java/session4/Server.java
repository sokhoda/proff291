package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 27.12.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));
        System.out.println("Server started");

        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("Connected with client: " + socketChannel.getLocalAddress().toString());
            handleRequest(socketChannel);
        }
    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        socketChannel.read(buffer);

        System.out.println("CLIENT >>> " + new String(buffer.array()));
        buffer.clear();
        buffer.put("Hi, client".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
    }

}
