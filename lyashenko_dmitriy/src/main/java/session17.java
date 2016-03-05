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

    public static String revers(String string){
        String [] array = string.split("[?><.,:;}{!@#$%^&*()A-Za-z ]+");
        String temp = "";
            for (int i = array.length - 1 ; i >= 0; i--){
                temp += array[i];
            }
            return temp;
    }



    public static void main(String[] args) {
        String o = "1 3 4 5 6 7 0";
        System.out.println(sum(o));
        System.out.println(revers(o));
    }

}
