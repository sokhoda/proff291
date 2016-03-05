package Session17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Пк2 on 05.03.2016.
 */
public class Service {
    public static ArrayList<Integer> StrToArr(String aString) /*throws NotAnIntegerException*/{
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

    public static String ArrToStr(List aList){
        String resString=new String(" ");
        for(int i=0; i<aList.size(); i++){
            resString=resString+aList.get(i)+" ";
        }
        return resString;
    }

    public static Integer Sum(ArrayList<Integer> aList){
        Integer sum=0;
        if(!aList.isEmpty()) {
            for (int i = 0; i < aList.size(); i++) {
                sum = sum + aList.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println("Enter String");
        Scanner scan= new Scanner(System.in);
        ArrayList<Integer> tryList=new ArrayList<>();
        tryList=StrToArr(scan.nextLine());
        String tryString=ArrToStr(tryList);
        System.out.println("You entered:");
        System.out.println(tryString);
        System.out.println("sum:");
        System.out.println(Sum(tryList));


    }
}
