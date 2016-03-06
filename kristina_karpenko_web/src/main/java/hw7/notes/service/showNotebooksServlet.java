package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Vendor;
import hw7.notes.util.Formater;
import hw7.notes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Администратор on 18.02.2016.
 */
@WebServlet("/showNotebooksServlet")
public class showNotebooksServlet extends HttpServlet {

    private  SessionFactory factory;
    private Session session = null;
    private NotebookDao notebookDao;
    private NotebookService notebookService;
    private VendorDao vendorDao;
    private SalesDao salesDao;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        notebookDao = new NotebookDaoImpl(factory);
        notebookService = new NotebookServiceImpl(notebookDao);
        vendorDao = new VendorDaoImpl(factory);
        salesDao = new SalesDaoImpl(factory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String all = req.getParameter("all");
        String byAm = req.getParameter("byAm");
        String amStr = req.getParameter("am");
        String byAmount = req.getParameter("byAmount");
        String amountStr = req.getParameter("amount");
        String cpuVendor = req.getParameter("cpuVendor");
        String byCpuVendor = req.getParameter("byCpuVendor");
        String byOrderVendor = req.getParameter("byOrderVendor");
        String sales = req.getParameter("sales");

        if (all != null) {
            //   resp.getWriter().print(Formater.getString(notebookService.getNotebooksFromStore()));
            resp.getWriter().print(notebookDao.findAll());
        }
        if (byAm != null) {
            int am = Integer.parseInt(amStr);

            req.setAttribute("size",Formater.getString(notebookService.getNotebooksGtAmount(am)));
         //     resp.getWriter().print(Formater.getString(notebookService.getNotebooksGtAmount(am)));
           req.getRequestDispatcher("findBYPortion.jsp").forward(req, resp);
        }
        if (byAmount != null) {
            int amount = Integer.parseInt(amountStr);
            resp.getWriter().print(Formater.getString(notebookService.getNotebooksGtAmount(amount)));
        }
        if (byCpuVendor != null) {
            Vendor vendor = vendorDao.findVendorByName(cpuVendor);
            resp.getWriter().print(Formater.getString(notebookService.getNotebooksByCpuVendor(vendor)));
        }
        if (byOrderVendor != null) {
            resp.getWriter().print(Formater.getString(notebookService.getNotebooksStorePresent()));
        }
        if (sales != null) {
            notebookService = new NotebookServiceImpl(salesDao);
            resp.getWriter().print(notebookService.getSalesByDays());
        }
    }
}
