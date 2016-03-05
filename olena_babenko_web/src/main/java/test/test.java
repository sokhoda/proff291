package test;

import scala.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lenchi on 05.03.16.
 */
public class test {


    public List<String> reverse(String text){
        List<String> list = Arrays.asList(text.split(" "));
        Collections.reverse(list);
        return list;
    }

    public Integer sum (String text) {
        int sum = 0;
        List<String> list = Arrays.asList(text.split(" "));
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }



    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.sum("1 2 3"));
    }
}
