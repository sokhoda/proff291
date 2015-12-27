package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Администратор on 19.12.2015.
 */
//создать список целый чисел. любой длинны с люб значениями. Удалить из списка нечетные элементы.
public class task {
    public static void main(String []args ){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,6,3,6,9,0,2,1,5,8,5));

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            Integer n = iter.next();
            if(n % 2 == 0) continue;
                iter.remove();
              System.out.println(n);
                   }

        System.out.println(list);

    }
}
