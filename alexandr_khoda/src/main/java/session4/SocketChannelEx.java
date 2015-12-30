package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by s_okhoda on 27.12.2015.
 */
public class SocketChannelEx {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));
        ByteBuffer buf = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(100);

        buf.put("Merry Christmas to all colleagues and good Java study on vacations!".getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }
        int read;
        buf2.clear();
        while (( read = socketChannel.read(buf2)) > 0){
            System.out.println(new String(buf2.array(), 0, buf2.array().length));
        }
    }
}
