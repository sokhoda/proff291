package session4;

import java.io.IOError;
import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by s_okhoda on 27.12.2015.
 */
public class ServerEx implements Chatable{
    private ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    private SocketChannel clientSocketChannel;
    private ByteBuffer bufSend = ByteBuffer.allocate(BuffSize);
    private ByteBuffer bufReceive= ByteBuffer.allocate(BuffSize);
    private Random rand = new Random();

    static final int MaxClientRandNo = 500;

    public ServerEx() throws IOException {
        try {
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 30000));
            serverSocketChannel.configureBlocking(false);

        }
        catch (BindException  e) {
            e.printStackTrace();
            serverSocketChannel.close();
            if (clientSocketChannel != null) clientSocketChannel.close();
        }
    }

    public void start() throws IOException {
            if (clientSocketChannel == null) {
                clientSocketChannel = serverSocketChannel.accept();
                clientSocketChannel.configureBlocking(false);
            }

        int readBytesNum;
        if (clientSocketChannel != null) {
            bufReceive.clear();
            while ((readBytesNum = clientSocketChannel.read(bufReceive)) > 0) {
                System.out.println("\nServer established \"" +
                        getAddress(clientSocketChannel) + "\" received: " +
                        "\n" + buffToString(bufReceive, readBytesNum));
            }

            bufSend.clear();
            bufSend.put(("Hallo, Client " + rand.nextInt(MaxClientRandNo)+1).getBytes());
            bufSend.flip();
            while (bufSend.hasRemaining()) {
                clientSocketChannel.write(bufSend);
//                System.out.println("\nServer sends on \"" +
//                        getAddress(clientSocketChannel) + "\"\n" +
//                        buffToString(bufSend, bufSend.limit()));
            }
        }
    }

    public void close(){
        System.out.println("Thank you for using chat. Bye :)");
        try {
            serverSocketChannel.close();
            if (clientSocketChannel != null) clientSocketChannel.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
