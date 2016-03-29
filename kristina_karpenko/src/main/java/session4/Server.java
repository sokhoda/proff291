package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

//написать синхронный чат. последовательность действий синхронна.
// последовательна.клиента отправил - получил ответ. сервер получит вопрос - отправил ответ
//2 класса клинта и сервера
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(5677));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buf = ByteBuffer.allocate(100);
            socketChannel.write(buf);//пишет в канал из буфера
            int read=socketChannel.read(buf);//колличество байтов записанныйх в буфер
           // buf.clear();//очищаем буфер, когда уже передана инфа в канал
            buf.flip();//переместить каретку в начало для чтения

            System.out.println(new String(buf.array(),0,read));//создаем объект стринг с конструктором
        }
    }
}
