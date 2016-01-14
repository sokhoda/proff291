package session4;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import org.apache.commons.codec.binary.Hex;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;

/**
 * Created by s_okhoda on 30.12.2015.
 */
public interface Chatable {
    final int ListenOnPortDefault = 30005;
    final int SendToPortDefault = 30004;
    final String IpAddressDefault = "127.0.0.1";
    final int MinPortNumber = 0;
    final int MaxPortNumber = 65535;

    final int MinIpNumber = 0;
    final int MaxIpNumber = 255;

    static final int BuffSize = 300;
    final String ExitWord = "@exit";
    final String ConnectText = "Connect";
    final String DisconnectText = "Disconnect";
    final String DisconnectMessage = ("\nConnection is closed. Thank you " +
            "for using this chat.\n").toUpperCase();
    final String Delimiter = String.valueOf((char)(19));
    final int SleepTime = 250;

    default void setStyleText(Node node, int FontSize, String textColor) {
        node.setStyle("-fx-font-weight: bold; -fx-font-size: " + FontSize
                + "pt; -fx-text-inner-color: " + textColor);
    }

    default boolean checkServerSocketBound(ServerSocketChannel ch, String
            ip, int port) {
        if (ch == null || !ch.socket().isBound() || ip == null || ip.length() ==
                0)
            return false;

        if (ch.socket().getLocalSocketAddress().equals(new InetSocketAddress
                (ip, port))) {
            return true;
        }
        else {
            return false;
        }
    }

    default void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message);
        alert.show();
//        alert.showAndWait().ifPresent(response -> {
//            if (response == ButtonType.OK) {
//                alert.close();
//            }
//        });

    }

    default String getAddress(AbstractSelectableChannel sc) {
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

    default int checkIntValue(String name, String value, int minValue,
                              int maxValue) throws NumberFormatException {
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(name + " has not valid " +
                    "value: \"" + value + "\"");
        }
        if (portNumber > maxValue || portNumber < minValue) {
            throw new NumberFormatException(name + " has not valid " +
                    "value: \"" + value + "\"");
        }
        else {
            return portNumber;
        }
    }

    default String checkIPaddressValue(String name, String value) throws
            NumberFormatException {
        String[] address = {""};

        value = value.trim();
        address = value.split("\\.");
        if (address.length != 4) {
            throw new NumberFormatException(name + " has not valid " +
                    "value: \"" + value + "\"");
        }
        else {
            int i = 0;
            while (i < address.length) {
                if (checkIntValue(name, address[i++], MinIpNumber,
                        MaxIpNumber) == -1) {
                    return "";
                }
            }
            return value;
        }

    }

}
