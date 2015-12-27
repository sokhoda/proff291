package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Solyk on 19.12.2015.
 */
public class Iteratorr {
    public static void main(String[] args){

        List<Integer> list = new ArrayList(Arrays.asList(1,3,4,5,6,7,8));
        Iterator u = list.iterator();

        while(u.hasNext()){

            int tmp = (int)u.next();

            if(tmp % 2 != 0){
               u.remove();
            }

        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println(list);
    }
}
