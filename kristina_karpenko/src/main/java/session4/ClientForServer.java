package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Администратор on 27.12.2015.
 */
public class ClientForServer {
    private SocketChannel socketChannel;

    public ClientForServer() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
    }
    public void sendMessage (String message)throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(100);

        if (message!=null) {
//            buf2.flip();
            buf.put(message.getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
                socketChannel.read(buf2);
                System.out.println(new String(buf2.array(), 0, buf2.array().length));
            }
        }
    }
}


