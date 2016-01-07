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
        ByteBuffer buf = ByteBuffer.allocate(100);

        while (true) {
            buf.clear();
            buf.put("Hello!".getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }
        }
//        buf.flip();
//        int readed;
//        while((readed = socketChannel.read(buf)) > 0) {
//            System.out.println(new String(buf.array()));
//        }
    }
}
