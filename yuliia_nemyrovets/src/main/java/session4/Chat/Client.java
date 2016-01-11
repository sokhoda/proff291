package session4.Chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Юлия on 27.12.2015.
 */
public class Client {
        public static void main(String[] args) throws IOException, InterruptedException {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1111));
            ByteBuffer buf = ByteBuffer.allocate(100);
            socketChannel.read(buf);
            buf.put("Hello, Server !!!".getBytes());
            buf.flip();
            while (true) {
                socketChannel.write(buf);
                buf.clear();

                int readed = socketChannel.read(buf);
                buf.flip();

                System.out.println(new String(buf.array(), 0, readed));
                Thread.sleep(1000);
            }

        }
}
