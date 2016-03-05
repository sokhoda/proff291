package Controller_old;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lenchi on 22.01.16.
 */
public class AccountService {
    public Map<String,String> map = new HashMap<>();

    //-----------Registration and Authentication methods--------------------------------------------------------

    public boolean Registration(String login, String password, Map<String, String> userMap) throws IOException {
        if (userMap.containsKey(login)) {
            return false;
        } else {
            userMap.put(login, setPasswordMD5(password));
            putMapToFile(userMap);
            return true;
        }
    }

    public boolean Authentication(String login, String password, Map<String, String> userMap) throws IOException {
        getMapFromFile(userMap);
        if (userMap.containsKey(login) && ((String) userMap.get(login)).equals(setPasswordMD5(password))) {
            return true;
        } else {
            return false;
        }
    }

    //----------Other methods-----------------------------------------------------------------------------------

    public String setPasswordMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void putMapToFile(Map<String, String> map) throws IOException {
        Properties properties = new Properties();
        Path file = Paths.get("olena_babenko.userLoginPass");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream(file.toFile()), null);
    }

    public Map<String, String> getMapFromFile(Map<String, String> map) throws IOException {
        Properties properties = new Properties();
        Path file = Paths.get("olena_babenko.userLoginPass");
        properties.load(new FileInputStream(file.toFile()));

        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.get(key).toString());
        }
        return map;
    }
}
