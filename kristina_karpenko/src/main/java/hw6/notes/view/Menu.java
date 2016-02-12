package hw6.notes.view;


import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;
import java.util.Date;


public class Menu {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);

        notebookDao.create(new Notebook("1234","ss121","Samsung",new Date(), 5000));

    }
void deleteByModel(){}
    void showByVendor(){}
    void showByPriceManufDate(double price, Date manufDate){}
    void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {}
}
