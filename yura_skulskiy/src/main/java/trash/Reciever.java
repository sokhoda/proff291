package trash;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Юра on 12.01.2016.
 */

public class Reciever extends Thread {
    private ServerSocket serverSocket;

    public Reciever(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(10000);
    }

//    public static void main(String[] args) {
//        int port = 2000;
//        try {
//            Thread t = new Reciever(port);
//            t.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to "
                        + server.getRemoteSocketAddress());
                DataInputStream in =
                        new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
//                DataOutputStream out =
//                        new DataOutputStream(server.getOutputStream());
//                out.writeUTF("Thank you for connecting to "
//                        + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
