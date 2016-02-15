package hw6.notes;

import hw6.notes.domain.Notebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.GregorianCalendar;

/**
 * Created by s_okhoda on 09.02.2016.
 */
public class test {

    public static String checkDate(GregorianCalendar gc) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        if (gc == null) {
            return "null";
        }
        else {
            return format1.format(gc.getTime());
        }
    }

    public static GregorianCalendar String2Gregorian(String dateStr) throws ParseException{
        if (dateStr == null || dateStr.length() == 0){
            return  null;
        }
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        date = df.parse(dateStr);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return (GregorianCalendar) cal;
    }

    public static void main(String[] args)  {
        Notebook n = new Notebook();


       char c1 = 064770;
//        char c2 = 'face';
         char c3 = 0xbeef;
//        int myList [] = {4, 3, 7};
//        int myList [] [] = {4,9,7,0};
        int [] myList = (5,8,2);

//        char c4 = \u0022;
//         char c5 = '\iface';
         char c6 = '\uface';


        Long i;
        Double d,d2;
        Integer f;
        i = new Long(10);
            System.out.println(n.toString());

        System.out.println(checkDate(new GregorianCalendar()));

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = df.parse("25.12.1991");
            Calendar cal = new GregorianCalendar(); //Calendar.getInstance();
            cal.setTime(date);
            System.out.println(df.format(cal.getTime()));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
