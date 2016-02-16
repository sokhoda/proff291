package hw7.view;

import hw7.dao.*;
import hw7.service.NotebookService;
import hw7.service.NotebookServiceImpl;
import hw7.util.HiberSessionFactory;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@WebServlet("/notebooksAdvancedForm")
public class Menu extends HttpServlet {

    HiberSessionFactory sessionFactor = new HiberSessionFactory();

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = sessionFactor.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        CPUDao cpuDao = new CPUDaoImpl(sessionFactory);
        VendorDao vendorDao = new VendorDaoImpl(sessionFactory);
        MemoryDao memoryDao = new MemoryDaoImpl(sessionFactory);
        SalesDao salesDao = new SalesDaoImpl(sessionFactory);
        StoreDao storeDao = new StoreDaoImpl(sessionFactory);

        NotebookService notebookService = new NotebookServiceImpl(notebookDao, cpuDao, memoryDao, vendorDao, salesDao, storeDao);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("addOption");
        String message = "Operation was done successfully";
        String pageAddress = "/notesAdvanced.jsp";

        switch (option) {
            case "cpu":

                pageAddress = "/hw7/addCPU.jsp";
                message = "Add cpu";
                break;
            case "memory":
                pageAddress = "/hw7/addMemory.jsp";
                message = "Add memory";

                break;
            case "vendor":
                pageAddress = "/hw7/addVendor.jsp";
                message = "Add vendor";
                break;
            case "notebook":
                pageAddress = "/hw7/addNotebook.jsp";
                message = "Add notebook";
                break;
            default:
                break;
        }


        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, response);

    }
}
