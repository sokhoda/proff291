package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 14.02.2016.
 */

@WebServlet("/menuServlet")
public class Menu extends HttpServlet {

    final static String MENU_PAGE = "hw7/menu.jsp";
    final static String ENTITIES_PAGES_PATH = "hw7/entity/";
    final static String REPORTS_PAGE_PATH = "hw7/reports/";
    final static String STORE_PAGE_PATH = "hw7/store/";

    NotebookService noteService;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        VendorDao vendorDao = new VendorDaoImpl(sessionFactory);
        CPUDao cpuDao = new CPUDaoImpl(sessionFactory);
        MemoryDao memoryDao = new MemoryDaoImpl(sessionFactory);
        StoreDao storeDao = new StoreDaoImpl(sessionFactory);
        SalesDao salesDao = new SalesDaoImpl(sessionFactory);

        noteService = new NotebookServiceImpl(notebookDao, vendorDao, cpuDao, memoryDao, storeDao, salesDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        main(req, resp);
    }

    /*
     * Главное меню
     */
    public void main(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String menuOption = parameterMap.get("menuOption")[0];
        switch (menuOption) {
            case "entity_new":
                entityNewService(req, resp);
                break;
            case "entity_edit":
                entityEditService(req, resp);
                break;
            case "receive":
                receiveService(req, resp);
                break;
            case "remove":
                removeService(req, resp);
                break;
            case "sale":
                salesService(req, resp);
                break;
            case "report":
                reportService(req, resp);
                break;
        }
    }

    /*
     * Добавить процессор
     * Добавить память
     * Добавить имя производителя
     * Добавить тип ноутбука
     */
    public void entityNewService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("entityMenu")[0];

        switch (option) {
            case "notebook":
                List<Vendor> vendorList = noteService.getAllVendors();
                List<CPU> cpuList = noteService.getAllCPUs();
                List<Memory> memoryList = noteService.getAllMemories();

                req.setAttribute("vendorId", "");
                req.setAttribute("vendorList", vendorList);
                req.setAttribute("cpuId", "");
                req.setAttribute("cpuList", cpuList);
                req.setAttribute("memoryId", "");
                req.setAttribute("memoryList", memoryList);

                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "notebook.jsp").forward(req, resp);
                break;

            case "vendor":
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "vendor.jsp").forward(req, resp);
                break;

            case "cpu":
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "cpu.jsp").forward(req, resp);
                break;

            case "memory":
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "memory.jsp").forward(req, resp);
                break;
        }
    }

    /*
     * Изменить процессор
     * Изменить память
     * Изменить имя производителя
     * Изменить тип ноутбука
     */
    public void entityEditService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("entityMenu")[0];
        Long id = Long.valueOf(parameterMap.get("entityId")[0]);

        switch (option) {
            case "notebook":
                Notebook notebook = noteService.getNotebookById(id);
                if (notebook == null) {
                    req.setAttribute("entity_msg", "Notebook with such Id does not exist in database!");
                    req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
                    break;
                }
                List<Vendor> vendorList = noteService.getAllVendors();
                List<CPU> cpuList = noteService.getAllCPUs();
                List<Memory> memoryList = noteService.getAllMemories();

                req.setAttribute("model", notebook.getModel());
                req.setAttribute("date", notebook.getManufactureDateStr());
                req.setAttribute("vendorId", String.valueOf(notebook.getVendor().getId()));
                req.setAttribute("vendorList", vendorList);
                req.setAttribute("cpuId", String.valueOf(notebook.getCpu().getId()));
                req.setAttribute("cpuList", cpuList);
                req.setAttribute("memoryId", String.valueOf(notebook.getMemory().getId()));
                req.setAttribute("memoryList", memoryList);

                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "notebook.jsp").forward(req, resp);
                break;

            case "vendor":
                Vendor vendor = noteService.getVendorById(id);
                if (vendor == null) {
                    req.setAttribute("entity_msg", "Vendor with such Id does not exist in database!");
                    req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
                    break;
                }
                req.setAttribute("vendor", vendor.getName());
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "vendor.jsp").forward(req, resp);
                break;

            case "cpu":
                CPU cpu = noteService.getCPUById(id);
                if (cpu == null) {
                    req.setAttribute("entity_msg", "CPU with such Id does not exist in database!");
                    req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
                    break;
                }
                req.setAttribute("model", cpu.getModel());
                req.setAttribute("vendor", cpu.getVendor());
                req.setAttribute("frequency", cpu.getFrequency());
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "cpu.jsp").forward(req, resp);
                break;

            case "memory":
                Memory memory = noteService.getMemoryById(id);
                if (memory == null) {
                    req.setAttribute("entity_msg", "Memory with such Id does not exist in database!");
                    req.getRequestDispatcher(MENU_PAGE).forward(req, resp);
                    break;
                }
                req.setAttribute("vendor", memory.getVendor());
                req.setAttribute("size", memory.getSize());
                req.getRequestDispatcher(ENTITIES_PAGES_PATH + "memory.jsp").forward(req, resp);
                break;
        }
    }

    /*
     * Принять на склад партию ноутбуков (id ноутбука, количество, цена)
     */
    public void receiveService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long noteId = Long.valueOf(parameterMap.get("noteIdReceive")[0]);
        Integer amountReceive = Integer.valueOf(parameterMap.get("amountReceive")[0]);
        Double priceReceive = Double.valueOf(parameterMap.get("priceReceive")[0]);



    }

    /*
     * Списать со склада ноутбуки (ключ, количество)
     */
    public void removeService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long storeId = Long.valueOf(parameterMap.get("storeIdRemove")[0]);
        Integer amountRemove = Integer.valueOf(parameterMap.get("amountRemove")[0]);


    }

    /*
     * Продать указанное количество ноутбуков со склада(id склада, количество)
     */
    public void salesService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long storeId = Long.valueOf(parameterMap.get("storeIdSale")[0]);
        Integer amountSale = Integer.valueOf(parameterMap.get("amountSale")[0]);



    }

    /*
     * Показать все ноутбуки на складе (пользователь указывает размер порции)
     * Показать все ноутбуки которых больше указанного количества
     * Показать все ноутбуки по указанному имени производителя процессора
     * Показать все ноутбуки на складе
     * Показать типы ноутбуков, оставшиеся на складе по каждому производителю
     * Получить объем продаж ноутбуков в среднем за день (в штуках)
     */
    public void reportService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("reportMenu")[0];

        switch (option) {
            case "byPortion":
                Integer portion = Integer.parseInt(parameterMap.get("portion")[0]);


                break;

            case "gtAmount":
                Integer gtAmount = Integer.parseInt(parameterMap.get("gtAmount")[0]);


                break;

            case "byCPU":
                String cpuVendor = parameterMap.get("cpuVendor")[0];

                break;

            case "storeAll":

                break;

            case "storePresent":

                break;

            case "salesByDays":

                break;
        }
        req.getRequestDispatcher(REPORTS_PAGE_PATH + "report.jsp").forward(req, resp);
    }
}
