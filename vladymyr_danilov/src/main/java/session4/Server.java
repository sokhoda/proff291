package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            handlerRequest(socketChannel);
        }

    }

    public static void handlerRequest(SocketChannel socketChanel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        int readed;
        while ( (readed = socketChanel.read(buffer)) > 0 ) {
            System.out.println(new String(buffer.array(), 0, readed));
        }

        buffer.flip();
        while ( buffer.hasRemaining() ) {
            socketChanel.write(buffer);
        }





    }
}
