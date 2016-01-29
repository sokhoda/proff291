package trash;

import java.io.*;
import java.net.Socket;

/**
 * Created by Юра on 12.01.2016.
 */
public class LetsTry {
    public static void main(String[] args) throws IOException {
        int port = 3001;
        try {
            Thread t = new Reciever(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread senderThread = new Thread(new Sender());
        senderThread.start();
//        Socket client = new Socket(serverName, port);
//        System.out.println("Just connected to "
//                + client.getRemoteSocketAddress());
//        OutputStream outToServer = client.getOutputStream();
//        DataOutputStream out = new DataOutputStream(outToServer);
//        out.writeUTF("Hello from "
//                + client.getLocalSocketAddress());
//        InputStream inFromServer = client.getInputStream();
//        DataInputStream in =
//                new DataInputStream(inFromServer);
//        System.out.println("Server says " + in.readUTF());
//        client.close();
    }


}
