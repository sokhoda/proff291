package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Rrr on 27.12.2015.
 */
public class client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel=SocketChannel.open(
                new InetSocketAddress("192.168.1.121",30000));
       // SeekableByteChannel channel = null;
        ByteBuffer buf=ByteBuffer.allocate(100);
        buf.put("Hello my friend".getBytes());
        buf.flip();
        while(buf.hasRemaining()){
            socketChannel.write(buf);


        }
        int readed;
        while((readed = socketChannel.read(buf)) > 0) {
           // System.out.println(Arrays.toString(buf.array()));

            System.out.println(new String(buf.array()));
            buf.clear();
        }

    }
}
