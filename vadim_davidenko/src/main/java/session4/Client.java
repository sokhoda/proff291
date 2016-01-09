package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 27.12.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30001));
        for (int i=1; i<=5; i++) {
            handleRequest(socketChannel);
        }
    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put("<< Other user >>\nHi, server\n".getBytes());
        buffer.flip();
        if (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
        buffer.clear();
    }

}
