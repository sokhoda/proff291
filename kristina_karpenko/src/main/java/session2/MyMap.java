package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//переделать пред задание с помощью хешмап
/**
 * Created by Администратор on 20.12.2015.
 */
public class MyMap {

  public  static void  main(String[] args){
      HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"wee");
        map.put(1,"ew");
        map.put(2,"232");
      System.out.println(map.keySet());
          String s = map.get(2);
      System.out.println(map);
      System.out.println(s);


      Set<Map.Entry<Integer,String>> entr = map.entrySet();//множество пар
  }
}
