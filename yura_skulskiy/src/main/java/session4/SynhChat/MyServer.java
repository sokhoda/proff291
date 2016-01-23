package session4.SynhChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Юра on 27.12.2015.
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(3000));
        
        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            handleRequest(socketChannel);
        }
    }
    static ByteBuffer buf = ByteBuffer.allocate(100);
    private static void handleRequest(SocketChannel socketChannel) throws IOException {
        socketChannel.read(buf);
    }


}
