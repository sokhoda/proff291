package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pavel on 20.12.2015.
 */
public class MapTask {
    public static void run() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "2");
        map.put(1, "4");
        map.put(2, "4");

        map.keySet();
        map.values();

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);
        System.out.println(map);
    }
}
