package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Павло on 27.12.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {

        SocketChannel socketCannel = SocketChannel.open(new InetSocketAddress("192.168.1.121", 30000));
        ByteBuffer byt = ByteBuffer.allocate(100);
        byt.put("сообщение в интернет".getBytes());
        byt.flip();

        while (byt.hasRemaining()) {
            socketCannel.write(byt);

        }

        //while(byt.hasRemaining()){
        //  socketCannel.read();


    }
}
