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
        SessionFactory factory = HibernateUtil.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(factory);


        notebookDao.create(new Notebook("1234","ss121","Samsung",new Date(), 5000));

        factory.close();
    }
void deleteByModel(){}
    void showByVendor(){}
    void showByPriceManufDate(double price, Date manufDate){}
    void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {}
}
