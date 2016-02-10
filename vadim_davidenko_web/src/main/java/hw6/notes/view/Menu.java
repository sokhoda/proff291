package hw6.notes.view;

import hw6.notes.Main;
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
import java.util.Set;

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

    NotebookService noteService = Main.getInstance();
    List<Notebook> notesList;
    String serverMsg, serverErrMsg;

    final static String NOTE_ADDED_MSG = "New notebook added to reference";
    final static String NOTE_EXISTS_MSG = "Such notebook already exists";
    final static String NOTE_UPDATED_MSG = "Notebook data updated successfully";
    final static String NOTE_DELETED_MSG = "Notebooks removed from reference";
    final static String SOME_NOTE_NOT_EXIST_MSG = "Some notebook(s) does not exist";
    final static String NO_RECORDS_FOUND_MSG = "No records found";
    final static String MENU_PAGE = "menu.jsp";
    final static String ADD_NOTE_PAGE = "add_note.jsp";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        registrationService(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        menuService(req, resp);
    }

    public void registrationService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        serverMsg = "";
        serverErrMsg = "";
        Notebook note = new Notebook();

        note.setModel(parameterMap.get("model")[0].trim());
        note.setVendor(parameterMap.get("vendor")[0].trim());
        note.setSerial(parameterMap.get("serial")[0].trim());
        Date date = stringToDate(parameterMap.get("date")[0].trim(), "dd.MM.yyyy");
        note.setManufactureDate(date);
        String price = parameterMap.get("price")[0];
        note.setPrice(Double.valueOf(price));

        addNtb(note);

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        req.setAttribute("server_msg", serverMsg);
        req.setAttribute("server_err_msg", serverErrMsg);

        req.getRequestDispatcher(ADD_NOTE_PAGE).forward(req, resp);
    }

    public void menuService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        serverMsg = "";
        serverErrMsg = "";

        if (parameterMap.get("menuOption")[0].equals("1")) {
            req.getRequestDispatcher(ADD_NOTE_PAGE).forward(req, resp);
            return;
        }
        main(parameterMap);

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        req.setAttribute("notesList", notesList);
        req.setAttribute("server_msg", serverMsg);
        req.setAttribute("server_err_msg", serverErrMsg);

        req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
    }

    public void main(Map<String, String[]> parameterMap) {

        final String EDIT_PRICE = "2";
        final String EDIT_SERIAL_VENDOR = "3";
        final String DELETE_BY_ID = "4";
        final String DELETE_BY_MODEL = "5";
        final String SHOW_ALL = "6";
        final String SHOW_VENDOR = "7";
        final String SHOW_BY_PRICE_AND_DATE = "8";
        final String SHOW_BY_PRICE_RANGE_AND_VENDOR_AND_DATE_BEFORE = "9";

        String option = parameterMap.get("menuOption")[0];
        Notebook note;

        switch (option) {
            case EDIT_PRICE:
                note = new Notebook();
                note.setId(Long.valueOf(parameterMap.get("id_2")[0].trim()));
                note.setPrice(Double.valueOf(parameterMap.get("price_2")[0].trim()));
                changePrice(note);
                break;

            case EDIT_SERIAL_VENDOR:
                note = new Notebook();
                note.setId(Long.valueOf(parameterMap.get("id_3")[0].trim()));
                note.setSerial(parameterMap.get("serial_3")[0].trim());
                note.setVendor(parameterMap.get("vendor_3")[0].trim());
                changeSerialVendor(note);
                break;

            case DELETE_BY_ID:
                note = new Notebook();
                note.setId(Long.valueOf(parameterMap.get("id_4")[0].trim()));
                deleteNtb(note);
                break;

            case DELETE_BY_MODEL:
                deleteByModel(parameterMap.get("model_5")[0].trim());
                break;

            case SHOW_ALL:
                showAll();
                break;

            case SHOW_VENDOR:
                showByVendor(parameterMap.get("vendor_7")[0].trim());
                break;

            case SHOW_BY_PRICE_AND_DATE:
                showByPriceManufDate(
                        Double.valueOf(parameterMap.get("price_8")[0].trim()),
                        stringToDate(parameterMap.get("date_8")[0].trim(), "dd.MM.yyyy")
                );
                break;

            case SHOW_BY_PRICE_RANGE_AND_VENDOR_AND_DATE_BEFORE:
                showBetweenPriceLtDateByVendor(
                        Double.valueOf(parameterMap.get("priceFrom")[0].trim()),
                        Double.valueOf(parameterMap.get("priceTo")[0].trim()),
                        stringToDate(parameterMap.get("date_9")[0].trim(), "dd.MM.yyyy"),
                        parameterMap.get("vendor_9")[0].trim()
                );
                break;
            default:
        }
    }

    public void addNtb(Notebook note) {
        Long id;
        synchronized (Menu.class) {
            id = noteService.add(note);
        }
        if (id != null && !id.equals(0L)) {
            serverMsg = NOTE_ADDED_MSG;
        } else {
            serverErrMsg = NOTE_EXISTS_MSG;
        }
    }

    public void changePrice(Notebook note) {
        synchronized (Menu.class) {
            noteService.changePrice(note.getId(), note.getPrice());
        }
        serverMsg = NOTE_UPDATED_MSG;
    }

    public void changeSerialVendor(Notebook note) {
        synchronized (Menu.class) {
            noteService.changeSerialVendor(note.getId(), note.getSerial(), note.getVendor());
        }
        serverMsg = NOTE_UPDATED_MSG;
    }

    public void deleteNtb(Notebook note) {
        Boolean isDeleted;
        synchronized (Menu.class) {
            isDeleted = noteService.delete(note.getId());
        }
        if (isDeleted) {
            serverMsg = NOTE_DELETED_MSG;
        } else {
            serverErrMsg = SOME_NOTE_NOT_EXIST_MSG;
        }
    }

    public void deleteByModel(String model) {
        Boolean isDeleted;
        synchronized (Menu.class) {
            isDeleted = noteService.deleteByModel(model);
        }
        if (isDeleted) {
            serverMsg = NOTE_DELETED_MSG;
        } else {
            serverErrMsg = SOME_NOTE_NOT_EXIST_MSG;
        }
    }

    public void showAll() {
        notesList = noteService.findAll();
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showByVendor(String vendor) {
        notesList = noteService.findByVendor(vendor);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showByPriceManufDate(double price, Date manufDate) {
        notesList = noteService.findByPriceManufDate(price, manufDate);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, String vendor) {
        notesList = noteService.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
        if (notesList == null || notesList.isEmpty()) serverErrMsg = NO_RECORDS_FOUND_MSG;
    }

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
