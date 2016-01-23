package chatQuizVersion;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Юра on 15.01.2016.
 */
public class Server implements Runnable {
    private ServerSocket serverSocket = null;
    private BufferedReader in;
    private PrintWriter out;

    public Server(int port) {
        System.out.println("Сервак - конструктор");
        try {
            serverSocket = new ServerSocket(port);
//            serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;


    public void frun() {
        System.out.println("run serv");
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                System.out.println("Сервак - сокет заэксептили");
                DataInputStream in =
                        new DataInputStream(socket.getInputStream());
                System.out.println("server channel" + in.readUTF());
                out = new PrintWriter(socket.getOutputStream(), true);
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Сервак: Waiting for client on localport  " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Server"+server);
                System.out.println("Servak: Just connected to "
                        + server.getRemoteSocketAddress());
//                DataInputStream in = new DataInputStream(server.getInputStream());
//                System.out.println(in.readUTF());
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        server.getInputStream()));

                    String str = in.readLine();
                    if(str == null){
                        System.out.println("break");
                        break;
                    }
                    System.out.println("Server: message from client: " + str);




//                DataOutputStream out =
//                        new DataOutputStream(server.getOutputStream());
//                out.writeUTF("Thank you for connecting to "
//                        + server.getLocalSocketAddress() + "\nGoodbye!");
//                server.close();
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


//    private BufferedReader in;
//    private PrintWriter out;
//    private Socket socket;

