package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by lenchi on 27.12.15.
 * <p/>
 * Задание:
 * отправить серверу сообщение
 * Cуть: получить ответ и вывести на экран
 *
 * Считай, что это клиент, который отправляет сообщения локально на сервер,
 * реализованный в классе Server.java
 */
public class MessageToServer {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));
        ByteBuffer buf = ByteBuffer.allocate(100);

        buf.put("Hello, server! =)".getBytes());

        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.write(buf);
        }

        buf.flip();

        while (buf.hasRemaining()) {
            socketChannel.read(buf);
        }

        socketChannel.read(buf);

        String str = new String(buf.array());
        System.out.println(str);
    }
}
