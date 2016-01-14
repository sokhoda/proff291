package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Pavel on 27.12.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(65000));

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            handleRequest(socketChannel);
        }
    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        socketChannel.read(buffer);

        System.out.println("CLIENT >>> " + new String(buffer.array()));
        buffer.clear();
        buffer.put("server ansver".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
    }

}
