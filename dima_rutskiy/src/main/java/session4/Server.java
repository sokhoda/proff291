package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Rrr on 27.12.2015.
 */
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(3000));

        while(true){
            SocketChannel socketChannel =serverSocketChannel.accept();
            handleRequest(socketChannel);
        }

    }

    private static void handleRequest(SocketChannel socketChannel) {


    }


}
