package hw7.springnotes;


import hw7.springnotes.service.NotebookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Locale;

/**
 * Created by Solyk on 29.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext con = new ClassPathXmlApplicationContext("hw7.springnotes.context.xml");
        NotebookService notebookService = con.getBean("NotebookService", NotebookService.class);
    }
}
