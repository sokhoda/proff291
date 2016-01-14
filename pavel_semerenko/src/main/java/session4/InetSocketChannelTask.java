package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Pavel on 27.12.2015.
 */
public class InetSocketChannelTask {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put("Run fools! D:".getBytes());

        buffer.flip();

        if(buffer.hasRemaining()){
            socketChannel.write(buffer);
        }
        buffer.clear();
        socketChannel.read(buffer);
        System.out.println("CLIENT >>> " + new String(buffer.array()));

    }
}
