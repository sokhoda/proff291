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
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
            AsyncChat2.updateChatText("Server started on port " + port);
            socketChannel = serverSocketChannel.accept();
        } catch (IOException e) {
            disconnect();
            e.printStackTrace();
        }
        ByteBuffer buf = ByteBuffer.allocate(100);
        while (true) {
            try {
                StringBuilder sb = new StringBuilder();
                buf.clear();
                while(socketChannel.read(buf) > 0) {
                    sb.append(buf.asCharBuffer().toString());
                }
                String msg = sb.toString();
                if (!msg.isEmpty()) {
                    msg = "[Other user:]\n" + msg;
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
