package session3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Сергей on 27.12.2015.
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        SocketChannel myChanell = SocketChannel.open(
                new InetSocketAddress ("192.168.1.121", 30000)
        );
        ByteBuffer buf = ByteBuffer.allocate(100);
        String str = "Hi!";
        buf.put(str.getBytes());

        buf.flip();
        byte[] arr = new byte[1000];
        while (buf.hasRemaining()) {
            myChanell.write(buf);
            buf.clear();
            myChanell.read(buf);
            arr=buf.array();
            //System.out.println(Arrays.toString(arr));
            System.out.println(new String(arr));
        }


    }
}
