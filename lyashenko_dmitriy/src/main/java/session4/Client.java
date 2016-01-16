package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Solyk on 27.12.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SocketChannel socketChannel = SocketChannel.open(
                    new InetSocketAddress("127.0.0.1", 65000));

            ByteBuffer bufferOut = ByteBuffer.allocate(20);
            ByteBuffer bufferIn = ByteBuffer.allocate(20);
            bufferOut.put("Hello Server".getBytes());
            bufferOut.flip();


            if (bufferOut.hasRemaining()) {
                socketChannel.write(bufferOut);
                bufferOut.flip();
                socketChannel.read(bufferIn);
                bufferIn.flip();
                System.out.println(new String(bufferIn.array()));

            }

            socketChannel.close();
        }
    }
}
