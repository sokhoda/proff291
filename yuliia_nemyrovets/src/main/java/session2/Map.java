package session2;

import java.util.HashMap;

/**
 * Created by Юлия on 20.12.2015.
 */
public class Map {
    public static void main(String [] args){
        HashMap<Integer,String> map= new HashMap<>();
        map.put(1,"1");
        map.put(1,"one");
        map.put(2,"2");
        String val=map.get(2);
        map.values();
        //Set<Map.Entry<Integer,String>> entries=map.entrySet();


        System.out.println(val);
    }
}
