package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by elenabugercuk on 27.12.15.
 */
public class Client {
    public static void main(String[] args) throws IOException{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));
        ByteBuffer buf = ByteBuffer.allocate(500);
        buf.put("Жду ответа".getBytes());
        buf.flip();

        while (buf.hasRemaining()){
            socketChannel.write(buf);
        }

        buf.flip();
        buf.clear();
        while (buf.hasRemaining()){
            socketChannel.read(buf);
            byte [] massa = new byte[100];
            massa=buf.array();
            System.out.println(Arrays.toString(massa));

            System.out.println(new String(Arrays.toString(massa)));

            String rex = new String(massa);

            System.out.println(rex);
        }

    }
}
