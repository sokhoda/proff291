package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Home on 19.12.2015.
 */
public class IteratorList {
    public static void main(String[] args) {
        //  ArrayList<Integer> list = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            if (it.next() % 2 != 0) {
                it.remove();
             //   it.next();
            }
        }
        System.out.println(list.toString());
    }
}

