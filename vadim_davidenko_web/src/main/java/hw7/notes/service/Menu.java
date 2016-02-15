package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Notebook;
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

    public void main(HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("menuOption")[0];
        String id = parameterMap.get("id")[0];
        String targetPage = "";

        switch (option) {
            case "notebook":
                req.setAttribute("id", id);
                targetPage = "hw7/notebook.jsp";
                break;

            case "vendor":
                req.setAttribute("id", id);
                targetPage = "hw7/vendor.jsp";
                break;

            case "cpu":
                req.setAttribute("id", id);
                targetPage = "hw7/cpu.jsp";
                break;

            case "memory":
                req.setAttribute("id", id);
                targetPage = "hw7/memory.jsp";
                break;
        }

        if (!targetPage.isEmpty()) {
            try {
                req.getRequestDispatcher(targetPage).forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
