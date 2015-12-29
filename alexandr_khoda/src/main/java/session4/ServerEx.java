package session4;

import java.io.IOError;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by s_okhoda on 27.12.2015.
 */
public class ServerEx {
    public ServerEx() throws IOException {

          ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost",30000));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buf = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(100);

            buf.put("Hallo, dear client!".getBytes());
            buf.flip();
            buf2.flip();

                socketChannel.read(buf2);
            while (buf2.hasRemaining()){
                socketChannel.write(buf);
                System.out.println(new String(buf2.array(), 0, buf2.array().length));
            }
            buf2.flip();
        }

    }

    public static void main(String[] args) throws IOException{
        ServerEx server = new ServerEx();
        ClientEx client = new ClientEx();
        client.sendMessage("Hallo, server!");

    }
}
