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
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));

        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.put("Hello Server!".getBytes());

        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }

        buf.flip();
        int readed;
        while((readed = socketChannel.read(buf)) > 0) {
            System.out.println(new String(buf.array()));
        }
    }
}
