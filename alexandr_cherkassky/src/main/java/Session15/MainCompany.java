package Session15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class MainCompany {
    public static void main(String [] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("Session15/compContext.xml");
        //Company aCompany=context.getBean("company", Company.class);
        CEO aCeo=context.getBean("CEO1",CEO.class);
         System.out.println(aCeo);

    }
}
