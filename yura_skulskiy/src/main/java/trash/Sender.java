package trash;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Юра on 12.01.2016.
 */
public class Sender implements Runnable {
    public static void main(String[] args) throws Exception {

    }

    @Override
    public void run() {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(NetworkUtil.getCurrentIP());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("start to send");
        int port = 2000;
        InetAddress localAddress = NetworkUtil.getLocalAddress();
        int localPort = 2001;
        Socket socket = null;
        try {
            System.out.println(address.toString()+" | "+ port+" | "+localAddress+" | "+localPort);
//            socket = new Socket(address, port, localAddress, localPort);
//            socket = new Socket(address, port);
            socket = new Socket("localhost", port);

//            socket = new Socket()
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = null;
        try {

            System.out.println("test stream");
            System.out.println(" socket.toString();");
            System.out.println(socket.getOutputStream()==null);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("Yahoo");
        out.close();
    }
}
