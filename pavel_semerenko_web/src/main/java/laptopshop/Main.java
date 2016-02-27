package laptopshop;

import laptopshop.domain.Laptop;
import laptopshop.service.LaptopService;
import laptopshop.service.LaptopServiceImpl;
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

        Laptop laptop = new Laptop();
        laptop.setModel("test");
        laptopService.create(laptop);

        System.out.println(laptopService.findAll());
    }
}
