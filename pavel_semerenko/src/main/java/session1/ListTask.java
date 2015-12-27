package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Pavel on 19.12.2015.
 */
public class ListTask {

    public static void run(){
        List<Integer> list;
        Iterator iterator;
        Integer[] array = new Integer[100];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 100);
        list = new ArrayList<Integer>(Arrays.asList(array));
        iterator = list.iterator();
        while(iterator.hasNext()){
            if(Math.abs((Integer) iterator.next()) % 2 == 1)
                iterator.remove();
        }
        System.out.println(list);
    }
}
