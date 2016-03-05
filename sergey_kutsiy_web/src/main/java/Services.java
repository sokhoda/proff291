import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 05.03.2016.
 */
public class Services {

    public ArrayList<Integer> StrToArr(String aString) /*throws NotAnIntegerException*/{
        ArrayList<Integer> aList= new ArrayList<>();
        String[] strArr=aString.split(" ");
        for(int i=0; i<strArr.length; i++){
            try {
                int temp = Integer.parseInt(strArr[i]);
                aList.add(temp);
            } catch(NumberFormatException nfe){
                throw new NumberFormatException();
            }

        }
        return aList;
    }

    public  String ArrToStr(List aList){
        String resString=new String(" ");
        for(int i=0; i<aList.size(); i++){
            resString=resString+aList.get(i)+" ";
        }
        return resString;
    }
    public  Integer Sum (ArrayList<Integer> aList){
        Integer sum=0;
        if(!aList.isEmpty()) {
            for (int i = 0; i < aList.size(); i++) {
                sum = sum + aList.get(i);
            }
        }
        return sum;
    }
}
