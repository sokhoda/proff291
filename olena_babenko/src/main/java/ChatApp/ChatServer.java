package ChatApp;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by lenchi on 13.01.16.
 */
public class ChatServer extends ChatConnection {
    private int port;

    public ChatServer(int port, Consumer<Serializable> onReceiveCallBack) {
        super(onReceiveCallBack);
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
