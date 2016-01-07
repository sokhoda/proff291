package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 27.12.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));
        System.out.println("Server started");

        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("Connected with client: " + socketChannel.getLocalAddress().toString());

        while(true) {
            handleRequest(socketChannel);
        }

    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException{
        ByteBuffer buf = ByteBuffer.allocate(100);
        buf.flip();
        socketChannel.read(buf);
        String msg = buf.asCharBuffer().toString();
        if (!msg.isEmpty()) {
            System.out.println("Received message: " + msg);
        }

        // receive message from client
//        StringBuilder sb = new StringBuilder();
//        int readed;
//        while((readed = socketChannel.read(buf)) > 0) {
//            sb.append(new String(buf.array()));
//
//        }
//        sb.append(buf.asCharBuffer().toString());
//        System.out.println("Received message: " + sb.toString());
        // send received message back to client
//        buf = ByteBuffer.allocate(sb.toString().length());
//        buf.put(sb.toString().getBytes());
//        buf.flip();
//        while (buf.hasRemaining()) {
//            socketChannel.write(buf);
//        }
    }
}
