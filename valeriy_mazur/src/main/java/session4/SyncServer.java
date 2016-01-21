package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Valeriy on 27.12.2015.
 */
public class SyncServer {

    private static final int tcpPORT = 30000;
    private static final int transactQuantity = 3;
    private static final String sendMessageText = "Thank you my dear Client !";

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));

        ByteBuffer buf = ByteBuffer.allocate(200);

        SocketChannel socketChannel = serverSocketChannel.accept();

        for (int i = 0; i < transactQuantity; i++) {
            readMessageFromClient(socketChannel, buf);
            sendMessageToClient(socketChannel, buf);
        }

        buf.clear();
        System.out.println("Close connection...Bye !");
        socketChannel.close();
        serverSocketChannel.close();
    }

    private static void sendMessageToClient(SocketChannel socketChannel, ByteBuffer buf) throws IOException {
        buf.put(sendMessageText.getBytes());
        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }

        System.out.println("Send message to Client : " + new String(buf.array()));
        //buf.rewind();
    }

    private static void readMessageFromClient (SocketChannel socketChannel, ByteBuffer buf) throws IOException {
        buf.clear();
        socketChannel.read(buf);
        System.out.println("Receipt message from Client : " + new String(buf.array()));
        buf.clear();
    }
}
