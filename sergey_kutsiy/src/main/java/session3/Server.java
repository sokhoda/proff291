package session3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Сергей on 27.12.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel srvCh = ServerSocketChannel.open();
        srvCh.socket().bind(new InetSocketAddress(2000));
        ByteBuffer bufSrv = ByteBuffer.allocate(100);
        bufSrv.clear();
        byte[] arr = new byte[1000];

        while (true) {
            SocketChannel myCh = srvCh.accept();
            myCh.read(bufSrv);
            System.out.println(bufSrv.array());
            //System.out.println(new String(arr));
        }
    }
}
