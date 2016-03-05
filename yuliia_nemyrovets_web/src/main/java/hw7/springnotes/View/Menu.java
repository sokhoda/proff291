//package hw7.springnotes.View;
//
//import hw7.springnotes.service.NotebookServiceImpl;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Locale;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//public class Menu {
//    public static void main(String[] args) {
//        Locale.setDefault(Locale.ENGLISH);
//
//        ApplicationContext cont = new ClassPathXmlApplicationContext("hw7/context.xml");
//        NotebookServiceImpl ntb = cont.getBean("ser", NotebookServiceImpl.class);
//        // NotebookServiceImpl ntb = new NotebookServiceImpl();
////        Vendor vendor = new Vendor("Japan");
////        Memory memory = new Memory(vendor, (long) 500);
////        CPU cpu = new CPU("Intel", "1.8", "2-core", vendor);
////        Notebook notebook = new Notebook(vendor, cpu, memory, "Lenovo", 50000);
////
////        ntb.createNotebook(notebook);
//
//    }
//}
