package StrategiChengeLetter;

/**
 * Created by Павло on 27.12.2015.
 */


interface Chengeletters {
    public void name();

    public Object mettodWord(Object o);
}

class ChengLetter implements Chengeletters {
    public void name() {
        System.out.println(getClass().getSimpleName());
    }

    public Object mettodWord(Object o) {
        String s = (String) o;
        String s1 = "";
        for (int i = 0; i < s.length(); i = i + 2) {
            int r = i + 1;
            if (r < s.length()) {
                s1 = s1 + s.substring(i + 1, i + 2) + s.substring(i, i + 1);

            }

        }


        return s1;
    }
}


public class StrategiChengeLetter {

    public static void main(String[] args) {
        String s = "qwertyuiopasdfghjklzxcvbnm";
        StrategiChengeLetter sc = new StrategiChengeLetter();
        sc.chenge(new ChengLetter(), s);
    }

    public void chenge(Chengeletters o, String s) {
        o.name();
        System.out.println(o.mettodWord(s));


    }

}

