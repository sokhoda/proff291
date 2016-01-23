package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Юра on 27.12.2015.
 */
public class Messenger {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));

        ByteBuffer buf = ByteBuffer.allocate(100);

        buf.put("asdasd ".getBytes());
        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }
        buf.clear();
        int readed;
        while ((readed = socketChannel.read(buf)) > 0) {
//                buffer.getChar();

            System.out.println("Output...");

            System.out.println(Arrays.toString(buf.array()));
            System.out.println(new String(buf.array(), 0, readed));
        }
    }
}

