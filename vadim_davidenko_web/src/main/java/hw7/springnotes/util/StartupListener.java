package hw7.springnotes.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

/**
 * Created by v.davidenko on 22.02.2016.
 */
public class StartupListener implements ServletContextListener {
    public static ApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Locale.setDefault(Locale.ENGLISH);
        context = new ClassPathXmlApplicationContext("hw7/context.xml");
    }

    public static <T>T getBean(String bean, Class<T> clazz){
        return context.getBean(bean, clazz);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
