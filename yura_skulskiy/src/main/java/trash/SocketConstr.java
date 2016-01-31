package trash;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Юра on 12.01.2016.
 */
public class SocketConstr {

    //    Socket(InetAddress address, int port, InetAddress localAddr, int localPort)
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        InetAddress address =InetAddress.getByName(NetworkUtil.getCurrentIP());
        int port = 2000;
        InetAddress localAddr = NetworkUtil.getLocalAddress();
        int localPort = socket.getLocalPort();
        System.out.println("айпи "+address.toString());
        System.out.println("локальный айпи"+localAddr.toString());
        System.out.println("localPort"+localPort);
        System.out.println(InetAddress.getLocalHost().toString());;

    }
}
