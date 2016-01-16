package ChatApp;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.function.Consumer;

/**
 * Created by lenchi on 15.01.16.
 */
public abstract class ChatConnection {
    private ConnectionThread connThread = new ConnectionThread();

    private Consumer<Serializable> onReceiveCallBack;
    public ChatConnection(Consumer<Serializable> onReceiveCallBack){
        this.onReceiveCallBack = onReceiveCallBack;
        connThread.setDaemon(true);
    }

    public void startConnection() throws Exception {
        connThread.start();
    }

    public void send(String data) throws Exception {

        //connThread.buffer.flip();

        connThread.buffer.put(data.getBytes());
        connThread.buffer.flip();
        while (connThread.buffer.hasRemaining()) {
            connThread.socketChannel.write(connThread.buffer);
        }
        connThread.buffer.clear();
    }

    public void closeConnection() {
        try {
            connThread.socketChannel.close();
        } catch (IOException e) {
            onReceiveCallBack.accept("Connection is closed");
        }
    }

    protected abstract boolean isServer();
    protected abstract String getIP();
    protected abstract int getPort();

    private class ConnectionThread extends Thread {
        private SocketChannel socketChannel;
        private ByteBuffer buffer;

        @Override
        public void run() {
            try {    if (isServer()) {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(getPort()));
                SocketChannel socketChannel = serverSocketChannel.accept();
                this.socketChannel = socketChannel;
                onReceiveCallBack.accept("Server is turned on");
            } else {SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(getIP(), getPort()));
                this.socketChannel = socketChannel;
                onReceiveCallBack.accept("Client is connected to Server");
            }

                ByteBuffer buffer = ByteBuffer.allocate(300);
                this.buffer = buffer;
                //buffer.flip();

                while(true){
                    socketChannel.read(buffer);
                    String str = new String(buffer.array());
                    Serializable data = (Serializable) str;
                    onReceiveCallBack.accept(data);
                buffer.clear();
                }
                }
            catch (Exception e) {
                onReceiveCallBack.accept("Connection is closed");
            }
        }


        }

}
