package agile.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 15.11.15
 */
public class Main {
    public static void main(String[] args) {

        NumberService serv=new NumberServiceImpl();
        String text=("1 2 3 4 5");

        System.out.println("text "+ text);
        System.out.println("shuffle "+serv.shuffle(text));

        System.out.println("text "+ text);
        //System.out.println("shuffle "+serv.(text));

        
        System.out.println("text "+ text);
        System.out.println("shuffle "+serv.shuffle(text));

}
}
