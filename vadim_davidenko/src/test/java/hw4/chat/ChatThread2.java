package hw4.chat;
import javafx.application.Platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 07.01.2016.
 */
public class ChatThread2 extends Thread {

    private ServerSocketChannel serverSocketChannel;
    private SocketChannel socketChannel;
    private String ip;
    private int port;

    public ChatThread2(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        final int BUFFER_SIZE = 100;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
            AsyncChat2.updateChatText("Chat server is listening for client... \n");

            socketChannel = serverSocketChannel.accept();
            AsyncChat.updateChatText("Client " + socketChannel.getLocalAddress().toString() + " connected to this chat\n");
            if (!AsyncChat2.isConnected) {
                AsyncChat.updateChatText("Click [Connect] button to connect with server\n");
            }
        } catch (IOException e) {
            disconnect();
            e.printStackTrace();
        }

        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        while (true) {
            try {
                buffer.clear();
                socketChannel.read(buffer);
                buffer.flip();
                String msg = new String(buffer.array()).substring(0, buffer.limit());
                if (!msg.isEmpty()) {
                    AsyncChat2.updateChatText(msg);
                }
            } catch (IOException ignored) {
                try {
                    disconnect();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void disconnect() {
        try{
            if(serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        try{
            if(socketChannel != null) {
                socketChannel.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
