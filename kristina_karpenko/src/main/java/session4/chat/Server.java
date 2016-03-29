package session4.chat;
//Синхронный чат

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Server {
    static ByteBuffer bufRead = ByteBuffer.allocate(100);
    static ByteBuffer bufWrite = ByteBuffer.allocate(100);//to client
    static Scanner scanner = new Scanner(System.in);

    public static void haveChat(SocketChannel socketChannel) throws IOException {

        while (true) {
            bufRead.clear();
            bufWrite.clear();
            String strClient = new String(bufRead.array(), 0, socketChannel.read(bufRead));
            System.out.println(strClient);
            bufWrite.put(scanner.nextLine().getBytes());
            bufWrite.flip();
            while (bufWrite.hasRemaining()) {
                socketChannel.write(bufWrite);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(5678));
        SocketChannel socketChannel = serverSocketChannel.accept();
        haveChat(socketChannel);
    }
}
