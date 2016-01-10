package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by lenchi on 27.12.15.
 * <p/>
 * Написать синхронный чат
 * Особенность чата: четко фиксированная последовательность действий. (синхронный обмен сообщениями)
 * Операции: подключились - Клинет отправил сообщение, Сервер принял - отпарвил ответ, Клиент принял - отправил ответ...
 * <p/>
 * Особенности задания:
 * Клиент и Сервер класс
 * <p/>
 * Сервер на порту, Клиент подсоединен
 * <p/>
 * Кольцевое соединение - подключение к самом себе на тот же хост (IP = 127.0.0.1, localhost)
 *
 *
 * Этот класс - это сервер, который принимает сообщение от клиента,
 * реализованного в классе MessageToServer.java
 */
public class Server {
    static ByteBuffer buf = ByteBuffer.allocate(100);

    public static void requestHandling(SocketChannel socketChannel) throws IOException {
        socketChannel.read(buf);

        String str = new String(buf.array());
        System.out.println(str);

        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            requestHandling(socketChannel);
        }
    }
}