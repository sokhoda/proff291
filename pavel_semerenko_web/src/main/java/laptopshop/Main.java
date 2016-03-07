package laptopshop;

import laptopshop.service.LaptopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Pavel on 18.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        ApplicationContext cont = new ClassPathXmlApplicationContext("laptopshop/context.xml");
        LaptopService laptopService = cont.getBean("laptopServiceImpl", LaptopService.class);

    }
}
