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
 * Created by i.gonchar on 2/17/2016.
 */
@WebServlet("/notebooksAdvancedMain")
public class Main extends HttpServlet {

    HiberSessionFactory sessionFactor = new HiberSessionFactory();
    public static  NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = sessionFactor.getSessionFactory();
        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        CPUDao cpuDao = new CPUDaoImpl(sessionFactory);
        VendorDao vendorDao = new VendorDaoImpl(sessionFactory);
        MemoryDao memoryDao = new MemoryDaoImpl(sessionFactory);
        SalesDao salesDao = new SalesDaoImpl(sessionFactory);
        StoreDao storeDao = new StoreDaoImpl(sessionFactory);

        notebookService = new NotebookServiceImpl(notebookDao, cpuDao, memoryDao, vendorDao, salesDao, storeDao);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("reg_result", "");
        String pageAddress = "/hw7/notesAdvanced.jsp";
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }
}
