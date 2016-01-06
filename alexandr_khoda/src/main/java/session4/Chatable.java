package session4;

import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by s_okhoda on 30.12.2015.
 */
public interface Chatable {
    static final int BuffSize = 100;
    final String ExitWord = "@exit";

    default  String getAddress(AbstractSelectableChannel sc) {
        if (sc instanceof SocketChannel) {
            SocketChannel sc1;
            sc1 = ((SocketChannel) sc);
            return "remote: " + sc1.socket().getRemoteSocketAddress().toString() +
                    "; local: " + sc1.socket().getLocalSocketAddress().toString();
        }
        if (sc instanceof ServerSocketChannel) {
            ServerSocketChannel sc1;
            sc1 = ((ServerSocketChannel) sc);
            return "local: " + sc1.socket().getLocalSocketAddress().toString();
        }
        return "";

    }

    default String buffToString(ByteBuffer b, int readBytesNum) {
        if (b == null || readBytesNum <= 0) {
            return "";
        }
        return new String(b.array(), 0, readBytesNum);
    }
}
