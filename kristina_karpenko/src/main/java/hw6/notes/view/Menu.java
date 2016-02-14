package hw6.notes.view;


import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;
import java.util.Date;


public class Menu {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        NotebookService notebookService = new NotebookServiceImpl();
       // notebookService.add(new Notebook("1212",5000D,"2121","222",new Date()));
        notebookDao.create(new Notebook("1234","ss121","Samsung",new Date(), 5000));
      // notebookDao.create(new Notebook("1212",5000D,"2121","222",new Date()));
       // notebookDao.update(new Notebook(1L,"1212","2121","222",new Date(),5000));
        sessionFactory.close();
    }
void deleteByModel(){}
    void showByVendor(){}
    void showByPriceManufDate(double price, Date manufDate){}
    void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {}
}
