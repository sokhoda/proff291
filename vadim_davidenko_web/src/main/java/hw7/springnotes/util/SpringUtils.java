package hw7.springnotes.util;

import hw7.springnotes.service.NotebookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Вадим on 21.02.2016.
 */
public class SpringUtils {

    public static NotebookService createNotebookService() {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/context.xml");
        return context.getBean("notebookService", NotebookService.class);
    }
}
