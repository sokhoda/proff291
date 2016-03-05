package SpringLesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenchi on 20.02.16.
 * ЗАДАНИЕ
 Создать класс (компания, директор, автомобиль)
 в компании есть директор, в компании есть автомобиль, директор ездит в автомобиле

 Сompany, Director, Car.java and contextAnnotation.xml files
 */
public class Main_Company {
    public static void main(String[] args) {
        ApplicationContext cont = new ClassPathXmlApplicationContext("SpringLesson/context1.xml");

        Company company = cont.getBean("company1", Company.class);
        Director director = cont.getBean("director1", Director.class);
        System.out.println(company);
        System.out.println(director);
    }
}
