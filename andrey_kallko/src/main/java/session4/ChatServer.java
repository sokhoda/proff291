package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by elenabugercuk on 27.12.15.
 */
public class ChatServer {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(30000));
        SocketChannel socketChannel = serverSocketChannel.accept();
        int i=0;

        while (true){
            System.out.println("Сообшение " + (i + 1) + ":");

            handleRequest(socketChannel);
            //System.out.println(" resieve ok");
            i++;
            System.out.println("Отправляем ответ");
            handleresponse(socketChannel);
//            System.out.println(" response ok");



        }

    }

    private static void handleresponse(SocketChannel socketChannel) throws IOException{
        ByteBuffer wBuf = ByteBuffer.allocate(25);
        wBuf.clear();
        String answer  = "ответ";
        wBuf.put(answer.getBytes());
        wBuf.rewind();
        socketChannel.write(wBuf);
        wBuf.clear();
//        byte[] cleaner = new byte[25];
//        Arrays.fill(cleaner, (byte)0);
//        wBuf.position(0);
//        wBuf.put(cleaner);
//        wBuf.rewind();
//
//        cleaner=wBuf.array();
//        System.out.println(" 2 resp" + new String(cleaner));

    }

    private static void handleRequest(SocketChannel socketChannel) throws IOException{
        ByteBuffer readbuf = ByteBuffer.allocate(25);



        readbuf.clear();


            //System.out.println("limit= " + readbuf.limit() + " pos= " + readbuf.position() + " rem= " + readbuf.remaining());

            socketChannel.read(readbuf);
            byte [] massa = new byte[25];
            Arrays.fill(massa, (byte) 0);
            massa=readbuf.array();
            //System.out.println("limit= "+readbuf.limit() + " pos= " +readbuf.position() + " rem= "+ readbuf.remaining() );

            //System.out.println(new String(Arrays.toString(massa)));

            String rex = new String(massa);

            System.out.println(rex);

        readbuf.clear();
//        Arrays.fill(massa, (byte) 0);
//        readbuf.put(massa);
//        massa=readbuf.array();
//        String next = " after" + new String(massa);
//        System.out.println(next);

    }
}





//    private static void handleresponse(SocketChannel socketChannel) throws IOException {
//        ByteBuffer buf =  ByteBuffer.allocate(500);
//        String response = "Ваше сообщение получено. Пишите еще!!!!";
//        byte [] massa = response.getBytes();
//        socketChannel.write(ByteBuffer.wrap(massa));
//
//    }
//
//
//
//
//
//
//    private static void handleRequest(SocketChannel socketChannel) throws IOException {
//        ByteBuffer buf = ByteBuffer.allocate(100);
//        buf.clear();
//
//        boolean repeat=true;
//        while (repeat){
//
//            System.out.println("inside start");
//            socketChannel.read(buf);
//            byte [] massa = buf.array();
//            int i=0;
//            while (i<100){
//                System.out.println(i + " " + massa[i]);
//                i++;
//            }
//            System.out.println("Reading in process");
//            String rex = new String(massa);
//            System.out.println(rex);
//            if (rex.equals("")==false) {
//                repeat=false;
//                System.out.println("hellow" + rex);
//                System.out.println("inside finish.");};
//
//
//            //buf.clear();
//        }
//        buf.clear();
//
//    }
//}
