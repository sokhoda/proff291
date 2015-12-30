package session4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by s_okhoda on 27.12.2015.
 */
public class ClientEx implements Chatable {
    private SocketChannel socketChannel;
    private ByteBuffer bufSend = ByteBuffer.allocate(BuffSize);
    private ByteBuffer bufRecieve = ByteBuffer.allocate(BuffSize);

    public ClientEx() throws IOException {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 30000));
            socketChannel.configureBlocking(false);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            if (socketChannel != null) socketChannel.close();
        }
    }

    public int start() throws IOException {
        int readBytesNum;

        if (socketChannel == null) return -1;
        bufRecieve.clear();
        while ((readBytesNum = socketChannel.read(bufRecieve)) > 0) {
            System.out.println("\nClient on \"" +
                    getAddress(socketChannel) + "\" received: " +
                    "\n" + buffToString(bufRecieve, readBytesNum));
        }

        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();

        if (message.equals(ExitWord)) return -1;
        if (message.trim().length() > 0) {
            socketChannel.write(ByteBuffer.wrap(message.getBytes()));
//            System.out.println("\nClient sends on \"" +
//                    getAddress(socketChannel) + "\"\n" +
//                    message);
        }
        return 1;
    }

    public void close(){
        try {
            if (socketChannel != null) socketChannel.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
