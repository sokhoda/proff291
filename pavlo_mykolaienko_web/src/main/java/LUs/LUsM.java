package LUs;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Павло on 22.01.2016.
 */
public class LUsM {
    public static Map<String, String> mu = new TreeMap<String, String>();

    LUsM() {
        mu.put("a1", "1");
        mu.put("a2", "2");
        mu.put("a3", "3");
    }

    public static boolean add(String l, String p) {
        if (l.length() > 0 || p.length() > 0) {
            for (String s : mu.keySet()) {
                if (s.equals(l)) {
                    return false;
                }
            }
            mu.put(l, p);
            return true;
        }
        return false;
    }

    public boolean verify(String l, String p) {
        if (l.length() > 0 || p.length() > 0) {
            for (String s : mu.keySet()) {
                if (s.equals(l)) {
                    if (p.equals(mu.get(s))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
