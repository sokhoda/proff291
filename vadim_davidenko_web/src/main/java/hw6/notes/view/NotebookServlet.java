package hw6.notes.view;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by v.davidenko on 08.02.2016.
 *
 * - Добавить новый ноутбук
 * - Изменить цену ноутбука по id
 * - Изменить серийный номер и производителя по id
 *
 * - Удалить ноутбук по id
 * - Удалить ноутбуки по названию модели
 *
 * - Показать список ноутбуков (включая порядковый номер id)
 * - Получить ноутбуки по производителю
 * - Получить ноутбуки по цене и году выпуска
 * - Получить ноутбуки по цене в указанном диапазоне,
 *      меньше указанной даты выпуска и указанного производителя
 *
 */

@WebServlet("/notebookServlet")
public class NotebookServlet extends HttpServlet {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
    NotebookService noteService = new NotebookServiceImpl(noteDao);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        main(req, resp);

    }

    public void main(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String ADD_NEW = "1";
        final String EDIT_PRICE = "2";
        final String EDIT_SERIAL_VENDOR = "3";
        final String DELETE_BY_ID = "4";
        final String DELETE_BY_MODEL = "5";
        final String SHOW_ALL = "6";
        final String SHOW_VENDOR = "7";
        final String SHOW_BY_PRICE_AND_DATE = "8";
        final String SHOW_BY_PRICE_RANGE_AND_VENDOR_AND_DATE_BEFORE = "9";

        Map<String, String[]> parameterMap = req.getParameterMap();
        if (!parameterMap.containsKey("menuOption")){
            //addNew(req, resp);
            return;
        }
        String option = parameterMap.get("menuOption")[0];

        switch (option) {
            case ADD_NEW:

                break;
            case EDIT_PRICE:

                break;
            case EDIT_SERIAL_VENDOR:

                break;
            case DELETE_BY_ID:

                break;
            case DELETE_BY_MODEL:

                break;
            case SHOW_ALL:

                break;
            case SHOW_VENDOR:

                break;
            case SHOW_BY_PRICE_AND_DATE:

                break;
            case SHOW_BY_PRICE_RANGE_AND_VENDOR_AND_DATE_BEFORE:

                break;
            default:
        }

    }



    public void changePrice(Notebook notebook) {

    }

    public void changeSerialVendor(Notebook notebook) {

    }


    public void deleteNtb(Notebook notebook) {

    }

    public void deleteByModel() {

    }


    public void showByVendor() {

    }

    public void showByPriceManufDate(double price, Date manufDate) {

    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {

    }

}
