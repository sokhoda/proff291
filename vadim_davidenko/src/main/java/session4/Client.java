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
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(100);

        while (true) {
            buffer.put("hi, server".getBytes());

            buffer.flip();

            if (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();
            socketChannel.read(buffer);
            System.out.println("CLIENT >>> " + new String(buffer.array()));
        }
    }
}
