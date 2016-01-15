package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Юлия on 19.12.2015.
 */
public class Task1 {
    public static void main(String [] args){
       ArrayList<Integer> list=new ArrayList(Arrays.asList(1,2,3,4,5,6,7));
        Iterator<Integer> iter=list.iterator() ;
        Integer n;

        while (iter.hasNext()){
            n=iter.next();
            if(n%2!=0){
            iter.remove();

        }
        }
        System.out.println(list);
    }
}
