package ChatApp;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by lenchi on 13.01.16.
 */
public class ChatClient extends ChatConnection {
    private String ip;
    private int port;

    public ChatClient(String ip, int port, Consumer<Serializable> onReceiveCallBack) {
        super(onReceiveCallBack);
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return ip;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
