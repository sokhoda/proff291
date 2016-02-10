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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

 */

@WebServlet("/notebookServlet")
public class Menu extends HttpServlet {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
    NotebookService noteService = new NotebookServiceImpl(noteDao);
    List<Notebook> notesList;
    String serverMsg, serverErrMsg;

    final static String NOTE_ADDED_MSG = "New notebook added to reference";
    final static String NOTE_EXISTS_MSG = "Such notebook already exists";
    final static String NOTE_UPDATED_MSG = "Notebook data updated successfully";
    final static String NOTE_DELETED_MSG = "Notebooks removed from reference";
    final static String NO_RECORDS_FOUND_MSG = "No records found";
    final static String MENU_PAGE = "menu.jsp";

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
        serverMsg = "";
        serverErrMsg = "";
        Notebook note = new Notebook();

        if (!parameterMap.containsKey("menuOption")){
            note.setModel(parameterMap.get("model")[0].trim());
            note.setVendor(parameterMap.get("vendor")[0].trim());
            note.setSerial(parameterMap.get("serial")[0].trim());
            Date date = stringToDate(parameterMap.get("date")[0].trim(), "dd.MM.yyyy");
            note.setManufactureDate(date);
            String price = parameterMap.get("price")[0];
            note.setPrice((!price.equals("")) ? Double.valueOf(price) : 0.00);

            addNtb(note);

            req.setAttribute("server_msg", serverMsg);
            req.setAttribute("server_err_msg", serverErrMsg);
            req.getRequestDispatcher(MENU_PAGE).forward(req, resp);

            return;
        }

        String option = parameterMap.get("menuOption")[0];
        String id_2 = parameterMap.get("id_2")[0].trim();
        String price_2 = parameterMap.get("price_2")[0].trim();
        String id_3 = parameterMap.get("id_3")[0].trim();
        String serial_3 = parameterMap.get("serial_3")[0].trim();
        String vendor_3 = parameterMap.get("vendor_3")[0].trim();
        String id_4 = parameterMap.get("id_4")[0].trim();
        String model_5 = parameterMap.get("model_5")[0].trim();
        String vendor_7 = parameterMap.get("vendor_7")[0].trim();
        String price_8 = parameterMap.get("price_8")[0].trim();
        String date_8 = parameterMap.get("date_8")[0].trim();
        String priceFrom = parameterMap.get("priceFrom")[0].trim();
        String priceTo = parameterMap.get("priceTo")[0].trim();
        String date_9 = parameterMap.get("date_9")[0].trim();
        String vendor_9 = parameterMap.get("vendor_9")[0].trim();

        switch (option) {
            case ADD_NEW:
                break;
            case EDIT_PRICE:
                note.setId((!id_2.equals("")) ? Long.valueOf(id_2) : 0L);
                note.setPrice((!price_2.equals("")) ? Double.valueOf(price_2) : 0.00);
                changePrice(note);
                break;
            case EDIT_SERIAL_VENDOR:
                note.setId((!id_3.equals("")) ? Long.valueOf(id_3) : 0L);
                note.setSerial(serial_3);
                note.setVendor(vendor_3);
                changeSerialVendor(note);
                break;
            case DELETE_BY_ID:
                note.setId((!id_4.equals("")) ? Long.valueOf(id_4) : 0L);
                deleteNtb(note);
                break;
            case DELETE_BY_MODEL:
                deleteByModel(model_5);
                break;
            case SHOW_ALL:
                showAll();
                break;
            case SHOW_VENDOR:
                showByVendor(vendor_7);
                break;
            case SHOW_BY_PRICE_AND_DATE:
                showByPriceManufDate((!price_8.equals("")) ? Double.valueOf(price_8) : 0.00,
                        stringToDate(date_8, "dd.MM.yyyy"));
                break;
            case SHOW_BY_PRICE_RANGE_AND_VENDOR_AND_DATE_BEFORE:
                showBetweenPriceLtDateByVendor((!priceFrom.equals("")) ? Double.valueOf(priceFrom) : 0.00,
                        (!priceTo.equals("")) ? Double.valueOf(priceTo) : 0.00,
                        stringToDate(date_9, "dd.MM.yyyy"), vendor_9);
                break;
            default:
        }

        req.setAttribute("menuOption", option);
        req.setAttribute("id_2", id_2);
        req.setAttribute("price_2", price_2);
        req.setAttribute("id_3", id_3);
        req.setAttribute("serial_3", serial_3);
        req.setAttribute("vendor_3", vendor_3);
        req.setAttribute("id_4", id_4);
        req.setAttribute("model_5", model_5);
        req.setAttribute("vendor_7", vendor_7);
        req.setAttribute("price_8", price_8);
        req.setAttribute("date_8", date_8);
        req.setAttribute("priceFrom", priceFrom);
        req.setAttribute("priceTo", priceTo);
        req.setAttribute("vendor_9", vendor_9);
        req.setAttribute("date_9", date_9);

        req.setAttribute("notesList", notesList);
        req.setAttribute("server_msg", serverMsg);
        req.setAttribute("server_err_msg", serverErrMsg);

        req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
    }

    // ------------------------------------------------------------- //
    public void addNtb(Notebook note) {
//        Long id = noteService.add(note);
//        if (id != null && !id.equals(0L)) {
//            serverMsg = NOTE_ADDED_MSG;
//        } else {
//            serverErrMsg = NOTE_EXISTS_MSG;
//        }
        serverMsg = NOTE_ADDED_MSG;
    }

    public void changePrice(Notebook note) {
//        noteService.changePrice(note.getId(), note.getPrice());
        serverMsg = NOTE_UPDATED_MSG;
    }

    public void changeSerialVendor(Notebook note) {
//        noteService.changeSerialVendor(note.getId(), note.getSerial(), note.getVendor());
        serverMsg = NOTE_UPDATED_MSG;
    }

    // ------------------------------------------------------------- //
    public void deleteNtb(Notebook note) {
//        if (noteService.delete(note.getId())) {
//            serverMsg = NOTE_DELETED_MSG;
//        } else {
//            serverErrMsg = NO_RECORDS_FOUND_MSG;
//        }
        serverMsg = NOTE_DELETED_MSG;
    }

    public void deleteByModel(String model) {
//        if (noteService.deleteByModel(model)) {
//            serverMsg = NOTE_DELETED_MSG;
//        } else {
//            serverErrMsg = NO_RECORDS_FOUND_MSG;
//        }
        serverMsg = NOTE_DELETED_MSG;
    }

    // ------------------------------------------------------------- //
    public void showAll() {
//        notesList = noteService.findAll();
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showByVendor(String vendor) {
//        notesList = noteService.findByVendor(vendor);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showByPriceManufDate(double price, Date manufDate) {
//        notesList = noteService.findByPriceManufDate(price, manufDate);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, String vendor) {
//        notesList = noteService.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    // ------------------------------------------------------------- //
    private static Date stringToDate(String dateInString, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
