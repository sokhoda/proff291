package session4;

import java.io.IOException;

/**
 * Created by s_okhoda on 30.12.2015.
 */
public class MainChat {
    public static void main(String[] args) throws IOException {
        ServerEx server = new ServerEx();
        ClientEx client = new ClientEx();

        while (client.start() > 0) {
            server.start();
        }
        client.close();
        server.close();
    }
}
