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

    final static String NOTEBOOK_PAGE = "hw7/notebook.jsp";
    final static String VENDOR_PAGE = "hw7/vendor.jsp";
    final static String CPU_PAGE = "hw7/cpu.jsp";
    final static String MEMORY_PAGE = "hw7/memory.jsp";
    final static String REPORTS_PAGE = "hw7/reports.jsp";
    final static String STORE_PAGE = "hw7/store.jsp";
    final static String NO_SUCH_ENTITY_MSG = "Entity with such Id does not exist in database!";
    final static String ADD_SUCCESS_MSG = "New entity added successfully";
    final static String UPDATE_SUCCESS_MSG = "Entity data updated successfully";
    final static String STORE_RECEIVE_MSG = "Notebooks received on Store ";
    final static String STORE_REMOVE_MSG = "Notebooks removed from Store ";
    final static String STORE_REMOVE_ERR_MSG = "Notebooks number to remove is greater then existent on Store ";
    final static String SALE_STORE_MSG = "Notebooks sold from Store ";
    final static String SALE_STORE_ERR_MSG = "Notebooks number to sale is greater then existent on Store ";

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        main(req, resp);
    }

    /*
     * Main menu
     */
    public void main(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String menuOption = parameterMap.get("menuOption")[0];
        switch (menuOption) {
            case "entity":
                entityService(req, resp);
                break;
            case "store":
                storeService(req, resp);
                break;
            case "reports":
                reportsService(req, resp);
        }
    }

    /*
     * Go to Store menu page
     */
    public void storeService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Notebook> notebookList = noteService.getAllNotebooks();
        req.setAttribute("notebookList", notebookList);

        List<Store> storeList = noteService.getAllStores();
        req.setAttribute("storeList", storeList);

        req.getRequestDispatcher(STORE_PAGE).forward(req, resp);
    }

    /*
     * Go to Reports menu page
     */
    public void reportsService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(REPORTS_PAGE).forward(req, resp);
    }

    /*
     * Add/Modify entity menu (Notebook type, Vendor, CPU, Memory)
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
}
