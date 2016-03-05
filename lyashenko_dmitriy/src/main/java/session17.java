import java.util.Arrays;

/**
 * Created by Solyk on 05.03.2016.
 */
public class session17 {

    public static Integer sum(String string){
        String [] array = string.split("[ ]+");
        Integer temp = 0;
        try{
            for (int i = 0; i < array.length; i++){
                temp += Integer.valueOf(array[i]);
            }
            return temp;
        } catch (Exception e){
            return null;
        }
    }

//    public static String revers(String string){
//        String [] array = string.split("[?><.,:;}{!@#$%^&*()A-Za-z ]+");
//        String temp = "";
//            for (int i = array.length - 1 ; i >= 0; i--){
//                temp += array[i];
//            }
//            return temp;
//    }
    public  static String[] revers(String[] strings) {
        String[] temp = new String[strings.length];
        for (int i = 0; i < 0; i++) {
            temp[i] = strings[(strings.length - 1) - i];
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] o = {"3","4","7","8","7","9"};

        System.out.println(Arrays.toString(revers(o)));
    }

}
