package session4;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by s_okhoda on 30.12.2015.
 */
public class test {
    static final int BuffSize = 100;
    public static   String getAddress(AbstractSelectableChannel sc) {
        if (sc instanceof SocketChannel) {
            SocketChannel sc1;
            sc1 = ((SocketChannel) sc);
            return "remote: " + sc1.socket().getRemoteSocketAddress().toString() +
                    "; local: " + sc1.socket().getLocalSocketAddress().toString();
        }
        if (sc instanceof ServerSocketChannel) {
            ServerSocketChannel sc1;
            sc1 = ((ServerSocketChannel) sc);
            return "local: " + sc1.socket().getLocalSocketAddress().toString();
        }
        return "";

    }

    public static String buffToString(ByteBuffer b, int readBytesNum) {
        if (b == null || readBytesNum <= 0) {
            return "";
        }
        return new String(b.array(), 0, readBytesNum);
    }

    public static void main(String[] args) throws Exception {
//        SocketChannel ClientSocketChannel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
        SocketChannel socketChannel = null;
        SocketChannel clientSocketChannel = null;

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ByteBuffer bufSend;
        ByteBuffer buffReceive;
        ByteBuffer buffReceiveClient = ByteBuffer.allocate(BuffSize);
        Random rand = new Random();
        bufSend = ByteBuffer.allocate(BuffSize);

        buffReceive = ByteBuffer.allocate(BuffSize);

        try {
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 30000));
            serverSocketChannel.configureBlocking(false);
            System.out.println("serverSocketChannel: " +
                    serverSocketChannel.socket().toString() );
            socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
            socketChannel.configureBlocking(false);

            System.out.println("socketChannel: " +
                    socketChannel.socket().toString() );

            clientSocketChannel = serverSocketChannel.accept();
            clientSocketChannel.configureBlocking(false);

            System.out.println("clientSocketChannel: " +
                    clientSocketChannel.socket().toString() );
        }
        catch (BindException e) {
            e.printStackTrace();
            serverSocketChannel.close();
            if (socketChannel != null) socketChannel.close();
            if (clientSocketChannel != null) clientSocketChannel.close();
        }


        int readBytesNum;
        Scanner scan = new Scanner(System.in);
        String message = "";

        while (!message.equals("stop") && socketChannel != null) {
            message = scan.nextLine();
            if (message.trim().length() > 0) {
                socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                System.out.println("\nClient sends on \"" +
                        getAddress(socketChannel) + "\"\n" +
                        message);
                }

            if (clientSocketChannel != null) {
                buffReceive.clear();
                while ((readBytesNum = clientSocketChannel.read(buffReceive)) > 0) {
                    System.out.println("\nServer established \"" +
                            getAddress(clientSocketChannel) + "\" received: " +
                            "\n" + buffToString(buffReceive, readBytesNum));
                }
                bufSend.clear();
                bufSend.put(("Hallo, Client " + rand.nextInt(500)+1).getBytes());
                bufSend.flip();
                while (bufSend.hasRemaining()) {
                    clientSocketChannel.write(bufSend);
                    System.out.println("\nServer sends on \"" +
                            getAddress(clientSocketChannel) + "\"\n" +
                            buffToString(bufSend, bufSend.limit()));
                }
            }

            buffReceiveClient.clear();
            while ((readBytesNum = socketChannel.read(buffReceiveClient)) > 0) {
                System.out.println("\nClient on \"" +
                        getAddress(socketChannel) + "\" received: " +
                        "\n" +buffToString(buffReceiveClient, readBytesNum));
            }
        }
        System.out.println("thank you for using chat");

//        socketChannel.close();
//        socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
//        socketChannel.configureBlocking(false);
//
//        System.out.println("new socketChannel: " +
//                socketChannel.socket().toString() );
//
//        clientSocketChannel = serverSocketChannel.accept();
//        clientSocketChannel.configureBlocking(false);
//
//        System.out.println("clientSocketChannel: " +
//                clientSocketChannel.socket().toString() );


        serverSocketChannel.close();
        if (socketChannel != null) socketChannel.close();
        if (clientSocketChannel != null) clientSocketChannel.close();
    }
}
