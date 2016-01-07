package hw4.chat;

import javafx.application.Platform;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Вадим on 07.01.2016.
 */
public class ChatThread extends Thread {
    private SocketChannel socketChannel;

    public ChatThread(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ByteBuffer buf = ByteBuffer.allocate(100);
                buf.flip();
                StringBuilder sb = new StringBuilder();
                while(socketChannel.read(buf) > 0) {
                    sb.append(buf.asCharBuffer().toString());
                }
                String msg = sb.toString();
                if (!msg.isEmpty()) {
                    msg = "[Other user:]\n" + msg;
                    AsyncChat.updateChatText(msg);
                }
            } catch (IOException ignored) {
                try {
                    socketChannel.close();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
