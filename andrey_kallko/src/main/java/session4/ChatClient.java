package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by elenabugercuk on 27.12.15.
 */
public class ChatClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            ByteBuffer buf = ByteBuffer.allocate(25);
            System.out.println("Введите свое сообщение.");
            String message = keyboard.nextLine();
            byte[] toPut=new byte[25];
            Arrays.fill(toPut, (byte) 0);
            toPut=message.getBytes();
            //System.out.println(Arrays.toString(toPut));
            buf.put(toPut);
            buf.clear();
            socketChannel.write(buf);
            buf.clear();


            System.out.println("переходим к чтению");



            socketChannel.read(buf);
            byte[] readed = new byte[25];
            buf.rewind();
            //System.out.println("limit= " + buf.limit() + " pos= " + buf.position() + " rem= " + buf.remaining());
            readed = buf.array();
            //System.out.println("limit= " + buf.limit() + " pos= " + buf.position() + " rem= " + buf.remaining());
            String mes = new String(readed);
            System.out.println(mes);
            buf.clear();


//            socketChannel.read(buf);
//            byte[] massa = new byte[500];
//            massa = buf.array();
//            String rex = "Ответ сервера " + new String(massa);
//            System.out.println(rex);
//            buf.clear();




        }
    }
}

