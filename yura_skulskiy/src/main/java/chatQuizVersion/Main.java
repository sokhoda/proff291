package chatQuizVersion;

import chat.GreetingServer;

import java.io.IOException;

/**
 * Created by Юра on 15.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        int port = 2016;
        String ip = "192.168.0.99";
        Thread serv = new Thread(new Server(port));
        serv.start();
//        try {
//            Thread gr = new GreetingServer(port);
//            gr.start();
//        } catch (IOException e) {
//
//
//        }
//          Client client = new Client(port,ip);
//        client.run();
//        Thread client = new Thread(new Client(port,ip));
//        client.start();
    }

}
