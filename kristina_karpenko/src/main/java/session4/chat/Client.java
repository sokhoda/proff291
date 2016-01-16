package session4.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    static SocketChannel socketChannel;
    static ByteBuffer bufWrite = ByteBuffer.allocate(100);//to server
    static ByteBuffer bufRead = ByteBuffer.allocate(100);//from server
    static Scanner scanner = new Scanner(System.in);

    public static void haveChat() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5678));
        while (true) {
            bufRead.clear();
            bufWrite.clear();

            bufWrite.put(scanner.nextLine().getBytes());
            bufWrite.flip();

            while (bufWrite.hasRemaining()) {
                socketChannel.write(bufWrite);
            }

            String strServer = new String(bufRead.array(), 0, socketChannel.read(bufRead));
            System.out.println(strServer);
        }
    }

    public static void main(String[] args) throws IOException {
        haveChat();
    }
}
