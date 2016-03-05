package Scrum.controller.Service;

/**
 * Created by Solyk on 05.03.2016.
 */
public class ServiceImpl implements Service {
    @Override
    public String[] stringToArray(String string) {
        return new String[0];
    }

    @Override
    public Integer sum(String[] strings) {
        return null;
    }

    @Override
    public String revers(String[] strings) {
        return null;
    }

    @Override
    public String random(String[] strings) {
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
