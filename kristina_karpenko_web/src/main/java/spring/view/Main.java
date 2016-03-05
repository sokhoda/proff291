package spring.view;

import org.hibernate.annotations.SourceType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session16.ses15.dao.EmployeeDao;
import session16.ses15.domain.Employee;
import spring.service.NotebookService;
import spring.service.NotebookServiceImpl;

import java.util.Locale;

/**
 * Created by Администратор on 27.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext cont = new ClassPathXmlApplicationContext("spring.notes/context-db.xml");


        NotebookService notebookService = cont.getBean("service", NotebookServiceImpl.class);
        System.out.print(notebookService.getNotebooksGtAmount(2).toString());
    }
}
