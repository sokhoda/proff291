package homework2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.function.Consumer;

/**
 * Created by Юлия on 12.01.2016.
 */
public abstract class NetworkConnection {

    private Consumer<Serializable> receivedCallBack;

    public NetworkConnection(Consumer<Serializable> receivedCallBack) {
        this.receivedCallBack = receivedCallBack;
    }

    public void startConnection() throws Exception {

    }

    public void send(Serializable data) throws Exception {

    }

    public void closeConnection() throws Exception {

    }

    protected abstract boolean isServer();

    protected abstract String getIP();

    abstract int getPort();

}
//
//    private class ConnectionThread extends Thread{
//
//        private Socket socket;
//        private ObjectOutputStream out;
//
//        @Override
//        public void run() {
//
//                try(ServerSocket server=isServer() ? new ServerSocket(getPort()):null;
//                    Socket socket=isServer() ?server.accept(): new Socket(getIp(), getPort());
//                    ObjectOutputStream out= new ObjectOutputStream(socket.getInputStream());
//            this.socket=socket;
//            this.out=out;
//            socket.setTcpNoDelay(true);
//            while (true){
//                Serializable data=(Serializable )in.readObject();
//                receivedCallBack.accept(data);
//
//                {
//                    catch(Exception e){
//                    receivedCallBack.accept("Connection close");
//                }
//                }}}}}




