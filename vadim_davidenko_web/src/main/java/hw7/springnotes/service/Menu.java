package hw7.springnotes.service;

import hw7.springnotes.domain.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Вадим on 14.02.2016.
 */

@WebServlet("/menuServlet")
public class Menu extends HttpServlet {

    public final static String NOTEBOOK_PAGE = "hw7/notebook.jsp";
    public final static String VENDOR_PAGE = "hw7/vendor.jsp";
    public final static String CPU_PAGE = "hw7/cpu.jsp";
    public final static String MEMORY_PAGE = "hw7/memory.jsp";
    public final static String STORE_PAGE = "hw7/store.jsp";
    public final static String REPORTS_PAGE = "hw7/reports.jsp";
    public final static String REPORTS_LIST_PAGE = "hw7/reports_list.jsp";
    public final static String NO_SUCH_ENTITY_MSG = "Entity with such Id does not exist in database!";
    public final static String ADD_SUCCESS_MSG = "New entity added successfully";
    public final static String UPDATE_SUCCESS_MSG = "Entity data updated successfully";
    public final static String STORE_RECEIVE_MSG = "Notebooks received on Store ";
    public final static String STORE_REMOVE_MSG = "Notebooks removed from Store ";
    public final static String STORE_REMOVE_ERR_MSG = "Notebooks number to remove is greater then existent on Store ";
    public final static String SALE_STORE_MSG = "Notebooks sold from Store ";
    public final static String SALE_STORE_ERR_MSG = "Notebooks number to sale is greater then existent on Store ";

    public static NotebookService noteService;

    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/context.xml");
        noteService = context.getBean("notebookService", NotebookService.class);

//        Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
//        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//        sb.applySettings(cfg.getProperties());
//        StandardServiceRegistry standardServiceRegistry = sb.build();
//        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
//        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
//        VendorDao vendorDao = new VendorDaoImpl(sessionFactory);
//        CPUDao cpuDao = new CPUDaoImpl(sessionFactory);
//        MemoryDao memoryDao = new MemoryDaoImpl(sessionFactory);
//        StoreDao storeDao = new StoreDaoImpl(sessionFactory);
//        SalesDao salesDao = new SalesDaoImpl(sessionFactory);
//        noteService = new NotebookServiceImpl(noteDao, vendorDao, cpuDao, memDao, storeDao, salesDao);
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

        List<Vendor> vendorList = noteService.getAllVendors();
        req.setAttribute("vendorList", vendorList);
        req.getRequestDispatcher(REPORTS_PAGE).forward(req, resp);
    }

    /*
     * Add/Modify entity menu (Notebook type, Vendor, CPU, Memory)
     */
    public void entityService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("entityMenu")[0];

        List<Vendor> vendorList = noteService.getAllVendors();
        List<CPU> cpuList = noteService.getAllCPUs();
        List<Memory> memoryList = noteService.getAllMemories();

        switch (option) {
            case "notebook":
                req.setAttribute("vendorList", vendorList);
                req.setAttribute("cpuList", cpuList);
                req.setAttribute("memoryList", memoryList);
                req.getRequestDispatcher(NOTEBOOK_PAGE).forward(req, resp);
                break;
            case "vendor":
                req.getRequestDispatcher(VENDOR_PAGE).forward(req, resp);
                break;
            case "cpu":
                req.setAttribute("vendorList", vendorList);
                req.getRequestDispatcher(CPU_PAGE).forward(req, resp);
                break;
            case "memory":
                req.setAttribute("vendorList", vendorList);
                req.getRequestDispatcher(MEMORY_PAGE).forward(req, resp);
                break;
        }
    }
}
