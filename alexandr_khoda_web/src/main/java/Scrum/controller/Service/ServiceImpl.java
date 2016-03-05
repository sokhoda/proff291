package Scrum.controller.Service;

import Scrum.exception.StringDataException;
import java.util.Random;

/**
 * Created by Solyk on 05.03.2016.
 */
public class ServiceImpl implements Service {


    @Override
    public boolean validateString(String string) throws StringDataException {
        try{
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e){
            throw new StringDataException("String not valid.");
        }
    }
    @Override
    public String[] stringToArray(String string) throws StringDataException {
       boolean res =  validateString(string);
        if(res) {
            String[] array = string.split("[ ]+");
            return array;
        }
        else {
            return null;
        }
    }

    @Override
    public String sum(String[] strings) {
        int tmp = 0;
        for (int i = 0; i < strings.length; i++ ){
            tmp += Integer.valueOf(strings[i]);
        }
        String tt = "";
        tt += tmp;
        return tt;
    }

    @Override
    public String revers(String[] strings) {
        String[] temp = new String[strings.length];
        for (int i = 0; i < 0; i++){
            temp[i] = strings[(strings.length - 1) - i];
        }
        return arrToStr(temp);
    }

    @Override
    public String random(String[] strings) {

            Random rnd = new Random();
            for (int i = strings.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                String a = strings[index];
                strings[index] = strings[i];
                strings[i] = a;

        }
         return arrToStr(strings);
    }

    @Override
    public String arrToStr(String[] str) {
        String string = "";
       for(int i = 0; i < str.length; i++){
           if(i == str.length - 1)
           {
               string = string + str[i];

           } else {
               string = string + str[i] + " ";
           }
       }
       return string;
    }


}
