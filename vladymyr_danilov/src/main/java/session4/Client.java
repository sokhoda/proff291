package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel soccetChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));

        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put("Dear Server, Hello, are you hear me? ".getBytes());

        buffer.flip();
//        buffer.rewind();
        while ( buffer.hasRemaining() ) {
            soccetChannel.write(buffer);
        }

        buffer.clear();
//        buffer.flip();
        int reded;
        while ( (reded = soccetChannel.read(buffer)) > 0 ) {
            System.out.println(new String(buffer.array(), 0, reded));
        }

    }
}
