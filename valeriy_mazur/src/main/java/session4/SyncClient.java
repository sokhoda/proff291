package session4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Valeriy on 27.12.2015.
 */
public class SyncClient {

    private static final int tcpPORT = 30000;
    private static final int transactQuantity = 3;
    private static final String sendMessageText = "You are the Best Server !";

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress(InetAddress.getLocalHost(), tcpPORT));

        ByteBuffer buf = ByteBuffer.allocate(200);

        for (int i = 0; i < transactQuantity; i++) {
            sendMessageToServer(socketChannel, buf);
            readMessageFromServer(socketChannel, buf);
        }

        buf.clear();
        System.out.println("Close connection...Bye !");
        socketChannel.close();
    }

    private static void sendMessageToServer(SocketChannel socketChannel, ByteBuffer buf) throws IOException {
        buf.clear();
        buf.put(sendMessageText.getBytes());
        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }

        System.out.println("Send message to Server : " + new String(buf.array()));
    }

    private static void readMessageFromServer (SocketChannel socketChannel, ByteBuffer buf) throws IOException {
        buf.clear();
        socketChannel.read(buf);
        System.out.println("Receipt message from Server : " + new String(buf.array()));
    }
}