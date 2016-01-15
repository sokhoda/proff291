package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Home on 27.12.2015.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 30000));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            handleRequest(socketChannel);
        }
    }

    private static void handleRequest(SocketChannel socketChannel) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
    }
}





