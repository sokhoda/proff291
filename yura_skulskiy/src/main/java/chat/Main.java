package chat;

import trash.NetworkUtil;

import java.io.*;
import java.net.Socket;

/**
 * Created by Юра on 12.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        int port = 2012;
//        String ip = "93.74.102.177";
        String ip = "192.168.0.99";
//        String ip = "localhost";
        try {
            GreetingServer ser = new GreetingServer(port);
            ser.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        String serverName = args[0];
//        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("Connecting to "  +ip+
                    " on port " + port);
            Socket client = new Socket(ip,port);
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from Yura!!!"
                    + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            System.out.println("Server says " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
