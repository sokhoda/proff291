package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
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
    final static String NOTEBOOK_PAGE = "hw7/entity/notebook.jsp";
    final static String VENDOR_PAGE = "hw7/entity/vendor.jsp";
    final static String CPU_PAGE = "hw7/entity/cpu.jsp";
    final static String MEMORY_PAGE = "hw7/entity/memory.jsp";
    final static String REPORTS_PAGE = "hw7/reports/report.jsp";
    final static String NO_SUCH_ENTITY_MSG = "Entity with such Id does not exist in database!";
    final static String UPDATE_SUCCESS_MSG = "Data updated successfully";

    public static NotebookService noteService;

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
            case "entity":
                entityService(req, resp);
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
            case "reports":
                req.getRequestDispatcher(REPORTS_PAGE).forward(req, resp);
                break;
        }
    }

    /*
     * Добавить/Изменить процессор
     * Добавить/Изменить память
     * Добавить/Изменить имя производителя
     * Добавить/Изменить тип ноутбука
     */
    public void entityService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("entityMenu")[0];

        switch (option) {
            case "notebook":
                List<Vendor> vendorList = noteService.getAllVendors();
                req.setAttribute("vendorList", vendorList);

                List<CPU> cpuList = noteService.getAllCPUs();
                req.setAttribute("cpuList", cpuList);

                List<Memory> memoryList = noteService.getAllMemories();
                req.setAttribute("memoryList", memoryList);

                List<Store> storeList = noteService.getAllStores();
                req.setAttribute("storeList", storeList);

                req.getRequestDispatcher(NOTEBOOK_PAGE).forward(req, resp);
                break;
            case "vendor":
                req.getRequestDispatcher(VENDOR_PAGE).forward(req, resp);
                break;
            case "cpu":
                req.getRequestDispatcher(CPU_PAGE).forward(req, resp);
                break;
            case "memory":
                req.getRequestDispatcher(MEMORY_PAGE).forward(req, resp);
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
        Long noteId = Long.valueOf(parameterMap.get("noteIdRemove")[0]);
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
}
