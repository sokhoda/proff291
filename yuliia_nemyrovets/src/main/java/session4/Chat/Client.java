package session4.Chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Юлия on 27.12.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 12000));
        ByteBuffer buf = ByteBuffer.allocate(100);

        while (true) {
            buf.put("Hello, Server. I'm fine thanks !!!".getBytes());
            buf.flip();
            if (buf.hasRemaining()) {

                socketChannel.write(buf);
            }
            buf.clear();

            socketChannel.read(buf);

            System.out.println(new String(buf.array()));

        }

    }
}
