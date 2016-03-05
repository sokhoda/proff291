package Session17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пк2 on 05.03.2016.
 */
public class Service {
    public List<Integer> StrToArr(String aString) /*throws NotAnIntegerException*/{
        ArrayList<Integer> aList= new ArrayList<>();
        String[] strArr=aString.split("");
        for(int i=0; i<strArr.length; i++){
            int temp=Integer.parseInt(strArr[i]);
            aList.add(temp);
        }
        return aList;
    }

    public String ArrToString(List aList){
        String resString=new String(" ");
        for(int i=0; i<aList.size(); i++){
            resString=resString+aList.get(i);
        }
        return resString;
    }
}
