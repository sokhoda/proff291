package homework2;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Юлия on 15.01.2016.
 */
public class ChatThread extends Thread {
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private String ipAddress="";
    private int port;
    private int inPort=1001;
    private int outPort=1002;
    private StringBuffer text = new StringBuffer();
    private boolean isConnected;


    public ChatThread() {

    }

    public ChatThread(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public synchronized void updateChatText(String message) {
        if (!message.isEmpty()) {
            text.append(message);
        }
    }

    public void connectToServer() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(ipAddress, inPort));
            updateChatText("Chat client connected to remote server " + socketChannel.getRemoteAddress().toString() + "\n");
            isConnected = true;
        } catch (IOException e) {
            disconnect();
            updateChatText("Chat server waiting for connection from other chat...\n");
        }
    }

    public void disconnect() {
        try {
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socketChannel != null) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateChatText("Remote chat disconnected\n");
    }


    @Override
    public void run() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(ipAddress, port));
            socketChannel = serverSocketChannel.accept();
            updateChatText("Client " + socketChannel.getLocalAddress().toString() +
                    " connected to this chat\n");
            if (!isConnected) {
                connectToServer();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
