package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Юлия on 27.12.2015.
 */
public class Client {
    public static void main(String [] args) throws IOException{
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("192.168.1.121",30000));
        ByteBuffer buf= ByteBuffer.allocate(100);
        buf.put("Hello, Server. What's the good weather today! How are you today".getBytes());
        buf.flip();
        while(buf.hasRemaining())
        {
          socketChannel.write(buf);
            buf.clear();

            int readed=socketChannel.read(buf);
            buf.flip();

            System.out.println(new String(buf.array(),0,readed));
        }

    }
}
