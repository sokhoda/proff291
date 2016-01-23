package chatQuizVersion;

import java.io.*;
import java.net.Socket;

/**
 * Created by Юра on 15.01.2016.
 */
public class Client implements Runnable {
    int port = 2001;
    String servIp = "todo";
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public Client(int port, String servIp) {
        this.port = port;
        this.servIp = servIp;
    }

    public void run() {
        try {
            System.out.println(" Client : Connecting to " + servIp +
                    " on port " + port);
            socket = null;
            socket = new Socket(servIp, port);
            System.out.println("Client: " + "Started: " + socket);
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

//            for (int i = 0; i < 10; i++) {
//                out.println("howdy " + i);
////                String str = in.readLine();
////                System.out.println(str);
//            }
            out.println("yahoo");
//            Scanner scan = new Scanner(System.in);
//            while (true) {
//                System.out.println("------");
//
//                String msgToSend = scan.nextLine();
//                out.println(msgToSend);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Client finally closing...");
            try {
//
                    socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



