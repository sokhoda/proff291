package trash;

/**
 * Created by Юра on 12.01.2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

public class NetworkUtil {

    public static void main(String[] args) throws Exception {
        System.out.println(getLocalAddress().toString());
        System.out.println(getCurrentIP());
    }

    public static InetAddress getLocalAddress()  {
        List<NetworkInterface> netInts = null;
        try {
            netInts = Collections.list(NetworkInterface.getNetworkInterfaces());
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // there is a simple method, but it works sometimes
        // incorrectly when there are several network interfaces
//        System.out.println("size ="+netInts.size());
//        System.out.println(InetAddress.getLocalHost());
        if (netInts.size() == 1) {
            System.out.println("size ="+netInts.size());
            try {
                return InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        for (NetworkInterface net : netInts) {
            try {
                if (!net.isLoopback() && !net.isVirtual() && net.isUp()) {
                    Enumeration<InetAddress> addrEnum = net.getInetAddresses();
                    while (addrEnum.hasMoreElements()) {
                        InetAddress addr = addrEnum.nextElement();
                        // filter out addresses, which cannot be considered as the main address
                        // and return the first suitable address
                        if ( !addr.isLoopbackAddress() && !addr.isAnyLocalAddress()
                                && !addr.isLinkLocalAddress() && !addr.isMulticastAddress()
                                ) {
                            return addr;
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        // we can fall here if there are no suitable addresses/interfaces
        // or we don't have enough permissions
        return null;
    }
    public static String getCurrentIP() {
        String result = null;
        try {
            BufferedReader reader = null;
            try {
                URL url = new URL("http://myip.by/");
                InputStream inputStream = null;
                inputStream = url.openStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder allText = new StringBuilder();
                char[] buff = new char[1024];

                int count = 0;
                while ((count = reader.read(buff)) != -1) {
                    allText.append(buff, 0, count);
                }
// Строка содержащая IP имеет следующий вид
// <a href="whois.php?127.0.0.1">whois 127.0.0.1</a>
                Integer indStart = allText.indexOf("\">whois ");
                Integer indEnd = allText.indexOf("</a>", indStart);

                String ipAddress = new String(allText.substring(indStart + 8, indEnd));
                if (ipAddress.split("\\.").length == 4) { // минимальная (неполная)
                    //проверка что выбранный текст является ip адресом.
                    result = ipAddress;
                }
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
