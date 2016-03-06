package hw7.notes.util;

import java.util.List;

/**
 * Created by Администратор on 19.02.2016.
 */
public class Formater {

    public static String getString(List<Object[]> list) {
        String res = "size: " + list.size() + "\n";
        for (Object[] array : list) {
            for (Object el : array) {
                res += el + ", ";
            }
            res += "\n-------------------------------------------------------------------------------------------" +
                    "----------------\n";
        }
        return res;
    }
}
