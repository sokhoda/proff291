package hw3.chat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by s_okhoda on 05.01.2016.
 */
public class CheckSyntax {
    public static void main(String[] args){
        Random rnd = new Random();
        String s = "ddf1";
        System.out.println(s);
        s = s.replaceAll("\\d","2");
        System.out.println(s);
        System.out.println( String.valueOf((char)(19)));
        Character c= new Character ((char)(55));
        String Delimiter = String.valueOf((char)(19));
        String s2 = Delimiter + "Client2";
        System.out.println(s2.indexOf(Delimiter));
        System.out.println(s2.split(Delimiter)[0]);//+ "\n" + s2.split

        ArrayList list = new ArrayList(Arrays.asList(1,2,3,5,6,7,8));
        System.out.println(list.toString());

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(format1.format(gc.getTime()) + " curDate " + (int)
                (-1.99));

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        // (Delimiter)[1]) ;
//                        Integer.toString(rnd.nextInt())));
    }
}
