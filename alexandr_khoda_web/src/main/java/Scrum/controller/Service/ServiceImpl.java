package Scrum.controller.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Solyk on 05.03.2016.
 */
public class ServiceImpl implements Service {



    @Override
    public String[] stringToArray(String string) {

        String [] array = string.split("[ ]+");
        return array;
    }

    @Override
    public Integer sum(String[] strings) {
        int tmp = 0;
        for (int i = 0; i < strings.length; i++ ){
            tmp += Integer.valueOf(strings[i]);
        }
        return tmp;
    }

    @Override
    public String revers(String[] strings) {
        String temp = "";
        for (int i = strings.length - 1 ; i >= 0; i--){
            temp += strings[i] + " ";
        }
        return temp;
    }

    @Override
    public String random(String[] strings) {
        List<String> tepmArray = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++){
            tepmArray.add(strings[i]);
        }

        return null;
    }

    @Override
    public String ArrToStr(String[] str) {
        String string="";
       for(int i =0; i<str.length;i++){
           string = string+ str[i]+" ";
       }
       return string;
    }


}
