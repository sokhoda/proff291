package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

//cчитать с сервера
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5677));
        ByteBuffer buf = ByteBuffer.allocate(100);//Выделяет новый буфер байта.

        Scanner scanner =  new Scanner(System.in);
        buf.put(scanner.next().getBytes());

        buf.flip();//переместить каретку в начало для чтения
        while (buf.hasRemaining()) {

            socketChannel.write(buf);//пишет в канал из буфера
            int read=socketChannel.read(buf);//колличество байтов записанныйх в буфер

            buf.flip();//переместить каретку в начало для чтения

            System.out.println(new String(buf.array(),0,read));//создаем объект стринг с конструктором
           // buf.clear();//очищаем буфер, когда уже передана инфа в канал
        }
    }


    }

